package name.rex.commlib.database;

import java.util.Date;
import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

public class MemCache
{
    private static Logger log = LoggerFactory.getLogger( MemCache.class );

    private String[] servers = null;
    private SockIOPool pool = null;
    private MemCachedClient client = null;

    public MemCache( String server ) throws Exception
    {
        String[] listServer = null;
        
        if ( null == server || server.isEmpty() )
        {
            String err = "MemCache: invalid server parameter, server is null or empty.";
            log.error( err );
            throw new Exception( err );
        }

        listServer = server.split( ";" );
        this.servers = listServer;
        init();
    }

    public MemCache( String[] servers ) throws Exception
    {
        if ( null == servers || 0 == servers.length )
        {
            String err = "MemCache: invalid servers parameter, server is null or length is zero.";
            log.error( err );
            throw new Exception( err ); 
        }

        this.servers = servers;
        init();
    }

    private void init()
    {
        pool = SockIOPool.getInstance();
        pool.setServers( this.servers ); 
        pool.initialize();

        client = new  MemCachedClient();
    }

    public boolean add( String key, String value, int expire )
    {
        Date date = null;

        if ( expire > 0 )
        {
            date = new Date();
            date.setTime( date.getTime() + expire * 1000 );
        }

        log.debug( "MemCache add key=" + key + ", expire=" + 
                String.format( "%d", expire ) +  ", date: " + date + ", value=" + value );
        return client.add( key, value, date );
    }

    public boolean set( String key, String value, int expire )
    {
        Date date = null;

        if ( expire > 0 )
        {
            date = new Date();
            date.setTime( date.getTime() + expire * 1000 );
        }

        log.debug( "MemCache set key=" + key + ", expire=" + 
                String.format( "%d", expire ) +  ", date: " + date + ", value=" + value );
        return client.set( key, value, date );
    }

    public String get( String key )
    {
        String value = (String)client.get( key );
        log.debug( "MemCache get key=" + key + ", value=" + value );
        return value;
    }

    public boolean delete( String key )
    {
        log.debug( "MemCache delete key=" + key );
        return client.delete( key );
    }
}
