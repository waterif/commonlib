package name.rex.commlib.util;

import java.util.zip.InflaterOutputStream;
import java.util.zip.DeflaterOutputStream;
import java.io.ByteArrayOutputStream;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

public class ZipHelper
{
    private static Logger log = LoggerFactory.getLogger( ZipHelper.class );

    public static byte[] compress( byte data[] )
    {
        try
        {
            ByteArrayOutputStream out = new ByteArrayOutputStream();   
            DeflaterOutputStream zos = new DeflaterOutputStream( out );

            zos.write( data );
            zos.close();

            return out.toByteArray();
        }
        catch( Exception e )
        {
            log.error( "compress fail: " + e.getMessage() );
            return null;
        }
    }

    public static byte[] uncompress( byte data[] )
    {
        try
        {
            ByteArrayOutputStream out = new ByteArrayOutputStream();   
            InflaterOutputStream zos = new InflaterOutputStream( out );

            zos.write( data );
            zos.close();

            return out.toByteArray();
        }
        catch( Exception e )
        {
            log.error( "compress fail: " + e.getMessage() );
            return null;
        }
    }
}
