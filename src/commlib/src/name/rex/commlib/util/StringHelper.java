package name.rex.commlib.util;

import java.util.Random;
import org.apache.commons.lang.StringUtils;
import name.rex.commlib.format.JSONHelper;
import name.rex.commlib.dataobj.PhoneNumber;

public class StringHelper
{
    static public String byteArrayToHexString( byte[] byteArray )
    {
        if ( null == byteArray || byteArray.length == 0 )
        {
            return null;
        }

        int index = 0;
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };  
        char[] resultCharArray =new char[ byteArray.length * 2 ];  
  
        for (byte b : byteArray) 
        {  
            resultCharArray[ index++ ] = hexDigits[ b>>> 4 & 0xf ];  
            resultCharArray[ index++ ] = hexDigits[ b& 0xf ];  
        }  
  
        return new String(resultCharArray);
    }

    public static String randomString( int siz, String chars )
    {
        if ( siz <= 0 || null == chars || chars.isEmpty() )
        {
            return null;
        }

        int i, charsSize= chars.length();
        StringBuilder res = new StringBuilder();
        Random rand = new Random( System.currentTimeMillis() );

        for( i = 0; i < siz; i++ )
        {
            res.append( chars.charAt( rand.nextInt( charsSize - 1 ) ) );
        }

        return res.toString();
    }

    public static final int CHAR_NUMBER = 0x01;
    public static final int CHAR_UPPERCASE_LITTER = 0x02;
    public static final int CHAR_LOWERCASE_LITTER = 0x04;
    public static final int CHAR_SIGN = 0x08;
    public static final int CHAR_SPACE = 0x10;
    public static final int CHAR_CONTROL = 0x20;

    public static String getChars( int types )
    {
        int i;
        StringBuilder res = new StringBuilder();
        
        if ( 0 != ( types & CHAR_NUMBER ) )
        {
            for( i = (int)'0'; i <= (int)'9'; i++ )
            {
                res.append( (char)i );
            }
        }

        if ( 0 != ( types & CHAR_UPPERCASE_LITTER ) )
        {
            for( i = (int)'A'; i <= (int)'Z'; i++ )
            {
                res.append( (char)i );
            }
        }

        if ( 0 != ( types & CHAR_LOWERCASE_LITTER ) )
        {
            for( i = (int)'a'; i <= (int)'z'; i++ )
            {
                res.append( (char)i );
            }
        }

        if ( 0 != ( types & CHAR_SIGN ) )
        {
            for( i = (int)'!'; i <= (int)'/'; i++ )
            {
                res.append( (char)i );
            }

            for( i = (int)':'; i <= (int)'@'; i++ )
            {
                res.append( (char)i );
            }

            for( i = (int)'['; i <= (int)'`'; i++ )
            {
                res.append( (char)i );
            }

            for( i = (int)'{'; i <= (int)'~'; i++ )
            {
                res.append( (char)i );
            }
        }

        if ( 0 != ( types & CHAR_SPACE ) )
        {
            res.append( ' ' );
        }

        if ( 0 != ( types & CHAR_CONTROL ) )
        {
            for( i = 1; i < 32; i++ )
            {
                res.append( (char)i );
            }

            res.append( (char)127 );
        }

        return res.toString();
    }

    public static String randomString( int siz, int types )
    {
        if ( siz <= 0 )
        {
            return null;
        }

        return randomString( siz, getChars( types ) );
    }

    public static String firstLower( String str )
    {
        if ( null != str && !str.isEmpty() )
        {
            str = str.substring( 0, 1 ).toLowerCase() + str.substring( 1 );
        }

        return str;
    }

    public static PhoneNumber parsePhoneNumber( String phone )
    {
        String[] items = phone.split( "-" );

        if ( null == items || items.length <= 0 )
        {
            return null;
        }

        int count = 0;
        PhoneNumber res = new PhoneNumber();

        for( String v: items )
        {
            if ( count++ >= 4 )
            {
                break;
            }

            if ( v.startsWith( "+" ) || v.startsWith( "00" ) )
            {
                if ( null == res.number || res.number.isEmpty() )
                {
                    res.country = v;
                }
                else
                {
                    res.ext = v;
                }
            }
            else if ( v.startsWith( "0" ) )
            {
                if ( null == res.number || res.number.isEmpty() )
                {
                    res.region = v;
                }
                else
                {
                    res.ext = v;
                }
            }
            else 
            {
                if ( null == res.number || res.number.isEmpty() )
                {
                    res.number = v;
                }
                else
                {
                    res.ext = v;
                }
            }
        }

        return res;
    }

    public static String escapeJson( String v )
    {
        String j = JSONHelper.toJSONString( v );

        if ( null != j && ! j.isEmpty() )
        {
            if ( '\"' == j.charAt( 0 ) )
            {
                j = j.substring( 1 );
            }

            if ( ! j.isEmpty() )
            {
                if ( '\"' == j.charAt( j.length() - 1 ) )
                {
                    j = j.substring( 0, j.length() - 2 );
                }
            }
        }

        return j;
    }

    public static void trim( String[] v )
    {
        if ( null != v )
        {
            for( int i = 0; i < v.length; i++ )
            {
                v[ i ] = StringUtils.trim( v[ i ] );
            }
        }
    }
}
