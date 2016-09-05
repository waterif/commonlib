package name.rex.commlib.database.cluster;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

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

class DataSourceConfig
{
	public String dataSource;
	public String userName;
	public String password;
	public String maxConnect;
	public String timeout;
}

@XmlRootElement(name = "parameters")   
class RWClusterConfig
{
    public String driverName;
    public DataSourceConfig write;
    public List<DataSourceConfig> read;
}

public class RWCluster implements IDBCluster 
{	
    private static Logger log = LoggerFactory.getLogger( RWCluster.class );
    
    private RWClusterConfig config = null;
    private DBConnectorPool writePool = null;
    
    private List<DBConnectorPool> readPool = new ArrayList<DBConnectorPool>();

    public void initCluster( String xmlConfig ) throws DBException
    {
        config = XMLHelper.fromXMLString( xmlConfig, RWClusterConfig.class );
        
        try
        {
        	//初始化连接
        	if ( null != config.write )
        	{
        		writePool = new DBConnectorPool( config.driverName, config.write.dataSource, 
        				config.write.userName, config.write.password, Integer.parseInt( config.write.maxConnect), Integer.parseInt( config.write.maxConnect)*1000 );
        	}
        
        	if ( null != config.read && config.read.size() > 0 )
        	{
        		for ( DataSourceConfig readConfig : config.read )
        		{
        			DBConnectorPool read = new DBConnectorPool(config.driverName, readConfig.dataSource, 
        				readConfig.userName, readConfig.password, Integer.parseInt( readConfig.maxConnect), Integer.parseInt( readConfig.maxConnect)*1000 );
        		
        			readPool.add(read);
        		}
        	}
        }
        catch( Exception e)
        {
        	if ( null != this.writePool)
        	{
        		this.writePool.close();
        	}
        	if ( null != this.readPool && this.readPool.size() > 0)
        	{
        		for( DBConnectorPool pool : readPool )
        		{
        			pool.close();
        		}
        		this.readPool.clear();
        	}
        	
        	throw new DBException( e );
        }
        
        log.info( xmlConfig + " initialize success!");
    }

    public IDBConnector getPersistInstance() throws DBException
	{
    	return this.writePool.getPersistInstance();
	}

    public void releasePersistInstance() throws DBException
	{
    	throw new DBException( "make use of DBPersist object to release connect." );
	}

	public void close()
	{		
		for ( DBConnectorPool read  : readPool)
		{
			read.close();
		}
		this.readPool.clear();
		this.readPool = null;
		
		this.writePool.close();
		this.writePool = null;
	}

	private static Random ran = new Random();
	public <T> List<T> query(String sql, Class<T> classType, DBPage page) throws DBException
	{				
		int mark = ran.nextInt( readPool.size());
		
		DBConnectorPool read = readPool.get(mark);
				
		return read.query(sql,  classType, page);
	}	

	public int execute(String sql) throws DBException 
	{
		return this.writePool.execute(sql);
	}

    public int execute(String sql, DBGeneratedKeyResult generatedKeyRes ) throws DBException 
	{
		return this.writePool.execute( sql, generatedKeyRes );
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
