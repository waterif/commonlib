package name.rex.web;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.ServletInputStream;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import name.rex.commlib.io.IOHelper;

public class HttpRequestWrapper extends HttpServletRequestWrapper
{
    public static class ByteArrayServletInputStream extends ServletInputStream
    {
        private ByteArrayInputStream bodyInputStream = null;

        public ByteArrayServletInputStream( byte data[] )
        {
            super();

            if ( null != data )
            {
                bodyInputStream = new ByteArrayInputStream( data );
            }
        }

        @Override
        public int read() throws IOException 
        {
            if ( null == bodyInputStream )
            {
                return -1;
            }

            return bodyInputStream.read();
        } 
    }

    private static Logger log = LoggerFactory.getLogger( HttpRequestWrapper.class );
    private byte[] bodyData = null;

    public HttpRequestWrapper( HttpServletRequest req )
    {
        super( req );

        InputStream is = null;

        try
        {
            is = req.getInputStream();
            
            bodyData = IOHelper.readByte( is );
        }
        catch( Exception e )
        {
            log.error( "read request body data fail: " + e.getMessage() );
        }
        finally
        {
            if ( null != is )
            {
                try
                {
                    is.close();
                }
                catch( Exception e1 )
                {
                }
                finally
                {
                    is = null;
                }
            }
        }
    }

    public byte[] getOrigData()
    {
        return bodyData;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException
    {
        return new ByteArrayServletInputStream( bodyData );
    }

    @Override
    public BufferedReader getReader() throws IOException 
    {
        return new BufferedReader( new InputStreamReader( getInputStream() ) );
    }
}
