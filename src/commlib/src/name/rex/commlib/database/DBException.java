package name.rex.commlib.database;

public class DBException extends Exception
{
    public DBException()
    {

    }

	public DBException( String errMsg) 
    {
		super( errMsg );
	}

    public DBException( String errMsg, Throwable cause )
    {
        super( errMsg, cause );
    }

    public DBException( Throwable cause )
    {
        super( cause );
    }
}
