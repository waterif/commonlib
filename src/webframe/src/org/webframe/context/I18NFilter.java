package org.webframe.context;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class I18NFilter extends HttpServlet implements Filter
{
	public void doFilter( ServletRequest req, ServletResponse resp,
			 FilterChain filterChain ) throws IOException, ServletException 
	{	
		HttpServletRequest request = (HttpServletRequest) req;
		
		request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
                LocaleContextHolder.getLocale());
		
		filterChain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException 
	{
		super.init();
	}
}
