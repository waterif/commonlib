package name.rex.web;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

public class ContextListener implements ServletContextListener
{
    private static Logger log = LoggerFactory.getLogger( ContextListener.class );

    public void contextInitialized( ServletContextEvent sce )
    {
        log.info( "enter ContextListener::contextInitialized" );

        ServletContext servletContext = sce.getServletContext();
        IWebApplication webApp = WebHelper.loadWebApplication( sce.getServletContext() );

        if ( null != webApp )
        {
            log.info( "call webApplication::onInitialize." );
            webApp.onInitialize( servletContext );
        }
    }

    public void contextDestroyed( ServletContextEvent sce )
    {
        log.info( "enter ContextListener::contextDestroyed." );

        IWebApplication webApp = WebHelper.getWebApplication();
        if ( null != webApp )
        {
            log.info( "call webApplication::onDestroy." );
            webApp.onDestroyed( sce.getServletContext() );
        }
    }
}
