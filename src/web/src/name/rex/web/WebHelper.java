package name.rex.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import name.rex.commlib.format.JSONHelper;

public class WebHelper
{
    private static Logger log = LoggerFactory.getLogger( WebHelper.class );
    private static boolean loaded = false;
    private static IWebApplication  globalWebApplication = null;

    public static IWebApplication getWebApplication()
    {
        return globalWebApplication;
    }

    public static ServletRequest getCurrentRequest()
    {
        return RequestFilter.getCurrentRequest();
    }

    public static ServletResponse getCurrentResponse()
    {
        return RequestFilter.getCurrentResponse();
    }

    public static void setRequestInfo( ServletRequest req, Object reqInfo )
    {
        log.debug( String.format( "set requestInfo %d on request %d", 
                    reqInfo.hashCode(), req.hashCode() ) );

        req.setAttribute( "requestInfo", reqInfo );
    }

    public static Object getRequestInfo( ServletRequest req )
    {
        Object reqInfo = req.getAttribute( "requestInfo" );

        if ( null == reqInfo )
        {
            log.warn( String.format( "get requestInfo is null on request %d", 
                        req.hashCode() ) );
        }
        else
        {
            log.debug( String.format( "get requestInfo %d on request %d", 
                        reqInfo.hashCode(), req.hashCode() ) );
        }

        return reqInfo;
    }

    @SuppressWarnings( "unchecked" )
    public static<T> T getRequestInfo( ServletRequest req,  Class<T> clazz )
    {
        T  reqInfo = (T)( getRequestInfo( req ) );

        if ( reqInfo == null )
        {
            try
            {
                reqInfo = clazz.newInstance();

                if ( null != reqInfo )
                {
                    log.debug( String.format( "new requestInfo %d", reqInfo.hashCode() ) );

                    setRequestInfo( req, reqInfo );
                }
            }
            catch( Exception e )
            {
                reqInfo = null;
            }
        }

        if ( log.isDebugEnabled() && null != reqInfo )
        {
            StringBuilder reqInfoValue = new StringBuilder();

            reqInfoValue.append( "requestInfo " ).append( reqInfo.hashCode() ).
                append( "=>" ).append( JSONHelper.toJSONString( reqInfo ) );

            log.debug( reqInfoValue.toString() );
        }

        return reqInfo;
    }

    public static<T> T getRequestInfo( Class<T> clazz )
    {
        return getRequestInfo( getCurrentRequest(), clazz );
    }

    public static IWebApplication loadWebApplication( ServletContext servletContext )
    {
        if ( null != globalWebApplication && true == loaded )
        {
            return globalWebApplication;
        }

        loaded = true;
        if ( null == servletContext )
        {
            return globalWebApplication;
        }

        String className = servletContext.getInitParameter( "webApplicationClass" );
        if ( null == className )
        {
            log.error( "not found webApplicationClass parameter." );
            return null;
        }

        try
        {
            log.info( "webApplicationClass: " + className );
            if ( ! IWebApplication.class.isAssignableFrom( Class.forName( className ) ) )
            {
                throw new Exception( String.format( "Class %s not implement IWebApplication", className ) );
            }

            globalWebApplication = (IWebApplication)( Class.forName( className ).newInstance() );
            return globalWebApplication;
        }
        catch( Exception e )
        {
            globalWebApplication = null;
            log.error( "load WebApplication failed: " + e.getMessage() );
            return null;
        }
    }
}
