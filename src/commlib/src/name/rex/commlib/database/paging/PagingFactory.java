package name.rex.commlib.database.paging;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import name.rex.commlib.database.DBException;
import name.rex.commlib.database.DBPage;

public class PagingFactory 
{
	public static APaging createPaging ( String sql, Connection conn ) throws SQLException
	{
		DatabaseMetaData metaData = conn.getMetaData();
		
		String DBName = metaData.getDatabaseProductName();
		if( DBName != null )
		{
			DBName = DBName.toLowerCase();
		}
		
		if( "mysql".equalsIgnoreCase(DBName))
		{
			return MySQLPaging.getInstance();
		}
		
		
		return null;
		
	}
	
	public static String buildSql( String sql, DBPage page, Connection conn) throws SQLException, DBException
	{
		if( page == null )
		{
			return sql;
		}
		
		APaging paging = createPaging( sql, conn);
		
		return paging.buildSql( sql, page );
	}
}