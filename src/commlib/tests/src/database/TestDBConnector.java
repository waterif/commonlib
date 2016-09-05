package src.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;


import name.rex.commlib.database.DBClusterFactory;
import name.rex.commlib.database.DBConnector;
import name.rex.commlib.database.DBException;
import name.rex.commlib.database.interfaces.IDBCluster;
import name.rex.commlib.database.interfaces.IDBConnector;

public class TestDBConnector {
	
	private static void query( IDBCluster operator )
	{
		String sql = "SELECT usera.id as aaa,usera.age,usera.password,usera.username,ordera.orderId,ordera.goodsName,ordera.orderStatus,ordera.orderType,ordera.userId " +
				"FROM t_user usera, t_order ordera WHERE usera.id = ordera.userId AND usera.id = 1";
		
		try {			
			List<User> list = operator.query(sql,  User.class, null);
			if( list != null) 
			{
				System.out.println("query back record count: " + list.size() );
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void update( IDBConnector operator) throws DBException
	{
		String sql = "insert into t_user value(12, 30, 'bbbbbb', 'test10')";
			
		try {					
			operator.beginTransaction();
			
			int count = operator.execute(sql);
			
			operator.commit();
			
			System.out.println(" back count : " + count);
		}
		catch(Exception e) {
			e.printStackTrace();
			boolean back = operator.rollback();    // operator.rollback();
			if( !back ){
				System.out.println(" Failed for executeUpdate.");
			}
		}	
		finally
		{
			operator.releasePersistInstance();
		}
	}
	
	private static void printClumns(Connection conn) throws Exception
	{
		String sql = "SELECT user.id,user.age,user.password,user.username,ordera.orderId,ordera.goodsName,ordera.orderStatus,ordera.orderType,ordera.userId " +
				"FROM t_user user, t_order ordera WHERE user.id = ordera.userId AND USER.id = 1 LIMIT 0,20";
//		String sql = "SELECT id, age, password, username, ordera.orderId,ordera.goodsName,ordera.orderStatus,ordera.orderType,ordera.userId " +
//				"FROM t_user, t_order ordera WHERE id = ordera.userId AND id = 1 LIMIT 0,20";
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet result  = stmt.executeQuery( sql );	
			
			StringBuilder builder = new StringBuilder();
			
			ResultSetMetaData metaData = result.getMetaData();
			int count = metaData.getColumnCount();
			for( int i=1; i<=count; i++){
				builder.append(i).append(" : CatalogName=").append(metaData.getCatalogName(i)).append("; ClassName=").append(metaData.getColumnClassName(i))
					.append("; Label=").append(metaData.getColumnLabel(i)).append("; Type=").append(metaData.getColumnTypeName(i))
					.append("; SchemaName=").append(metaData.getSchemaName(i)).append("; TableName=").append(metaData.getTableName(i))
					.append(" \r\n");
			}
			
			System.out.println( builder.toString() );
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(stmt != null)
				stmt.close();
			if( conn != null)
				conn.close();
		}
	}
	
	public static void main( String[] args) {		
		try{		
			IDBCluster cluster = DBClusterFactory.createInstanceFile("conf/singleconfig.xml");
			
			IDBConnector connector = cluster.getPersistInstance();
//			update( connector);
			
			connector = DBClusterFactory.createInstanceFile("conf/singleconfig.xml");
			query(cluster);
			
//			IDBConnector operator = new DBConnector("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=UTF-8", "root","changpu");
//			query(operator);			
//			update(operator);	
						
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=UTF-8","root","changpu");
//			DatabaseMetaData metaData = conn.getMetaData();			
//			System.out.println( metaData.getDatabaseProductName() );				
//			printClumns(conn);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
