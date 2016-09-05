package name.rex.commlib.database.cluster;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import name.rex.commlib.database.interfaces.IDBConnector;
import name.rex.commlib.database.interfaces.IDBCluster;
import name.rex.commlib.database.DBException;
import name.rex.commlib.database.DBPage;
import name.rex.commlib.database.DBConnectorPool;
import name.rex.commlib.database.DBGeneratedKeyResult;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import name.rex.commlib.format.XMLHelper;

@XmlRootElement(name = "parameters")   
class SingleClusterConfig
{
	public String driverName;
    public String dataSource;
	public String userName;
	public String password;
	public String maxConnect;
	public String timeout;
}

public class SingleCluster implements IDBCluster
{		
	private static Logger log = LoggerFactory.getLogger( SingleCluster.class );
	
    private SingleClusterConfig config = null;
    private DBConnectorPool pool = null;
	
    public void initCluster( String xmlConfig ) throws DBException
    {
        config = XMLHelper.fromXMLString( xmlConfig, SingleClusterConfig.class );
        try
        {
        	pool = new DBConnectorPool( config.driverName, config.dataSource, 
                config.userName, config.password, Integer.parseInt(config.maxConnect), Integer.parseInt(config.timeout) * 1000 );
        }
        catch( Exception e)
        {
        	if ( null != this.pool)
        	{
        		this.pool.close();
        	}
        	
        	throw new DBException( e );
        }
        
        log.info( xmlConfig + " initialize success!");
    }

    public IDBConnector getPersistInstance() throws DBException
	{
    	return this.pool.getPersistInstance();
	}

    public void releasePersistInstance() throws DBException
	{
    	throw new DBException( "make use of DBPersist object to release connect." );
	}

	public void close()
	{					
		this.pool.close();
		this.pool = null;
	}

	public <T> List<T> query(String sql, Class<T> classType, DBPage page) throws DBException
	{
		return pool.query(sql,  classType, page);
	}

	public int execute(String sql) throws DBException 
	{
		return this.pool.execute(sql);
	}

    public int execute( String sql, DBGeneratedKeyResult generatedKeyRes ) throws DBException 
	{
		return this.pool.execute( sql, generatedKeyRes );
	}

	public void beginTransaction() throws DBException
	{
        throw new DBException( "connect pool not support transaction, get perssit instance first please." );
	}

	public void commit() throws DBException 
	{
        throw new DBException( "connect pool not support transaction, get perssit instance first please." );
	}

	public boolean rollback() throws DBException
	{
        throw new DBException( "connect pool not support transaction, get perssit instance first please." );
	}

	public void setTranIsolation(int level) throws DBException 
	{
        throw new DBException( "connect pool not support transaction, get perssit instance first please." );
	}	
}
