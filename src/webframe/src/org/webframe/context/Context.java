package org.webframe.context;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import name.rex.commlib.config.XmlConfig;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import name.rex.web.IWebApplication;
import name.rex.web.WebHelper;

import org.webframe.base.Profile;

// 整个Web应用只有一个实例
public class Context implements IWebApplication
{
    // 数据成员
    static private Logger   log = LoggerFactory.getLogger( Context.class );
    static private Context  context = null;
    private ServletContext  servletContext = null;
    private String          configPath = null;
    private XmlConfig       commonCfg = null;

    // 构造函数
    public Context() throws Exception
    {
        if ( null != context )
        {
            throw new Exception( "only one instance." );
        }

        context = this;
    }

    // 返回当前应用的Context
    static public Context getInstance()
    {
        return context;
    }

    public ServletContext getServletContext()
    {
        return servletContext;
    }

    public String getConfigPath()
    {
        return configPath;
    }
    
    // 应用程序加载时被调用
    public void onInitialize( ServletContext servletContext ) 
    {
        String filePath;
        String content;

        log.info( "Startup WebFrame Application..." );

        // 初始化Context
        log.info( "initialize context ..." );
        this.servletContext = servletContext;

        // 读入配置文件路径
        try
        {
            log.info( "read configure file path..." );
            configPath = this.servletContext.getRealPath( Profile.CONFIG_FILE_PREFIX );
            log.debug( "read path: " + configPath  );
        }
        catch( Exception e )
        {
            this.configPath = null;
            log.error( "read configure file path failed: " + e.getMessage() );
        }
        
        // 读入普通配置文件
        try
        {
            log.info( "read common configure file..." );
            filePath = this.servletContext.getRealPath( Profile.CONFIG_COMMON_FILENAME );
            commonCfg = XmlConfig.createInstanceFile( filePath );
        }
        catch( Exception e )
        {
            this.commonCfg = null;
            log.error( "read common configure file failed: " + e.getMessage() );
        }
        
        //启动完成
        log.info( ">> initialize finshed <<" );
    }

    // 应用程序退出时调用
    public void onDestroyed( ServletContext servletContext )
    {
        log.info( ">|=>|=>|=>|=>|=>|=>|=>|=>|=>|=>|=>|=>|=>|=>|=" );
        log.info( ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.info( "> webframe shutdown finished.               >" );
        log.info( ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
    }

    public void onInitFilter( FilterConfig filterConfig ) throws ServletException
    {
        //启动完成
        log.info( ">|=>|=>|=>|=>|=>|=>|=>|=>|=>|=>|=>|=>|=>|=>|=" );
        log.info( ">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<" );
        log.info( ">>>>>>   webframe startup finished.    <<<<<<" );
        log.info( ">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<" );
    }
    
    // 当有新请求是被调用
    public void onFilter( ServletRequest req, ServletResponse resp,  
            FilterChain filterChain ) throws IOException, ServletException
    {
        HttpServletRequest httpReq = ( HttpServletRequest )req;
        HttpServletResponse httpResp = ( HttpServletResponse ) resp;

        // 调用默认的Filter
        filterChain.doFilter( httpReq, httpResp );
    }

    public void onDestroyFilter()
    {

    }
}
