package name.rex.commlib.database;

import java.util.List;
import name.rex.commlib.database.DBPage;
import name.rex.commlib.database.DBException;
import name.rex.commlib.database.interfaces.IDBConnector;
import name.rex.commlib.database.interfaces.IDBPersistOwner;

public class DBPersist implements IDBConnector
{
    private IDBPersistOwner owner = null;
    private IDBConnector conn = null;

    public DBPersist( IDBPersistOwner owner, IDBConnector conn )
    {
        this.owner = owner;
        this.conn = conn;
    }

    protected void finalize()
    {
        if ( null != owner )
        {
            try
            {
                owner.releasePersistInOwner( conn );
                conn = null;
                owner = null;
            }
            catch( Exception e )
            {
                ;
            }
            finally
            {
                conn = null;
                owner = null;
            }
            
        }
    }

    public IDBConnector getPersistInstance() throws DBException
    {
        return null;
    }

    public void releasePersistInstance() throws DBException
    {
        owner.releasePersistInOwner( conn );
        conn = null;
        owner = null;
    }

    public void close()
    {
        conn.close();
    }

    public <T> List<T> query( String sql, Class<T> classType, DBPage page ) throws DBException
    {
    	throw new DBException( "Don't need transaction connect." );
    }

    public int execute(String sql ) throws DBException
    {
        return conn.execute( sql );
    }

    public int execute( String sql, DBGeneratedKeyResult generatedKeyRes ) throws DBException
    {
        return conn.execute( sql, generatedKeyRes );
    }

    public void beginTransaction() throws DBException
    {
        conn.beginTransaction();
    }

    public void commit() throws DBException
    {
        conn.commit();
    }

    public boolean rollback() throws DBException
    {
        return conn.rollback();
    }

    public void setTranIsolation( int level ) throws DBException
    {
        conn.setTranIsolation( level );
    }
}
