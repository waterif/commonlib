package name.rex.commlib.security;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import name.rex.commlib.util.StringHelper;
import java.security.MessageDigest;
import java.io.InputStream;

public class MessageDigestHelper
{
    private static Logger log = LoggerFactory.getLogger( MessageDigestHelper.class );

    //
    static public byte[] MessageDigest( InputStream data, String algorithm )
    {
        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance( algorithm );

            int nread = -1;
            byte buf[] = new byte[ 1024 ];

            data.reset();

            while( 0 < ( nread = data.read( buf ) ) )
            {
                messageDigest.update( buf, 0, nread );
            }

            data.reset();

            byte[] resultByteArray = messageDigest.digest();
            
            return resultByteArray;
        }
        catch( Exception e )
        {
            log.error( String.format( "MessageDigest(%s)  Error: ", algorithm ) + e.getMessage() );
            return null;
        }
    }

    static public byte[] MessageDigest( byte[] data, String algorithm )
    {
        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance( algorithm );
            messageDigest.update( data );  
            byte[] resultByteArray = messageDigest.digest();
            return resultByteArray;
        }
        catch( Exception e )
        {
            log.error( String.format( "MessageDigest(%s)  Error: ", algorithm ) + e.getMessage() );
            return null;
        }
    }

    static public byte[] MessageDigest( String content, String algorithm, String charset )
    {
        try
        {
            byte[] data = content.getBytes( charset );
            return MessageDigest( data, algorithm );
        }
        catch ( Exception e )
        {
            log.error( "String getBytes Error: " + e.getMessage() );
            return null;
        }
    }

    static public byte[] MessageDigest( String content, String algorithm )
    {
        return MessageDigest( content, algorithm, "UTF-8" );
    }

    // String
    static public String MessageDigestString( InputStream data, String algorithm )
    {
        byte[] res = MessageDigest( data, algorithm );
        return StringHelper.byteArrayToHexString( res );
    }

    static public String MessageDigestString( byte[] data, String algorithm )
    {
        byte[] res = MessageDigest( data, algorithm );
        return StringHelper.byteArrayToHexString( res );
    }

    static public String MessageDigestString( String content, String algorithm, String charset )
    {
        byte[] res = MessageDigest( content, algorithm, charset );
        return StringHelper.byteArrayToHexString( res );
    }

    static public String MessageDigestString( String content, String algorithm )
    {
        byte[] res = MessageDigest( content, algorithm, "UTF-8" );
        return StringHelper.byteArrayToHexString( res );
    }

    // MD5
    static public byte[] md5( InputStream data )
    {
        return MessageDigest( data, "MD5" );
    }

    static public byte[] md5( byte[] data )
    {
        return MessageDigest( data, "MD5" );
    }

    static public byte[] md5( String content, String charset )
    {
        return MessageDigest( content, "MD5", charset );
    }

    static public byte[] md5( String content )
    {
        return MessageDigest( content, "MD5", "UTF-8" );
    }

    // MD5String
    static public String md5String( InputStream data )
    {
        return MessageDigestString( data, "MD5" );
    }

    static public String md5String( byte[] data )
    {
        return MessageDigestString( data, "MD5" );
    }

    static public String md5String( String content, String charset )
    {
        return MessageDigestString( content, "MD5", charset );
    }

    static public String md5String( String content )
    {
        return MessageDigestString( content, "MD5", "UTF-8" );
    }
}
