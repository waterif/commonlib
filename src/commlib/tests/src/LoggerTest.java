import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import name.rex.commlib.format.JSONHelper;
import java.util.Map;
import java.util.HashMap;

public class LoggerTest
{
    public static Logger log = LoggerFactory.getLogger( LoggerTest.class );

    @Test
    public void logger()
    {
        log.addPrefix( "a", "sdfsdf" );
        log.debug( "hello, logger." );
    }

    protected int f1( int n, Map<String, Long> keys )
    {
        System.out.println( String.format( "%d input keys : %s", n, JSONHelper.toJSONString( keys ) ) );

        if ( null == keys )
        {
            keys = new HashMap<String, Long>();
            keys.put( "k1", (long)100 );
            keys.put( "k2", (long)200 );
        }

        keys.put( "k3", (long)300 );
        keys.put( "k4", (long)400 );
         
        return n;
    }

    protected void f2( Long n )
    {
        System.out.println( "input n: " + n );
        if ( null != n )
        {
            n = n + 1;
        }
        System.out.println( "output n: " + n );
    }

    @Test
    public void argTest()
    {
        String a = null;
        String b = "abc" + a;
        System.out.println( b );

        Map<String, Long> keys = null;

        System.out.println( "1 init keys : " + JSONHelper.toJSONString( keys ) );
        f1( 1, keys );
        System.out.println( "1 result keys : " + JSONHelper.toJSONString( keys ) );
    
        Map<String, Long> keys2 = new HashMap<String, Long>();
        keys2.put( "ik1", (long)300 );
        keys2.put( "il2", (long)100 );

        System.out.println( "2 init keys : " + JSONHelper.toJSONString( keys2 ) );
        f1( 2, keys2 );
        System.out.println( "2 result keys : " + JSONHelper.toJSONString( keys2 ) );

        System.out.println( "3 init keys null " );
        f1( 3, null );

        System.out.println( "Long null" );
        f2( null );

        Long n = null;
        System.out.println( "Long before is " + n );
        f2( n );
        System.out.println( "Long after is " + n );

        n = (long)-1;
        System.out.println( "Long before is " + n );
        f2( n );
        System.out.println( "Long after is " + n );
    }

    @Test
    public void testNull()
    {
        Long d = null;
        String s = null;
        String val = String.format( "%d, %s", d, s );
        System.out.println( val );
    }
}
