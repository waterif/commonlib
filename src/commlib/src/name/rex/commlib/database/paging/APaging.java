package name.rex.commlib.database.paging;

import name.rex.commlib.database.DBException;
import name.rex.commlib.database.DBPage;

public abstract class APaging 
{
	public abstract String buildSql( String sql, DBPage page) throws DBException ;
	
	protected void calculateLimit ( DBPage page ) throws DBException 
	{
		if( page.getPageSize() <= 0 )
		{
			throw new DBException( "pageSize is invalid: " + page.getPageSize());
		}
		
		if( page.getCurrent() <= 0 )
		{
			throw new DBException( "current is invalid: " + page.getCurrent());
		}
		
		page.setStartPage( (page.getCurrent() -1) * page.getPageSize() );
		page.setEndPage( page.getCurrent() * page.getPageSize() );
	}
}