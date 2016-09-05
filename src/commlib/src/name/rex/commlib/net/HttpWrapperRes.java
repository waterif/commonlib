package name.rex.commlib.net;

import java.util.List;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

import name.rex.commlib.net.HttpWrapperHeader;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

public class HttpWrapperRes
{
    private static Logger log = LoggerFactory.getLogger( HttpWrapperRes.class );

    public static final int FLAG_RETURN_HEADER  = 0x01;
    public static final int FLAG_PROCESS_DATA   = 0x02;
    public static final int FLAG_NO_DECOMPRESS  = 0x04;

    private int     flags = 0;
    public  int     status;
    public  String  reason;
    public boolean  isText;
    public String   type;
    public String   charset;
    public String   content;
    public byte[]   data;
    public List<HttpWrapperHeader> headers;
    private HttpWrapperCallback callback;

    public HttpWrapperRes()
    {
    }

    public boolean isValidStatus()
    {
        if ( 200 <= status && 300 > status )
        {
            return true;
        }

        return false;
    }

    public String getHeaderValue( String name )
    {
        HttpWrapperHeader h = getHeader( name );
        
        if( null != h )
        {
            return h.value;
        }

        return null;
    }

    public HttpWrapperHeader getHeader( String name )
    {
        if( null != headers )
        {
            for( HttpWrapperHeader h: headers )
            {
                if ( null != h.name && h.name.equalsIgnoreCase( name ) )
                {
                    return h;
                }
            }
        }

        return null;
    }

    public List<HttpWrapperHeader> getHeaders( String name )
    {
        List<HttpWrapperHeader> res = null;

        if( null != headers )
        {
            for( HttpWrapperHeader h: headers )
            {
                if ( null != h.name && h.name.equalsIgnoreCase( name ) )
                {
                    if ( null == res )
                    {
                        res = new ArrayList<HttpWrapperHeader>();
                    }
                   
                    HttpWrapperHeader nh = new HttpWrapperHeader( h.name, h.value );
                    res.add( nh );
                }
            }
        }

        return res;
    }

    public List<String> getHeaderValues( String name )
    {
        List<String> res = null;

        if( null != headers )
        {
            for( HttpWrapperHeader h: headers )
            {
                if ( null != h.name && h.name.equalsIgnoreCase( name ) )
                {
                    if ( null == res )
                    {
                        res = new ArrayList<String>();
                    }
                   
                    res.add( h.value );
                }
            }
        }

        return res;
    }

    public String getForceContent()
    {
        if ( null == content && null != data && data.length > 0 )
        {
            try
            {
                content = new String( data, 
                        ( null == charset || charset.isEmpty() ) 
                            ? "utf-8" : charset );

                log.debug( " resposne content from binrary data: " + content );
            }
            catch( Exception e )
            {
            }
        }

        return content;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    private static List<HttpWrapperHeader> getResponseHeaders( HttpResponse response )
    {
        List<HttpWrapperHeader> res = null;
        Header[] hds = response.getAllHeaders();

        if ( null != hds )
        {
            res = new ArrayList<HttpWrapperHeader>();

            for( Header h: hds )
            {
                HttpWrapperHeader wh = new HttpWrapperHeader( h.getName(), h.getValue() );
                res.add( wh );
            }
        }

        return res;
    }

    public static HttpWrapperRes processResponse( HttpResponse response, int flags, HttpWrapperCallback callback )
    {
        HttpWrapperRes res = new HttpWrapperRes();

        // 处理状态行
        res.flags = flags;
        res.status = response.getStatusLine().getStatusCode();
        res.reason = response.getStatusLine().getReasonPhrase();

        // 处理头
        if ( 0 != ( flags & FLAG_RETURN_HEADER ) )
        {
            res.headers = getResponseHeaders( response );
        }
       
        // 处理答复内容
        try
        {
            HttpEntity entity = response.getEntity();
            ContentType type = ContentType.get( entity );

            // 处理类型与字符集
            if ( null != type )
            {
                Charset charset = type.getCharset();

                if( null != charset )
                {
                    res.charset = charset.displayName();
                }

                res.type = type.getMimeType();
                res.isText = MimeHelper.isText( res.type );
            }

            if ( 0 == ( flags & FLAG_NO_DECOMPRESS ) )
            {
                // 解压缩
                Header encodingHeader = entity.getContentEncoding();

                if ( null != encodingHeader )
                {
                    String value = encodingHeader.getValue();
                    if ( null != value )
                    {
                        if ( value.equalsIgnoreCase( "gzip" ) )
                        {
                            log.debug( "gzip uncompress data" );
                            entity = new GzipDecompressingEntity( entity );
                        }
                    }
                }
            }

            if ( 0 != ( flags & FLAG_PROCESS_DATA ) )
            {
                log.debug( ">>>> begin convert data for process data >>>>" );

                if ( res.isText )
                {
                    res.content = EntityUtils.toString( entity, 
                            ( null != res.charset && ! res.charset.isEmpty() ) ? res.charset : "utf-8" );
                }
                else
                {
                    res.data = EntityUtils.toByteArray( entity );
                }
            }
            else
            {
                log.debug( ">>> begin call callback for process data >>>" );

                if ( null != callback )
                {
                    callback.processData( res, entity.getContent() );
                }
            }
           
            log.debug( ">>> end process data >>>>" );
        }
        catch( Exception e )
        {
            String errMsg = "process entity content fail: " + e.getMessage();

            log.error( errMsg, e );
            HttpWrapper.setError( errMsg );
        }

        return res;
    }
}
