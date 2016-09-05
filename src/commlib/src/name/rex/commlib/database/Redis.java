package name.rex.commlib.database;

import java.util.Set;
import java.util.HashSet;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisCommands;
import name.rex.commlib.dataobj.HostAndPort;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

public class Redis
{
    private static Logger log = LoggerFactory.getLogger( MemCache.class );

    private boolean cluster = false;
    private JedisPool p = null;
    private JedisCluster c = null;

    public Redis( int timeout, int maxTotal, 
            String host, int port ) throws Exception
    {
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        nodes.add( new HostAndPort( host, port ) );
        this.init( timeout, maxTotal, nodes ); 
    }

    public Redis( int timeout, int maxTotal, 
            Set<HostAndPort> nodes ) throws Exception
    {
        this.init( timeout, maxTotal, nodes );
    }

    private void init( int timeout, int maxTotal, Set<HostAndPort> nodes ) throws Exception
    {
        int siz = nodes.size();
        
        if ( siz <= 0 )
        {
            String err = "Redis: invalid nodes parameter, nodes is null or size <= 0.";
            log.error( err );
            throw new Exception( err );
        }

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(  ( 0 >= maxTotal ) ? -1: maxTotal );
        timeout = timeout * 1000;

        cluster = ( siz > 1 ) ? true : false ;
        if ( ! cluster )
        {
            HostAndPort n =  nodes.toArray( new HostAndPort[0] )[0];
            if ( null == n.host || n.host.isEmpty() 
                    || null == n.port || n.port <= 0 || n.port >= 65535 )
            {
                String err = "Redis: invalid nodes parameter, nodes is null or size <= 0.";
                log.error( err );
                throw new Exception( err );
            }

            log.debug( String.format( "init redis host mode: %s:%d timeout: %d", 
                        n.host, n.port, timeout ) );
            this.p = new JedisPool( poolConfig, n.host, n.port, timeout );
        }
        else
        {
            Set<redis.clients.jedis.HostAndPort> jedisClusterNode=new HashSet<redis.clients.jedis.HostAndPort>();

            log.debug( String.format( "init redis cluster mode: " ) );
            for( HostAndPort n : nodes )
            {
                if ( null == n.host || n.host.isEmpty() 
                    || null == n.port || n.port <= 0 || n.port >= 65535 )
                {
                    String err = "Redis: invalid nodes parameter, nodes is null or size <= 0.";
                    log.error( err );
                    throw new Exception( err );
                }

                log.debug( String.format( "cluster mode host node: %s:%d", 
                        n.host, n.port ) );
                jedisClusterNode.add ( new redis.clients.jedis.HostAndPort( n.host, n.port ) );
            }
            
            this.c = new JedisCluster( jedisClusterNode, timeout, poolConfig );
        }
    }

    public JedisCommands getResource()
    {
        if ( cluster )
        {
            return this.c;
        }
        else 
        {
            return this.p.getResource();
        }
    }

    public void returnResource( JedisCommands cmd )
    {
        if ( cluster )
        {
        }
        else 
        {
            ((Jedis)cmd).close();
        }
    }

    /* Keys */
    public Long del(String key)
    {
        JedisCommands cmd = getResource();
        Long res = cmd.del( key );
        log.debug( String.format( "Redis delete key %s, result: %d", key, res ) );
        returnResource( cmd );
        return res;
    }

    public Boolean exists( String key )
    {
        JedisCommands cmd = getResource();
        Boolean res = cmd.exists( key );
        log.debug( String.format( "Redis exists key %s, result: %b", key, res ) );
        returnResource( cmd );
        return res;
    }

    public Long expire( String key, int seconds )
    {
        JedisCommands cmd = getResource();
        Long res = cmd.expire( key, seconds );
        log.debug( String.format( "Redis expire key %s seconds %d, result: %d", key, seconds, res ) );
        returnResource( cmd );
        return res;
    }

    public Long ttl( String key )
    {
        JedisCommands cmd = getResource();
        Long res = cmd.ttl( key );
        log.debug( String.format( "Redis ttl key %s, result: %d", key, res ) );
        returnResource( cmd );
        return res;
    }

    public String type( String key ) 
    {
        JedisCommands cmd = getResource();
        String res = cmd.type( key );
        log.debug( String.format( "Redis type key %s, result: %s", key, res ) );
        returnResource( cmd );
        return res;
    }

    /* String */
    public String get( String key )
    {
        JedisCommands cmd = getResource();
        String res = cmd.get( key );
        log.debug( String.format( "Redis get key %s, result: %s", key, res ) );
        returnResource( cmd );
        return res;
    }

    public String set( String key, String value )
    {
        JedisCommands cmd = getResource();
        String res = cmd.set( key, value );
        log.debug( String.format( "Redis set key %s value: %s, result: %s", key, value, res ) );
        returnResource( cmd );
        return res;
    }

    public String set( String key, String value, String nxxx )
    {
        JedisCommands cmd = getResource();
        String res = cmd.set( key, value, nxxx );
        log.debug( String.format( "Redis set key %s value: %s, nxxx: %s, result: %s", key, value, nxxx, res ) );
        returnResource( cmd );
        return res;
    }

    public String set( String key, String value, String nxxx, String expx, int time )
    {
        JedisCommands cmd = getResource();
        String res = cmd.set( key, value, nxxx, expx, time );
        log.debug( String.format( "Redis set key %s value: %s, nxxx: %s, expx: %s, time: %d, result: %s", key, value, nxxx, expx, time, res ) );
        returnResource( cmd );
        return res;
    }

    public String set( String key, String value, String nxxx, String expx, long time )
    {
        JedisCommands cmd = getResource();
        String res = cmd.set( key, value, nxxx, expx, time );
        log.debug( String.format( "Redis set key %s value: %s, nxxx: %s, expx: %s, time: %d, result: %s", key, value, nxxx, expx, time, res ) );
        returnResource( cmd );
        return res;
    }

    public String setex( String key, int seconds, String value )
    {
        JedisCommands cmd = getResource();
        String res = cmd.setex( key, seconds, value );
        log.debug( String.format( "Redis setex key %s value: %s, seconds: %d, result: %s", key, value, seconds, res ) );
        returnResource( cmd );
        return res;
    }
    
    public Long setnx( String key, String value )
    {
        JedisCommands cmd = getResource();
        Long res = cmd.setnx( key, value );
        log.debug( String.format( "Redis setnx key %s value: %s, result: %d", key, value, res ) );
        returnResource( cmd );
        return res;
    }
}
