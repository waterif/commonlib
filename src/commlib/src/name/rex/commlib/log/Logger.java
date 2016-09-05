package name.rex.commlib.log;

import java.lang.Throwable;
import java.lang.StackTraceElement;
import java.util.Set;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.slf4j.LoggerFactory;

public class Logger
{
    /* Prefxi */
    private static ConcurrentMap<String, String> mapGlobalPrefix = new ConcurrentHashMap<String, String>();
    private static ThreadLocal<Map<String, String>> mapLocalPrefix = new ThreadLocal< Map<String, String> >(); 

    private Boolean getPrefix( StringBuilder prefix, 
            Map<String, String> mapPrefix, Boolean begin )
    {
        if ( null == mapPrefix )
        {
            return begin;
        }

        Set<String> prefixKeys = mapPrefix.keySet();

        if ( null != prefixKeys )
        {
            for( String key: prefixKeys )
            {
                if ( begin )
                {
                    begin = false;
                }
                else
                {
                    prefix.append( " " );
                }

                prefix.append( "<" ).append( key ).append( ":" ).append( mapPrefix.get( key ) ).append( ">" );
            }
        }

        return begin;
    }

    private String getPrefix( Throwable t )
    {
        Boolean begin = true;
        StringBuilder prefix = new StringBuilder();

        prefix.append( "[" );

        begin = getPrefix( prefix, mapGlobalPrefix, begin );
        begin = getPrefix( prefix, mapLocalPrefix.get(), begin );
        
        {
            if ( begin )
            {
                begin = false;
            }
            else
            {
                prefix.append( " " );
            }

            prefix.append( "<call:" ).append( getTraceInfo( t ) ).append( ">" );
        }

        prefix.append( "] " );

        return prefix.toString();
    }

    public static void addGlobalPrefix( String key, String value )
    {
        mapGlobalPrefix.put( key, value );
    }

    public static void removeGlobalPrefix( String key )
    {
        mapGlobalPrefix.remove( key );
    }

    public static void clearGlobalPrefix()
    {
        mapGlobalPrefix.clear();
    }

    private static Map<String, String> getMapPrefix()
    {
        Map<String, String> mapPrefix = mapLocalPrefix.get();
        
        if ( null == mapPrefix )
        {
            mapPrefix = new HashMap<String, String>();
            mapLocalPrefix.set( mapPrefix );
        }

        return mapPrefix;
    }

    public static void addPrefix( String key, String value )
    {
        getMapPrefix().put( key, value );
    }

    public static void removePrefix( String key )
    {
        getMapPrefix().remove( key );
    }

    public static void clearPrefix()
    {
        getMapPrefix().clear();
    }

    /* Exception stackMessage Convert */
    public static String getStackMessage( Throwable t )
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        
        try
        {
            t = ( null == t ) ? new Exception() : t ;
            t.printStackTrace(pw);
            return sw.toString();
        }
        finally
        {
            pw.close();
        }
    }

    public static String getStackMessage()
    {
        return getStackMessage( null );
    }

    /* Logger output function same as slf4j Logger */
    private String name = null;
    private org.slf4j.Logger logger = null;

    public Logger( String name )
    {
        this.name = name;
        logger = LoggerFactory.getLogger( name );
    }

    public Logger( final Class clazz )
    {
        this.name = clazz.getName();
        logger = LoggerFactory.getLogger( clazz );
    }

    private String getTraceInfo( Throwable t )
    {
        String traceInfo = new String();
        StackTraceElement[] traces = ( t == null ) ? Thread.currentThread().getStackTrace() : t.getStackTrace();

        for( int i = 0, level=0; i < traces.length && level < 2; i++ ) 
        {
        	StackTraceElement trace = traces[i];
        	if( level == 0 && ! trace.getClassName().equals( name ) )
            {
        		continue;
            }

            String lineString = trace.getClassName();
        	lineString = ( lineString != null ) ? ( lineString.substring( lineString.lastIndexOf(".") + 1 ) ) : "";
            lineString += "." + trace.getMethodName() + "()";
            if ( trace.getLineNumber() > 0 )
            {
                lineString += ":" + trace.getLineNumber();
            }
            
            traceInfo = ( traceInfo.isEmpty() ) ? lineString : lineString + "->" + traceInfo;
            level++;
        }

        return traceInfo.toString();
    }

    public boolean isTraceEnabled()
    {
        return logger.isTraceEnabled();
    }

    public void trace( Object message )
    {
        if ( !logger.isTraceEnabled() )
        {
            return;
        }

        logger.trace( getPrefix(null) + message );
    }

    public void trace( Object message, Throwable t )
    {
        if ( !logger.isTraceEnabled() )
        {
            return;
        }

        logger.trace( getPrefix(t) + message, t );
    }

    public boolean isDebugEnabled()
    {
        return logger.isDebugEnabled();
    }

    public void debug( Object message )
    {
        if ( !logger.isDebugEnabled() )
        {
            return;
        }

        logger.debug( getPrefix(null) + message );
    }

    public void debug( Object message, Throwable t )
    {
        if ( !logger.isDebugEnabled() )
        {
            return;
        }

        logger.debug( getPrefix(t) + message, t );
    }

    public boolean isInfoEnabled()
    {
        return logger.isInfoEnabled();
    }

    public void info( Object message )
    {
        if ( !logger.isInfoEnabled() )
        {
            return;
        }

        logger.info( getPrefix(null) + message );
    }

    public void info( Object message, Throwable t )
    {
        if ( !logger.isInfoEnabled() )
        {
            return;
        }

        logger.info( getPrefix(t) + message, t );
    }

    public boolean isWarnEnabled()
    {
        return logger.isWarnEnabled();
    }

    public void warn( Object message )
    {
        if ( !logger.isWarnEnabled() )
        {
            return;
        }

        logger.warn( getPrefix(null) + message );
    }

    public void warn( Object message, Throwable t )
    {
        if ( !logger.isWarnEnabled() )
        {
            return;
        }

        logger.warn( getPrefix(t) + message, t );
    }

    public boolean isErrorEnabled()
    {
        return logger.isErrorEnabled();
    }

    public void error( Object message )
    {
        if ( !logger.isErrorEnabled() )
        {
            return;
        }

        logger.error( getPrefix(null) + message );
    }

    public void error( Object message, Throwable t )
    {
        if ( !logger.isErrorEnabled() )
        {
            return;
        }

        logger.error( getPrefix(t) + message, t );
    }

    public boolean isFatalEnabled()
    {
        return logger.isErrorEnabled(); 
    }

    public void fatal( Object message )
    {
        if ( !logger.isErrorEnabled() )
        {
            return;
        }

        logger.error( getPrefix(null) + message );
    }

    public void fatal( Object message, Throwable t )
    {
        if ( !logger.isErrorEnabled() )
        {
            return;
        }

        logger.error( getPrefix(t) + message, t );
    }
}


