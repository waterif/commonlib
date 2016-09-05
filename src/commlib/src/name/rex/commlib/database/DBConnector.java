package name.rex.commlib.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.List;

import name.rex.commlib.database.paging.PagingFactory;
import name.rex.commlib.database.interfaces.IDBConnector;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

public class DBConnector implements IDBConnector
{
	private static Logger log = LoggerFactory.getLogger( DBClusterFactory.class );
	
	private String driverName;
	private String dataSource;
	private String username;
	private String password;
	private int timeout;     //等待连接的超时时间（毫秒）
	
	private Connection conn = null;
	
	public DBConnector( String driverName, String dataSource, String username, 
            String password, int timeout ) throws DBException
	{	
		this.driverName = driverName;
		this.dataSource = dataSource;
		this.username = username;
		this.password = password;
		this.timeout = timeout;
		
		log.info( logPrefix( "build DBConnector." ) );
		_connect();
	}
	
	public IDBConnector getPersistInstance() throws DBException
	{
        String err = logPrefix( "not support persist instance, get exception" );
        log.error( err );
        throw new DBException( err );
	}

    public void releasePersistInstance() throws DBException
    {
        String err = logPrefix( "not support persist instance, release exception" );
        log.error( err );
        throw new DBException( err );
    }
	
	public void close( )
	{
        if ( null != conn )
        {
            try
            {
            	log.info( logPrefix( "close a connection!" ) );
            	
                conn.close();
                conn = null;
            }
            catch( Exception e ) 
            {            	
            }
        }
	}
	
	private void _connect() throws DBException
	{		
		try
		{
			if ( null != conn )
			{
				if ( conn.isValid(this.timeout) )
				{
					return;
				}
				
				conn.close();
			}
						
			Class.forName( driverName );			
			this.conn = DriverManager.getConnection( dataSource, username, password );
		}
		catch( Exception e )
		{		
            String err = logPrefix( "failed to rebuild connection: " + e.getMessage() );
			log.error( err , e );
			throw new DBException( err );
		}
	}
	
	public <T> List<T> query( String sql, Class<T> classType, DBPage page ) throws DBException  
	{ 
		List<T> list = null;
		Statement stmt = null;

        _connect();

		try
		{		
			log.debug( logPrefix( "query sql: " + sql ) );
			sql = PagingFactory.buildSql(sql,  page, conn);			
			
			stmt = conn.createStatement();
			ResultSet result  = stmt.executeQuery( sql );			
			if( null == result ) 
			{
				return null;
			}
			
			list = DBHelper.resultToObject(result, classType);			
			result.close();
		}
		catch( Exception e )
		{
            String err = logPrefix( "failed to query: " + sql + ", Exception: " + e.getMessage() );
			log.error( err, e );
			throw new DBException( err );
		}
		finally
		{
			if( null != stmt)
			{
				try 
			    {
					stmt.close();
				} 
				catch (SQLException e) {}
			}
		}
		
		return list;
	}

	public int execute( String sql ) throws DBException 
	{
        return execute( sql, null );
	}

    public int execute( String sql, DBGeneratedKeyResult generatedKeyRes ) throws DBException 
	{
        ResultSet keys = null;
        Statement stmt = null;

		_connect();
		
		try
		{
            int res;
			log.debug( logPrefix( "excute sql: " + sql ) );
			stmt = conn.createStatement();

            if ( null != generatedKeyRes )
            {
                log.debug( logPrefix( "need to return generatedKeys"  ) );
                res = stmt.executeUpdate( sql, Statement.RETURN_GENERATED_KEYS );
                keys = stmt.getGeneratedKeys();

                if ( null != keys && keys.first() )
                {
                    ResultSetMetaData mData = keys.getMetaData();

                    if ( null != mData && 0 < mData.getColumnCount() )
                    {
                        generatedKeyRes.generatedKey = keys.getLong( 1 );
                        log.debug( logPrefix( "return generate key: " + generatedKeyRes.generatedKey ) );
                    }
                }
            }
            else
            {
                res = stmt.executeUpdate( sql );
            }

			return res;
		}
		catch( Exception e )
		{
            String err = logPrefix( "failed to excute: " + sql + ", Exception: " + e.getMessage() );
			log.error( err, e);
			throw new DBException( err );
		}
		finally
		{
			if( null != stmt)
			{
				try 
			    {
					stmt.close();
				} 
				catch (SQLException e)
				{
                }
			}
		}
	}

	public void beginTransaction() throws DBException 
	{		
		_connect();
		
		try 
		{
			log.debug( logPrefix("begin transaction.") );
			this.conn.setAutoCommit( false );
		}
		catch ( Exception e )
		{
            String err = logPrefix( "failed to setAutoCommit, Exception: " + e.getMessage() );
			log.error( err, e);
			throw new DBException( err );
		}			
	}

	public void commit() throws DBException 
	{
		_connect();
		
		try 
		{
			log.debug( logPrefix( "commit transaction." ) );
			this.conn.commit();
			this.conn.setAutoCommit(true);
		}
		catch ( Exception e)
		{
            String err = logPrefix( "failed to commit. Exception: " + e.getMessage() );
			log.error( err, e );
			throw new DBException( err );
		}
	}

	/**
	 * @return false：回滚失败；true：回滚成功
	 */
	public boolean rollback() 
	{		
		try 
		{			
			log.debug( logPrefix( "rollback transaction." ) );
			this.conn.rollback();
			this.conn.setAutoCommit(true);
		}
		catch ( Exception e )
		{
			log.error( logPrefix( "failed to rollback. Exception: " + e.getMessage() ) );
			return false;
		}		
		return true;
	}

	public void setTranIsolation(int level) throws DBException 
	{		
		_connect();
		
		try 
		{
			log.debug( logPrefix( "set transaction isolation: " + level ) );
			this.conn.setTransactionIsolation( level );
		} 
		catch ( Exception e ) 
		{
            String err = logPrefix( "failed to setTransactionIsolation. Exception: " + e.getMessage() );
			log.error( err, e );
			throw new DBException( err );
		}
	}	

    /* 日志前缀 */
	private String baseLog = null;
	
	private String logPrefix( String logValue )
	{
		if ( null == this.baseLog )
		{
			StringBuilder builder = new StringBuilder();
			builder.append("[").append(this.hashCode()).append("-").append(System.currentTimeMillis())
				.append("; dataSource=").append(this.dataSource).append("; user=").append(this.username).append("]");
			
			this.baseLog = builder.toString();
		}
		
		return baseLog + logValue;		
	}
}
