import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import name.rex.commlib.net.HttpWrapper;
import name.rex.commlib.net.HttpWrapperRes;
import name.rex.commlib.net.HttpWrapperHeader;
import name.rex.commlib.net.HttpWrapperCallback;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import name.rex.commlib.format.JSONHelper;
import name.rex.commlib.io.IOHelper;

import org.junit.Test;
import org.junit.Assert;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.message.BasicHeader;
import org.apache.http.NameValuePair;

class FileHttpWrapperCallback implements HttpWrapperCallback
{
    private static Logger log = LoggerFactory.getLogger( FileHttpWrapperCallback.class );
    private String fileName;

    public FileHttpWrapperCallback( String fileName )
    {
        this.fileName = fileName;
    }

    public void processData( HttpWrapperRes res, InputStream inputStream )
    {
        try
        {
            FileOutputStream out = new FileOutputStream( fileName );

            IOHelper.writeTo( inputStream, out );

            out.close();
        }
        catch( Exception e )
        {
            log.error( "process Data Exception :" + e.getMessage() );
        }
    }
}

public class HttpWrapperTest
{
    public static Logger log = LoggerFactory.getLogger( HttpWrapperTest.class );
    public String proxyHost = "192.168.21.248";
    public int proxyPort = 3128;
    public String proxyScheme = "http";
   
    @Test
    public void getBaiduHtml()
    {
        HttpWrapperRes res = HttpWrapper.get( "http://www.baidu.com", null, false );
        Assert.assertNotNull( res );
        Assert.assertEquals( 200, res.status );

        //System.out.println( "Result: \n" + JSONHelper.toJSONString( res ) );
    }

    @Test
    public void testHttps()
    {
        HttpWrapperRes res = HttpWrapper.get( "https://www.baidu.com", null, true );
        Assert.assertNotNull( res );
        Assert.assertEquals( 200, res.status );

        System.out.println( "Content-Type: " + res.getHeaderValue( "Content-Type" ) );
    }

    @Test
    public void testHttpDownload1()
    {
        HttpWrapperRes res = HttpWrapper.get( "https://www.baidu.com", null, true );

        if ( res.isValidStatus() )
        {
            try
            {
                FileOutputStream out = new FileOutputStream( "d1.data" );

                out.write( res.content.getBytes() );

                out.close();
            }
            catch( Exception e )
            {
                log.error( "write file exception", e );
            }
        }
    }

    @Test
    public void testHttpDownload2()
    {
        FileHttpWrapperCallback callback = new FileHttpWrapperCallback( "d2.data" );
        HttpWrapperRes res = HttpWrapper.get( "https://www.baidu.com", null, 
                HttpWrapperRes.FLAG_RETURN_HEADER, callback );
    }

    @Test
    public void testProxy()
    {
        HttpWrapper.setProxy( proxyHost, proxyPort, proxyScheme );
        HttpWrapper.get( "https://www.baidu.com", null, false );
        log.debug( ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        HttpWrapper.get( "https://www.baidu.com", null, false );
    }   

    @Test
    public void testBuildQuery()
    {
        class A
        {
            public String a = "a";
            public String b = "b";
        }

        Map<String, Object> params = new LinkedHashMap<String, Object>();

        params.put( "a", 123 );
        params.put( "b", "sdfsdfsdf" );
        params.put( "data", "" );

        A a = new A();

        params.put( "c", a );

        String res = HttpWrapper.buildQuery( params );
        System.out.println( res );
    }

    public void parseHeader( String headerName, String headerValue )
    {
        Header h = new BasicHeader( headerName, headerValue );

        System.out.println( "Header: " + h );
        System.out.println( "Header value: " + h.getValue() );
        System.out.println( "Header name: " + h.getName() );

        HeaderElement eles[] = h.getElements();
        
        if ( null == eles )
        {
            System.out.println( "Elements is null" );
        }

        System.out.println( "Elements count: " + eles.length );

        if ( null != eles )
        {
            int n = 1;

            for( HeaderElement e: eles )
            {
                System.out.println( "\t" + n + "," + e.getName() + "," + e.getValue() );

                NameValuePair nps[] = e.getParameters();
                if ( null == nps )
                {
                    System.out.println( "\tParameters is null" );
                }
                else
                {
                    int m = 1;

                    for( NameValuePair np: nps )
                    {
                        System.out.println( "\t\t" + m + "," + np.getName() + ":" + np.getValue() );
                        m++;
                    }
                }

                n++;
            }
        }
    }

    @Test
    public void testHeader()
    {
        System.out.println( "+++++++++++++++++++++++++++++++++++++++" );
        parseHeader( "Content-Type", "Application/json; charset=UTF-8" );
        System.out.println( "+++++++++++++++++++++++++++++++++++++++" );
        parseHeader( "Content-Type", "Application/json; charset=UTF-8; a=b" );
        System.out.println( "+++++++++++++++++++++++++++++++++++++++" );
        parseHeader( "Content-Type", "Application/json; charset=UTF-8, a=b" );
        System.out.println( "+++++++++++++++++++++++++++++++++++++++" );
        parseHeader( "Content-Type", null );
        System.out.println( "+++++++++++++++++++++++++++++++++++++++" );
        parseHeader( "Content-Type", "" );
        System.out.println( "+++++++++++++++++++++++++++++++++++++++" );
        parseHeader( "", "Application/json; charset=UTF-8; a=b" );
        System.out.println( "+++++++++++++++++++++++++++++++++++++++" );
        parseHeader( "", "Application/json; charset=UTF-8; a=b; cc; =dd" );
        System.out.println( "+++++++++++++++++++++++++++++++++++++++" );
        parseHeader( "", "; charset=UTF-8; a=b; cc; =dd" );
        System.out.println( "+++++++++++++++++++++++++++++++++++++++" );
        parseHeader( "", "charset=UTF-8; a=b; cc; =dd" );
        System.out.println( "+++++++++++++++++++++++++++++++++++++++" );
        parseHeader( "Content-Type2", "mime/type;charset=UTF-8; a=b; cc; =dd" );
        System.out.println( "+++++++++++++++++++++++++++++++++++++++" );
        parseHeader( "Content-Type2", ";charset=UTF-8; a=b; cc; =dd" );
        System.out.println( "+++++++++++++++++++++++++++++++++++++++" );
        parseHeader( "Content-Type3", "charset=UTF-8; a=b; cc; =dd" );
        System.out.println( "+++++++++++++++++++++++++++++++++++++++" );
    }

    private void printHeader( String name, String value )
    {
        HttpWrapperHeader h = new HttpWrapperHeader( name, value );
        HttpWrapperHeader.Parameter p[] = h.getParameters();

        System.out.println( "Header JSON: " + JSONHelper.toJSONString( p ) );
    }

    @Test
    public void testHeader2()
    {
        log.error( "debug testHeader2 " );

        System.out.println( "1.========================" );
        printHeader( "Content-Type", "application/json" );

        System.out.println( "2.========================" );
        printHeader( "Content-Type", "application/json;charset=utf-8" );

        System.out.println( "3.========================" );
        printHeader( "Content-Type", "application/json;charset=big5;abc=123" );

        System.out.println( "4.========================" );
        printHeader( "Content-Type", ";charset=big5;abc=123" );

        System.out.println( "5.========================" );
        printHeader( "Content-Type", "charset=big5;a=;abc=123" );
    }

    public void t1( Map<String, ? extends Object> p )
    {

    }

    @Test
    public void testBuildUrl()
    {
        String url1 = "http://www.baidu.com";
        String url2 = "http://www.baidu.com/?";
        String url3 = "http://www.baidu.com/?a=sdfsdf";

        Map<String, String> param = new LinkedHashMap<String, String>();

        param.put( "a1", "&a1a1a1" );
        param.put( "a2", "?a2a2a2" );
        param.put( "a3", "a3a3a3" );
        param.put( "a4", "a4a4a4" );

        System.out.println( HttpWrapper.buildURL( url1, param ) );
        System.out.println( HttpWrapper.buildURL( url2, param ) );
        System.out.println( HttpWrapper.buildURL( url3, param ) );

        t1( param );
    }
}
