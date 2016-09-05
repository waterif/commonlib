package name.rex.commlib.database;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import name.rex.commlib.database.interfaces.IDBConnector;
import name.rex.commlib.database.interfaces.IDBPersistOwner;
import name.rex.commlib.database.DBException;
import name.rex.commlib.database.DBPage;

public class DBConnectorPool implements IDBConnector, IDBPersistOwner
{	
	private static Logger log = LoggerFactory.getLogger( DBConnectorPool.class );
	
	private String driverName;
	private String dataSource;
	private String username;
	private String password;
	private int maxCount;
	private int timeout;     //等待连接的超时时间（毫秒）
	
    private String baseLog = null;
	
	public DBConnectorPool( String driverName, String dataSource, 
			String username, String password, int maxCount, int timeout ) throws DBException 
	{
		this.driverName = driverName;
		this.dataSource = dataSource;
		this.username = username;
		this.password = password;
		this.maxCount = maxCount;	
		this.timeout = timeout;		
		
		StringBuilder builder = new StringBuilder();
		builder.append("[").append(this.hashCode()).append("-").append(System.currentTimeMillis())
			.append("; dataSource=").append(this.dataSource).append("; user=").append(this.username).append("]");	
		this.baseLog = builder.toString();
		
		try
		{
			log.debug("create DBConnectorPool: " + this.baseLog);			
			initialize();			
			log.debug("create DBConnectorPool success : " + this.baseLog);			
		}
		catch ( Exception e )
		{
			log.error( "failed to initialize DBConnectorPool: " + dataSource  );
			throw new DBException( "failed to initialize DBConnectorPool" );
		}
	}	
		
	private void initialize() throws DBException, InterruptedException
	{
        this.set = new LinkedBlockingQueue<DBConnector>();
		this.pool = new LinkedBlockingQueue< DBConnector >( this.maxCount );
	
		int count = 0;
		while( count++ < this.maxCount)
		{
			DBConnector conn = new DBConnector( this.driverName, this.dataSource, this.username, this.password, this.timeout );
			this.pool.put( conn );
		}
	}	

    /* IDBPersistOwner接口实现 */
    public void releasePersistInOwner( IDBConnector op ) throws DBException
    {
        if ( ! this.set.contains( op ) )
        {
            throw new DBException( this.baseLog + "IDBConnector object is not in this Pool!" );
        }
        	
        try
        {
            this.set.remove( op );
            put( (DBConnector)op );
        }
        catch( Exception e )
        {
            throw new DBException( e );
        }
    }

    /* IDBConnector接口实现 */
	public IDBConnector getPersistInstance() throws DBException
	{
        DBConnector conn = get();
        if ( null == conn )
        {
            throw new DBException( this.baseLog + "no idle connection!" );
        }

        try
        {
        	this.set.put( conn );
        }
        catch ( InterruptedException e ) 
        {
        	put(conn);
        	log.error( baseLog, e );	
        	throw new DBException( e );
        }        

        DBPersist persist = new DBPersist( this, conn );
        
		return persist;
	}	

    public void releasePersistInstance() throws DBException
    {
        String err = this.baseLog + "not support persist db instance, release exception";
        log.error( err );
        throw new DBException( err );
    }

    public void close()
	{
    	log.info( this.baseLog + "close a DBConnectorPool!" );
    	
        for( DBConnector op: this.pool )
        {
            op.close();
        }
        pool.clear();
        this.set.clear();
	}

	public <T> List<T> query(String sql, Class<T> classType, DBPage page) throws DBException 
	{
        List<T> res = null;
		DBConnector conn = get();

		if ( null == conn )
		{
			throw new DBException( this.baseLog + "no idle connection exist!" );
		}
		
		try
		{
			res = conn.query( sql,  classType, page );
            put( conn );
		}
        catch( Exception e )
		{
            put( conn );
            throw new DBException( e );
		}

        return res;
	}

	public int execute(String sql) throws DBException 
	{
		int res = 0;
		DBConnector conn = get();

        if ( null == conn )
		{
			throw new DBException( this.baseLog + "no idle connection exist!" );
		}
	
        try
        {
            res = conn.execute( sql );
            put( conn );
        }
        catch( Exception e )
        {
            put( conn );
            throw new DBException( e );
        }

        return res;
	}

    public int execute( String sql, DBGeneratedKeyResult generatedKeyRes ) throws DBException 
	{
		int res = 0;
		DBConnector conn = get();

        if ( null == conn )
		{
			throw new DBException( this.baseLog + "no idle connection exist!" );
		}
	
        try
        {
            res = conn.execute( sql, generatedKeyRes );
            put( conn );
        }
        catch( Exception e )
        {
            put( conn );
            throw new DBException( e );
        }

        return res;
	}

	public void beginTransaction() throws DBException
	{
        throw new DBException( this.baseLog +"connect pool not support transaction, get perssit instance first please." );
	}

	public void commit() throws DBException 
	{
        throw new DBException( this.baseLog +"connect pool not support transaction, get perssit instance first please." );
	}

	public boolean rollback() throws DBException
	{
        throw new DBException( this.baseLog +"connect pool not support transaction, get perssit instance first please." );
	}

	public void setTranIsolation(int level) throws DBException 
	{
        throw new DBException( this.baseLog +"connect pool not support transaction, get perssit instance first please." );
	}
	
    /* 连接池、连接集合操作 */
	private DBConnector get()
	{		
		try 
		{
			DBConnector conn = pool.poll( this.timeout, TimeUnit.MILLISECONDS);			
			if ( null == conn )
			{
				log.error(this.baseLog + "no idle connection exist!");
			}
									
			return conn;
		}
		catch ( InterruptedException e ) 
		{
			log.error( baseLog, e );			
		}

		return null;
    }

    private void put( DBConnector conn )
    {
        try
        {
            this.pool.put( conn );
        }
        catch( Exception e )
        {
            log.error( baseLog, e );
        }
    }
	
	private LinkedBlockingQueue< DBConnector > pool	= null;	
    private LinkedBlockingQueue<DBConnector> set;
}
