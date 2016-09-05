package com.quanshi.uclib.util;

import java.util.zip.DeflaterOutputStream;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.codec.binary.Base64;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

public class MiscUtil
{
    public static final Logger log = LoggerFactory.getLogger( ThriftHelper.class );

    public static byte[] compress( byte[] data )
    {
        try
        {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            DeflaterOutputStream zos = new DeflaterOutputStream( out );

            zos.write( data );
            zos.close();

            return out.toByteArray();
        }
        catch ( Exception e )
        {
            log.error( "compress fail: " + e.getMessage() );
            return null;
        }
    }

    public static String md5sum( byte[] d )
    {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

        try
        {
            MessageDigest mdInst = MessageDigest.getInstance( "MD5" );
            mdInst.update( d );

            byte[] md = mdInst.digest();

            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for ( int i = 0; i < j; i++ )
            {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }

            return new String( str );
        }
        catch ( Exception e )
        {
            log.error( "md5sum fail: " + e.getMessage() );
            return null;
        }
    }

    public static byte[] toMD5( byte[] d )
    {
        try
        {
            MessageDigest mdInst = MessageDigest.getInstance( "MD5" );
            mdInst.update( d );

            return mdInst.digest();
        }
        catch ( Exception e )
        {
            log.error( "md5sum fail: " + e.getMessage() );
            return null;
        }
    }

    public static byte[] byteArrayLink( byte v1[], byte v2[] )
    {
        int v1_siz = 0;
        int v2_siz = 0;

        v1_siz = (null != v1) ? v1.length : 0;
        v2_siz = (null != v2) ? v2.length : 0;

        byte[] res = null;

        if ( v1_siz + v2_siz > 0 )
        {
            int m = 0;

            res = new byte[v1_siz + v2_siz];
            if ( v1_siz > 0 )
            {
                System.arraycopy( v1, 0, res, m, v1_siz );
                m += v1_siz;
            }

            if ( v2_siz > 0 )
            {
                System.arraycopy( v2, 0, res, m, v2_siz );
                m += v2_siz;
            }
        }

        return res;
    }

    public static byte[] int2byte( int a )
    {
        byte[] b = new byte[4];

        /*
         * b[3] = (byte)( a & 0xff ); b[2] = (byte)( a >> 8 & 0xff ); b[1] =
         * (byte)( a >> 16 & 0xff ); b[0] = (byte)( a >> 24 & 0xff );
         */
        b[0] = (byte) (a & 0xff);
        b[1] = (byte) (a >> 8 & 0xff);
        b[2] = (byte) (a >> 16 & 0xff);
        b[3] = (byte) (a >> 24 & 0xff);

        return b;
    }

    public static void setFileContent( String filename, byte[] content )
    {
        try
        {
            File f = new File( filename );
            FileOutputStream out = new FileOutputStream( f );

            if ( f.exists() )
            {
                out.write( null );
            }
            else
            {
                f.createNewFile();
            }
            out.write( content );
        }
        catch ( Exception e )
        {
            log.warn( "write file fail: " + filename );
        }
    }

    /**
     * base 64 编码
     * 
     * @param bytes
     *            待编码的byte[]
     * @return 编码后的base 64 code
     */
    public static String base64Encode( byte[] bytes )
    {
        return Base64.encodeBase64String( bytes );
    }

    /**
     * base 64 解码
     * 
     * @param base64Code
     *            待解码的base 64 code
     * @return 解码后的byte[]
     * @throws Exception
     */
    public static byte[] base64Decode( String base64Code ) throws Exception
    {
        return StringUtils.isBlank( base64Code ) ? null : Base64.decodeBase64( base64Code );
    }

    static public boolean valString( Object s )
    {
        if ( s == null || !(s instanceof String) || s.equals( "" ) )
        {
            return false;
        }
        return true;
    }
}
