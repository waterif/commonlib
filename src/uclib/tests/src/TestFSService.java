import java.io.InputStream;
import java.io.FileOutputStream;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.single.SingleJUnitTestRunner;
import org.apache.commons.lang.StringUtils;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import name.rex.commlib.io.FileHelper;
import name.rex.commlib.format.JSONHelper;
import name.rex.commlib.io.IOHelper;

import com.quanshi.uclib.service.FSService;
import com.quanshi.uclib.service.FSService.CheckResult;
import com.quanshi.uclib.service.FSService.UploadResult;
import com.quanshi.uclib.service.FSService.DownloadResult;
import com.quanshi.uclib.service.FSService.DownloadCallback;

class TestFSServiceDownload implements DownloadCallback
{
    private static Logger log = LoggerFactory.getLogger( TestFSServiceDownload.class );

    public void processDownload( DownloadResult result, InputStream inputStream )
        throws Exception
    {
            String fileName = "download/" + System.currentTimeMillis() + "-"
                    + ( StringUtils.isBlank( result.fileName ) 
                    ? "noname.dat" : result.fileName );
            FileOutputStream out = new FileOutputStream( fileName );
            
            IOHelper.writeTo( inputStream, out );
            out.close();

            log.debug( "download file: " + fileName );
    }
}

public class TestFSService
{
    private static Logger log = LoggerFactory.getLogger( TestFSService.class );

    public FSService fsService = null;
    public String    fileName = "test.jpg";
    public byte[]    fileData = null;

    @Before
    public void before()
    {
        String fileName = SingleJUnitTestRunner.caseArgs.get( "fileName" );

        log.debug( "caseArgs: " + JSONHelper.toJSONString( SingleJUnitTestRunner.caseArgs ) );

        if ( ! StringUtils.isBlank( fileName ) )
        {
            this.fileName = fileName;
        }

        fsService = new FSService( "http://testcloudb.quanshi.com" );
        fileData = FileHelper.readByteFile( "images/" + this.fileName );

        log.debug( "fileName: " + this.fileName );
        log.debug( "fileData size: " + fileData.length );
        log.debug( "fileData md5:  " + fsService.getFileContentMd5( fileData ) );
    }

    @Test
    public void check()
    {
        log.debug( ">>>> execute check funtion >>>>" );

        try
        {
            CheckResult res = fsService.check( 62073919, null, 256, fileName, fileData );

            log.info( "CheckResult: \n" + JSONHelper.toJSONString( res ) );
        }
        catch( Exception e )
        {
            log.error( "Exception: " + e.getMessage(), e );
        }
    }

    @Test
    public void upload()
    {
        log.debug( ">>>> execute check funtion >>>>" );

        try
        {
            UploadResult res = fsService.upload( 62073919, null, 256, fileName, null, fileData, false );

            log.info( "UploadResult: \n" + JSONHelper.toJSONString( res ) );
        }
        catch( Exception e )
        {
            log.error( "Exception: " + e.getMessage(), e );
        }
    }

    @Test
    public void uploadConv()
    {
        log.debug( ">>>> execute check funtion >>>>" );

        try
        {
            UploadResult res = fsService.upload( 62073919, null, 256, fileName, null, fileData, true );

            log.info( "UploadResult: \n" + JSONHelper.toJSONString( res ) );
        }
        catch( Exception e )
        {
            log.error( "Exception: " + e.getMessage(), e );
        }
    }

    @Test
    public void downloadData()
    {
        try
        {
            CheckResult checkResult = fsService.check( 62073919, null, 256, fileName, fileData );

            if ( ! checkResult.result || StringUtils.isBlank( checkResult.fileId ) )
            {
                log.info( "check file failed." );
                return;
            }

            DownloadResult downloadResult = fsService.download( 62073919, null, checkResult.fileId, 0, null, false, null );

            String downloadMd5 = fsService.getFileContentMd5( downloadResult.data );
            log.info( "download file content md5: " + downloadMd5 );
        }
        catch( Exception e )
        {
            log.error( "Exception: " + e.getMessage(), e );
        }
    }

    @Test
    public void downloadFile()
    {
        try
        {
            CheckResult checkResult = fsService.check( 62073919, null, 256, fileName, fileData );

            if ( ! checkResult.result || StringUtils.isBlank( checkResult.fileId ) )
            {
                log.info( "check file failed." );
                return;
            }

            TestFSServiceDownload downloadCallback = new TestFSServiceDownload();
            DownloadResult downloadResult = fsService.download( 62073919, null, checkResult.fileId, 
                    0, null, false, downloadCallback );
        }
        catch( Exception e )
        {
            log.error( "Exception: " + e.getMessage(), e );
        }
    }

    @Test
    public void downloadFileConv()
    {
        try
        {
            CheckResult checkResult = fsService.check( 62073919, null, 256, fileName, fileData );

            if ( ! checkResult.result || StringUtils.isBlank( checkResult.fileId ) )
            {
                log.info( "check file failed." );
                return;
            }

            TestFSServiceDownload downloadCallback = new TestFSServiceDownload();
            DownloadResult downloadResult = fsService.download( 62073919, null, checkResult.fileId, 
                    0, null, true, downloadCallback );
        }
        catch( Exception e )
        {
            log.error( "Exception: " + e.getMessage(), e );
        }
    }

    @Test
    public void downloadErrorFile()
    {
        try
        {
            TestFSServiceDownload downloadCallback = new TestFSServiceDownload();
            DownloadResult downloadResult = fsService.download( 62073919, null, "sdfd-sdfsdfsdfs-1231231s", 
                    0, null, true, downloadCallback );
        }
        catch( Exception e )
        {
            log.error( "Exception: " + e.getMessage(), e );
        }
    }
}
