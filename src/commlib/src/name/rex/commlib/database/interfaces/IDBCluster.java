package name.rex.commlib.database.interfaces;

import name.rex.commlib.database.DBException;

public interface IDBCluster extends IDBConnector {
	
	/**
	 * 根据数据库资源xml文件进行数据源初始化
	 * 
	 * @param context
	 * @throws DBException
	 */
	public void initCluster( String xmlConfig ) throws DBException;	
}
