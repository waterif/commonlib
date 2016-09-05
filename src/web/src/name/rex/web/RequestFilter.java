package name.rex.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletContext;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

public class RequestFilter implements Filter
{
    private static Logger log = LoggerFactory.getLogger( RequestFilter.class );
    private static ThreadLocal<ServletRequest> localRequest = new ThreadLocal<ServletRequest>();
    private static ThreadLocal<ServletResponse> localResponse = new ThreadLocal<ServletResponse>();
    private ServletContext servletContext = null;

    public static ServletRequest getCurrentRequest()
    {
        return localRequest.get();
    }

    public static ServletResponse getCurrentResponse()
    {
        return localResponse.get();
    }

    public static void setCurrentRequest( ServletRequest request )
    {
        localRequest.set( request );
    }

    public void init( FilterConfig filterConfig ) throws ServletException
    {
        log.info( "enter RequestFilter init" );
        servletContext = filterConfig.getServletContext();
        IWebApplication webApp = WebHelper.loadWebApplication( servletContext );
        
        if ( null != webApp )
        {
            log.info( "call webApplication onInitFilter" );
            webApp.onInitFilter( filterConfig );
        }
    }

	public void doFilter( ServletRequest req, ServletResponse resp, FilterChain filterChain ) 
        throws IOException, ServletException 
	{	
        log.debug( "enter RequestFilter::doFilter" );
      
        localRequest.set( req );
        localResponse.set( resp );

        IWebApplication webApp = WebHelper.loadWebApplication( servletContext );
        
        if ( null != webApp )
        {
            log.debug( "call webApplication::onFilter" );
            webApp.onFilter( req, resp, filterChain );
        }
        else
        {
            log.debug( "call filterChain::doFilter" );
		    filterChain.doFilter(req, resp);
        }
	}

    public void destroy()
    {
        log.info( "enter RequestFilter::destroy" );
        IWebApplication webApp = WebHelper.loadWebApplication( servletContext );
        if ( null != webApp )
        {
            log.info( "call webApplication::onDestroyFilter" );
            webApp.onDestroyFilter();
        }
    }
}
