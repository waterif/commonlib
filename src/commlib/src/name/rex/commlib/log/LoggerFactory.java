package name.rex.commlib.log;

import name.rex.commlib.log.Logger;

public class LoggerFactory
{
    public static Logger getLogger( String name )
    {
        return new Logger( name );
    }

    public static Logger getLogger( final Class clazz )
    {
        return new Logger( clazz );
    }
}
