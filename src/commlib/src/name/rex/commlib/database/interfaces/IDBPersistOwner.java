package name.rex.commlib.database.interfaces;

import name.rex.commlib.database.DBException;

public interface IDBPersistOwner
{
    public void releasePersistInOwner( IDBConnector op ) throws DBException;
}
