import name.rex.commlib.dataobj.HostAndPort;
import name.rex.commlib.database.Redis;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.lang.Thread;
import java.util.Set;
import java.util.HashSet;

public class RedisTest
{
    public void check1()
    {
        
    }

    @Test
    public void check2() throws Exception
    {
        Redis r = new Redis( 2000, 5, "192.168.35.131", 8900 );
        r.set( "key1", "200000" );
        r.get( "key1" );
    }
    
    @Test
    public void check3() throws Exception
    {
        Redis r = null;
        HostAndPort h = null;
        Set<HostAndPort> setNode = new HashSet<HostAndPort>();
        
        h = new HostAndPort( "192.168.35.112", 7000 );
        setNode.add( h );
        h = new HostAndPort( "192.168.35.131", 7000 );
        setNode.add( h );
        h = new HostAndPort( "192.168.35.132", 7000 );
        setNode.add( h );
        
        r = new Redis( 20, 5, setNode );

        r.setex( "keyw", 200, "vsdsdfsdf" );
        r.ttl( "keyw" );
        r.get( "keyw" );
        r.get( "hongliang" );
    }
    
}
