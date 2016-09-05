import name.rex.commlib.database.MemCache;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.lang.Thread;

public class MemCacheTest
{
    private MemCache cache = null;

    @Before
    public void Before() throws Exception
    {
        cache = new MemCache( "127.0.0.1:11211" );
    }

    @Test
    public void check1()
    {
        cache.set( "key1",  "2000", 0 );
        Assert.assertTrue( cache.get( "key1" ).equals( "2000" ) ); 
    }

    @Test
    public void check2() throws Exception
    {
        cache.set( "key2", "2000", 3 );
        cache.get( "key2" ).equals( "2000" );
        Thread.sleep( 3 * 1000 );
        Assert.assertNull( cache.get( "key2" ) );
    }

    @Test public void check3()
    {
        Assert.assertFalse( cache.add( "key1", "300", 14 ) );
    }

    @Test public void check4()
    {
        Assert.assertTrue( cache.add( "key4", "300", 3 ) );
    }

    @Test public void check5() throws Exception
    {
        Thread.sleep( 3 * 1000 );
        Assert.assertTrue( cache.add( "key4", "300", 3 ) );
    }
}
