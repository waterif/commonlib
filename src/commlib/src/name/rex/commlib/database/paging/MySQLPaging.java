package name.rex.commlib.database.paging;

import name.rex.commlib.database.DBException;
import name.rex.commlib.database.DBPage;

public class MySQLPaging extends APaging
{
	public static MySQLPaging mysqlPaging = new MySQLPaging();
	
	private MySQLPaging(){}
	
	public static MySQLPaging getInstance()
	{
		return mysqlPaging;
	}
	
	public String buildSql(String sql, DBPage page) throws DBException {
		
		calculateLimit( page);
		
		StringBuilder builder = new StringBuilder();
		builder.append(sql).append(" LIMIT ").append(page.getStartPage()).append(",  ").append(page.getPageSize());
		
		return builder.toString();
	}	
}