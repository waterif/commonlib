package name.rex.commlib.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import name.rex.commlib.config.XmlConfig;
import name.rex.commlib.database.interfaces.IDBCluster;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

public class DBClusterFactory {
	
	private static Logger log = LoggerFactory.getLogger( DBClusterFactory.class );
    //private static ConcurrentMap<String, IDBCluster> mapCluster = new ConcurrentHashMap<String, IDBCluster>();
	
    public synchronized static IDBCluster createInstanceString( String xmlConfigContent ) throws DBException
	{
		log.debug("create IDBCluster string instance: " + xmlConfigContent );
		
		try 
        {
            IDBCluster res = null;
            XmlConfig xmlConfig = XmlConfig.createInstanceString( xmlConfigContent );
		    String className = xmlConfig.getConfigNodeValue( "/DBCluster/classname");
			res = (IDBCluster)Class.forName(className).newInstance();
		    res.initCluster( xmlConfig.getConfigNode( "/DBCluster/parameters" ) );
		    
		    log.debug("create IDBCluster instance success: " + xmlConfigContent);
		    
            return res;
		}
		catch(Exception e) 
        {
			log.error( "invalid classname in: " + xmlConfigContent + ", Exception: " + e.getMessage() );
		}

        return null;
	}

	public synchronized static IDBCluster createInstanceFile( String xmlConfigFileName ) throws DBException
	{
		log.debug("create IDBCluster instance: " + xmlConfigFileName);
		
		try 
        {
            IDBCluster res = null;
            XmlConfig xmlConfig = XmlConfig.createInstanceFile( xmlConfigFileName );
		    String className = xmlConfig.getConfigNodeValue( "/DBCluster/classname");
			res = (IDBCluster)Class.forName(className).newInstance();
		    res.initCluster( xmlConfig.getConfigNode( "/DBCluster/parameters" ) );
		    
		    log.debug("create IDBCluster instance success: " + xmlConfigFileName);
		    
            return res;
		}
		catch(Exception e) 
        {
			log.error( "invalid classname in: " + xmlConfigFileName + ", Exception: " + e.getMessage() );
		}

        return null;
	}
	
	public synchronized static Map<String, IDBCluster> createInstancesFile( String xmlConfigFileName )
			throws DBException
	{
		log.debug( "create IDBCluster instances: " + xmlConfigFileName );

		try
		{
			Map<String, IDBCluster> dbClusters = null;

			IDBCluster dbCluster = null;

			XmlConfig xmlConfig = XmlConfig.createInstanceFile( xmlConfigFileName );

			List<String> elementXmlStrings = xmlConfig.getConfigNodes( "/DBClusters/DBCluster" );

			if ( null != elementXmlStrings && !elementXmlStrings.isEmpty() )
			{
				dbClusters = new HashMap<String, IDBCluster>();

				for ( String elementXmlString : elementXmlStrings )
				{
					xmlConfig = XmlConfig.createInstanceString( elementXmlString );
					String className = xmlConfig.getConfigNodeValue( "/DBCluster/classname" );
					dbCluster = ( IDBCluster ) Class.forName( className ).newInstance();
					dbCluster.initCluster( xmlConfig.getConfigNode( "/DBCluster/parameters" ) );

					dbClusters.put( xmlConfig.getConfigNodeValue( "/DBCluster/name" ), dbCluster );
				}
			}

			log.debug( "create IDBCluster instances success: " + xmlConfigFileName );

			return dbClusters;
		}
		catch ( Exception e )
		{
			log.error( "invalid classname in: " + xmlConfigFileName + ", Exception: " + e.getMessage() );
		}

		return null;
	}

    /*
	public static IDBCluster getInstance( String xmlConfigFileName ) throws DBException
	{
		IDBCluster res = mapCluster.get( xmlConfigFileName );
		if ( null != res )
		{
			return res;
		}
			
        res = createInstance( xmlConfigFileName );
        if ( null != res )
        {
            mapCluster.put( xmlConfigFileName, res );
        }

        return res;
	}
    */
}
