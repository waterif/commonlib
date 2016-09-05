package com.quanshi.uclib.service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.LinkedHashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.apache.http.entity.ContentProducer;
import org.apache.http.entity.EntityTemplate;

import name.rex.commlib.net.HttpWrapperCallback;
import name.rex.commlib.net.HttpWrapper;
import name.rex.commlib.net.HttpWrapperRes;
import name.rex.commlib.net.HttpWrapperHeader;
import name.rex.commlib.net.HttpWrapperHeaderBuilder;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import name.rex.commlib.security.MessageDigestHelper;
import name.rex.commlib.io.IOHelper;
import name.rex.commlib.format.JSONHelper;

interface IUploadContentProducer extends ContentProducer
{
    public long getContentLength();
}

class UploadContentProducer implements IUploadContentProducer
{
    private int userId;
    private String sessionId;
    private Integer appId;
    private String name;
    private String md5;
    private long size = -1;
    private long offset = 0;
    private Boolean convert = null;
    private InputStream  contentIS = null;
    private byte[] prefix = null;

    public UploadContentProducer( int userId, String sessionId, Integer appId, 
            String name, String md5, long size, 
            long offset, Boolean convert, InputStream contentIS )
    {
        this.userId = userId;
        this.sessionId = sessionId;
        this.appId = appId;
        this.name = name;
        this.md5 = md5;
        this.size = size;
        this.offset = offset;
        this.convert = convert;
        this.contentIS = contentIS;
    }

    private void getPrefix() throws IOException
    {
        if ( null != prefix )
        {
            return;
        }

        Map<String, Object> params = new LinkedHashMap<String, Object>();

        if ( null != appId )
        {
            params.put( "a", appId );
        }

        params.put( "u", userId );

        if ( ! StringUtils.isBlank( sessionId ) )
        {
            params.put( "k", sessionId );
        }

        params.put( "off", offset );
        params.put( "len", size );
        params.put( "md5", md5 );
        params.put( "nam", name );
        
        if ( null != convert )
        {
            params.put( "cov", convert ? 1 : 0 );
        }

        params.put( "data", "" );

        String s = HttpWrapper.buildQuery( params );

        if ( null == s )
        {
            throw new IOException( "build url encode prefix failed." );
        }

        try
        {
            prefix = s.getBytes( "UTF-8" );
        }
        catch( Exception e )
        {
            throw new IOException( e );
        }
    }

    @Override
	public void writeTo( OutputStream outputStream ) throws IOException 
	{
        getPrefix();

        if ( null == prefix )
        {
            throw new IOException( "cannot get prefix for fs service upload" );
        }
        
        outputStream.write( prefix );

        contentIS.reset();
        contentIS.skip( offset );

        IOHelper.writeTo( contentIS, outputStream );
    }

    @Override
    public long getContentLength()
    {
        try
        {
            getPrefix();
        }
        catch( Exception e )
        {

        }

        if ( size > 0 && null != prefix && size - offset > 0 )
        {
            return prefix.length + size - offset;
        }

        return -1;
    }
}

class UploadEntity extends EntityTemplate
{
    private IUploadContentProducer cp = null;

    public UploadEntity( IUploadContentProducer cp )
    {
        super( cp );
        this.cp = cp;
    }

    @Override
    public long getContentLength()
    {
        return cp.getContentLength();
    }

    @Override
    public Header getContentType()
    {
        return new BasicHeader( "Content-Type", "application/octet-stream;charset=UTF-8" );
    }
}

public class FSService extends ServiceBase
{
    ///////////////////////////////////////////////////////////////////////////////
    public static class CheckResult
    {
        public boolean  result;
        public int      errorCode;
        public String   fileId;
        public Long     fileSize;
        public Long     fileOffset;
        public String   fileIndex;
    }

    public static class UploadResult
    {
        public boolean  result;
        public int      errorCode;
        public String   fileId;
        public String   thumbFileId;
        public String   filePath;
        public String   fileName;
    }

    public static class DownloadResult
    {
        public static String fileId;
        public static Long   fileSize;
        public static String contentType;
        public static String fileName;
        public static byte[] data;
    }

    public static interface DownloadCallback
    {
        public void processDownload( DownloadResult result, InputStream inputStream ) throws Exception;
    }

    public static class DownloadHttpWrapperCallback implements HttpWrapperCallback
    {
        private static Logger log = LoggerFactory.getLogger( DownloadHttpWrapperCallback.class );

        public String fileId = null;
        public DownloadCallback downloadCallback = null;
        public ServiceException throwException = null;
        public DownloadResult result = null;

        public DownloadHttpWrapperCallback( String fileId, DownloadCallback downloadCallback )
        {
            this.fileId = fileId;
            this.downloadCallback = downloadCallback;
        }

        public void processData( HttpWrapperRes httpRes, InputStream inputStream )
        {
            if ( null == httpRes )
            {
                throwException = new ServiceException( ServiceException.ERROR_NETWORK, 
                        HttpWrapper.getError() );
            }

            if ( ! httpRes.isValidStatus() )
            {
                throwException = new ServiceException( ServiceException.ERROR_STATUS, 
                        "http response code is not 2xx - " + httpRes.status );
                return;
            }

            String value;
 
            // fileId
            result = new DownloadResult();
            result.fileId = fileId;
          
            // fileSize
            value = httpRes.getHeaderValue( "File-Length" );
            if ( ! StringUtils.isBlank( value ) )
            {
                result.fileSize = Long.valueOf( value.trim() );
            }
   
            // fileName
            HttpWrapperHeader dispositionHeader = httpRes.getHeader( "Content-Disposition" );
    
            value = ( null != dispositionHeader )
                    ? dispositionHeader.getParameterIgnoreCase( "filename" ) : null;
            if ( null != value )
            {
                result.fileName = value;
            }
   
            // fileType
            result.contentType = httpRes.type;

            try
            {
                // fileData
                if ( null != downloadCallback )
                {
                    downloadCallback.processDownload( result, inputStream );
                }
                else
                {
                    result.data = IOHelper.readByte( inputStream );
                }
            }
            catch( Exception e )
            {
                throwException = new ServiceException( ServiceException.ERROR_DATA,
                        "recv/send data failed: " + e.getMessage() );
            }

            // debug log
            if ( log.isDebugEnabled() )
            {
                StringBuilder debugInfo = new StringBuilder();
    
                debugInfo.append( "fileId=" ).append( result.fileId )
                    .append( ", fileSize=" ).append( result.fileSize )
                    .append( ",contentType=" ).append( result.contentType )
                    .append( ",fileName=" ).append( result.fileName );
    
                log.debug( "download result: " + debugInfo.toString() );
            }
        }
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    private static Logger log = LoggerFactory.getLogger( FSService.class );

	private static final String URL_PREFIX = "/ucfserver";
	private static final String FILE_UPLOAD = URL_PREFIX + "/hdup";
	private static final String FILE_CHECK  = URL_PREFIX + "/hdchk";
	private static final String FILE_DOWNLOAD = URL_PREFIX + "/hddown";

    private String serverUrl;

    public FSService( String serverUrl )
    {
        this.serverUrl = serverUrl;
    }

    public static String getFileContentMd5( InputStream is )
    {
        try
        {
            is.reset();
        }
        catch( Exception e )
        {
            log.warn( "reset file stream failed." );
        }

        return MessageDigestHelper.md5String( is );
    }

    public static String getFileContentMd5( byte[] fileData )
    {
        return getFileContentMd5( new ByteArrayInputStream( fileData ) );
    }

    public CheckResult check( int userId, String sessionId, Integer appId, 
            String fileName, String fileMD5, long fileSize ) 
        throws ServiceException
    {
        // 检查参数
        if ( StringUtils.isBlank( fileName ) || fileSize <= 0 
                || StringUtils.isBlank( fileMD5 ) )
        {
            throw new ServiceException( ServiceException.ERROR_INVAL, "invalid arguments" );
        }

        Map<String, String> params = new LinkedHashMap<String, String>();

        if ( null != appId )
        {
            params.put( "a", String.valueOf( appId ) );
        }

        params.put( "u", String.valueOf( userId ) );
        
        if( ! StringUtils.isBlank( sessionId ) ) 
        {
            params.put( "k", sessionId );
        }

        params.put( "nam", fileName );
        params.put( "len", String.valueOf( fileSize ) );
        params.put( "md5", fileMD5 );

        HttpWrapperHeaderBuilder requestHeader = new HttpWrapperHeaderBuilder();

        requestHeader.addHeader( "User-Agent", "On prem fileserver 1.0" );

        String url = HttpWrapper.buildURL( serverUrl + FILE_CHECK, params );
        HttpWrapperRes httpRes = HttpWrapper.get( url, requestHeader.getHeaderList(), true );

        if ( null == httpRes )
        {
            throw new ServiceException( ServiceException.ERROR_NETWORK, 
                    "network comunication fail" );
        }

        if ( ! httpRes.isValidStatus() )
        {
            throw new ServiceException( ServiceException.ERROR_STATUS, 
                    "http response code is not 2xx - " + httpRes.status );
        }

        String value; 
        CheckResult res = new CheckResult();

        value = httpRes.getHeaderValue( "X-Tang-Result" );
        if ( StringUtils.isBlank( value )
                || ! "0".equals( value.trim() ) )
        {
            res.result = false;
        }
        else
        {
            res.result = true;
        }

        value = httpRes.getHeaderValue( "Cookie" );
        if ( ! StringUtils.isBlank( value ) )
        {
            res.fileIndex = value;
        }

        if ( res.result )
        {
            value = httpRes.getHeaderValue( "X-Tang-File-Id" );
            if ( ! StringUtils.isBlank( value ) )
            {
                res.fileId = value.trim();
            }

            value = httpRes.getHeaderValue( "X-Tang-File-Length" );
            if( ! StringUtils.isBlank( value ) )
            {
                res.fileSize = Long.valueOf( value.trim() ); 
            }

            value = httpRes.getHeaderValue( "X-Tang-File-Offset" );
            if( ! StringUtils.isBlank( value ) )
            {
                res.fileOffset = Long.valueOf( value.trim() ); 
            }
        }
        else
        {
            value = httpRes.getHeaderValue( "X-Tang-Error-Code" );
            if ( ! StringUtils.isBlank( value ) )
            {
                res.errorCode = Integer.valueOf( value.trim() );
            }
        }

        log.debug( "check result: " + JSONHelper.toJSONString( res ) );

        return res;
    }

    public CheckResult check( int userId, String sessionId, Integer appId, 
            String fileName, long fileSize, InputStream contentIS )
        throws ServiceException
    {
        if ( StringUtils.isBlank( fileName ) || null == contentIS 
                || fileSize <= 0 )
        {
            throw new ServiceException( ServiceException.ERROR_INVAL, "invalid arguments" );
        }

        String md5 = getFileContentMd5( contentIS );

        return check( userId, sessionId, appId, fileName, md5, fileSize );
    }

    public CheckResult check( int userId, String sessionId, Integer appId, 
            String fileName, byte data[] )
        throws ServiceException
    {
        if ( StringUtils.isBlank( fileName ) || null == data 
                || data.length <= 0 )
        {
            throw new ServiceException( ServiceException.ERROR_INVAL, "invalid arguments" );
        }

        return check( userId, sessionId, appId, fileName, data.length,
                new ByteArrayInputStream( data ) ); 
    }

    public UploadResult _upload( int userId, String sessionId, Integer appId, 
            String fileName, String fileMD5, 
            long fileSize, InputStream contentIS,
            long offset, String fileIndex, Boolean convert ) 
        throws ServiceException
    {
        // 检查参数
        if ( StringUtils.isBlank( fileName ) || fileSize <= 0 
                || StringUtils.isBlank( fileMD5 ) || null == contentIS )
        {
            throw new ServiceException( ServiceException.ERROR_INVAL, "invalid arguments" );
        }

        String url = serverUrl + FILE_UPLOAD;
        HttpWrapperHeaderBuilder requestHeader = new HttpWrapperHeaderBuilder();

        requestHeader.addHeader( "User-Agent", "On prem fileserver 1.0" );
        requestHeader.addHeader( "Connection", "Keep-Alive" );

        if ( StringUtils.isBlank( fileIndex ) )
        {
            requestHeader.addHeader( "Cookie", fileIndex + ";" );
        }

        UploadContentProducer cp = new UploadContentProducer( userId, sessionId, appId,
                fileName, fileMD5, fileSize, offset, convert, contentIS );
        UploadEntity entity = new UploadEntity( cp );

        HttpWrapperRes httpRes = HttpWrapper.request( "POST", url, entity, requestHeader.getHeaderList(), true );

        if ( null == httpRes )
        {
            throw new ServiceException( ServiceException.ERROR_NETWORK, 
                    "network comunication fail" );
        }

        if ( ! httpRes.isValidStatus() )
        {
            throw new ServiceException( ServiceException.ERROR_STATUS, 
                    "http response code is not 2xx - " + httpRes.status );
        }

        String value;
        UploadResult res = new UploadResult();

        value = httpRes.getHeaderValue( "X-Tang-Result" );
        if ( StringUtils.isBlank( value )
                || ! "0".equals( value.trim() ) )
        {
            res.result = false;
        }
        else
        {
            res.result = true;
        }

        if ( res.result )
        {
            value = httpRes.getHeaderValue( "X-Tang-File-Id" );
            if ( ! StringUtils.isBlank( value ) )
            {
                res.fileId = value.trim();
            }

            value = httpRes.getHeaderValue( "X-Tang-File-Path" );
            if ( ! StringUtils.isBlank( value ) )
            {
                res.filePath = value.trim();
            }

            value = httpRes.getHeaderValue( "X-Tang-File-Name" );
            if ( ! StringUtils.isBlank( value ) )
            {
                res.fileName = value.trim();
            } 

            value = httpRes.getHeaderValue( "X-Tang-File-Thumbnail-Id" );
            if ( ! StringUtils.isBlank( value ) )
            {
                res.thumbFileId = value.trim();
            }
        }
        else
        {
            value = httpRes.getHeaderValue( "X-Tang-Error-Code" );
            if ( ! StringUtils.isBlank( value ) )
            {
                res.errorCode = Integer.valueOf( value.trim() );
            }
        }

        log.debug( "upload result: " + JSONHelper.toJSONString( res ) );

        return res;
    }

    public UploadResult upload( int userId, String sessionId, Integer appId, 
            String fileName, String fileMD5, 
            long fileSize, InputStream contentIS, Boolean convert ) 
        throws ServiceException
    {
        // 检查参数
        if ( StringUtils.isBlank( fileName ) || fileSize <= 0  || null == contentIS )
        {
            throw new ServiceException( ServiceException.ERROR_INVAL, "invalid arguments" );
        }

        if ( null == fileMD5 )
        {
            fileMD5 = getFileContentMd5( contentIS );
        }

        CheckResult checkResult = check( userId, sessionId, appId,
                fileName, fileMD5, fileSize );

        if( checkResult.result 
                && ! StringUtils.isBlank( checkResult.fileId )
                && checkResult.fileOffset >= fileSize )
        {
            UploadResult result = new UploadResult();

            result.result = true;
            result.fileId = checkResult.fileId;
            result.fileName = fileName;

            return result;
        }

        long offset = ( checkResult.result ) ? checkResult.fileOffset : 0;

        return _upload( userId, sessionId, appId, 
                fileName, fileMD5, 
                fileSize, contentIS,
                offset, checkResult.fileIndex, convert );
    }

    public UploadResult upload( int userId, String sessionId, Integer appId, 
            String fileName, String fileMD5, 
            byte[] content, Boolean convert ) 
        throws ServiceException
    {
        // 检查参数
        if ( StringUtils.isBlank( fileName ) || null == content  || 0 == content.length )
        {
            throw new ServiceException( ServiceException.ERROR_INVAL, "invalid arguments" );
        }

        ByteArrayInputStream contentIS = new ByteArrayInputStream( content );
        
        return upload( userId, sessionId, appId, fileName, fileMD5, 
                    content.length, contentIS, convert );
    }

    public DownloadResult download( int userId, String sessionId, 
            String fileId, long offset, Long length, Boolean convert,
            DownloadCallback downloadCallback ) 
        throws ServiceException
    {
        // 检查参数
        if ( StringUtils.isBlank( fileId ) )
        {
            throw new ServiceException( ServiceException.ERROR_INVAL, "invalid arguments" );
        }

        Map<String, Object> params = new LinkedHashMap<String, Object>();
        HttpWrapperHeaderBuilder requestHeader = new HttpWrapperHeaderBuilder();

        params.put( "u", userId );

        if ( null != sessionId )
        {
            params.put( "k", sessionId );
        }
        
        params.put( "fid", fileId );
        params.put( "off", offset );

        if ( null != length )
        {
            params.put( "len", length );
        }

        if ( null != convert )
        {
            params.put( "cov", convert ? 1 : 0 );
        }

        // 构建请求头
        requestHeader.addHeader( "User-Agent", "On prem fileserver 1.0" );
        requestHeader.addHeader( "Connection", "Keep-Alive" );
        requestHeader.addHeader( "Charset", "UTF-8" );

        String url = HttpWrapper.buildURL( serverUrl + FILE_DOWNLOAD, params );
        DownloadHttpWrapperCallback downloadHttpWrapperCallback = 
            new DownloadHttpWrapperCallback( fileId, downloadCallback );
        HttpWrapperRes httpRes = HttpWrapper.get( url, requestHeader.getHeaderList(), 
                HttpWrapperRes.FLAG_RETURN_HEADER, downloadHttpWrapperCallback );

        if ( null == httpRes )
        {
            throw new ServiceException( ServiceException.ERROR_NETWORK,
                    "network communication fail: " + HttpWrapper.getError() );
        }

        if ( null != downloadHttpWrapperCallback.throwException )
        {
            throw downloadHttpWrapperCallback.throwException;
        }

        DownloadResult result = downloadHttpWrapperCallback.result;

        if ( null != result && log.isDebugEnabled() )
        {
            StringBuilder debugInfo = new StringBuilder();

            debugInfo.append( "fileId=" ).append( result.fileId )
                .append( ", fileSize=" ).append( result.fileSize )
                .append( ",contentType=" ).append( result.contentType )
                .append( ",fileName=" ).append( result.fileName );

            log.debug( "download result: " + debugInfo.toString() );
        }

        return downloadHttpWrapperCallback.result;
    }
}
