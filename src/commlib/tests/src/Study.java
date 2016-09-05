import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class Study
{
    @Test
    public void testKeySet()
    {
        Map<String, String> mapValues = new HashMap<String, String>();

        Set<String> keys = mapValues.keySet();

        if ( null == keys )
        {
            System.out.println( "keys is null" );
        }
        else
        {
            System.out.println( String.format( "key size is : %d", keys.size() ) );
        }

        for( String k: keys )
        {
            System.out.println( "key: " + k );
        }
    }

    private void testLong( long n )
    {
    }

    @Test
    public void testLongArg()
    {
        testLong( 1 );
        testLong( 2 );
    }

    @Test
    public void testRegex()
    {
        String v = "//sdfdsf/sdfsd////sdfsdf/sdfsdf///sdfdsf";

        String v1 = v.replaceAll( "/+", "/" );
        System.out.println( v1 );
    }

    void f2( int n )
    {

    }

    @Test
    public void testNull()
    {
        Integer a = null;

        f2( a );
    }
}
