package name.rex.web;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public interface IWebApplication
{
    public void onInitialize( ServletContext servletContext );
    public void onDestroyed( ServletContext servletContext );
    public void onInitFilter( FilterConfig filterConfig ) throws ServletException;
    public void onFilter( ServletRequest req, ServletResponse resp,  FilterChain filterChain )
        throws IOException, ServletException;
    public void onDestroyFilter();
}
