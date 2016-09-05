package com.quanshi.uclib.service;

import org.apache.commons.lang.StringUtils;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import name.rex.commlib.net.HttpWrapperRes;
import name.rex.commlib.net.HttpWrapper;

public class ServiceBase
{
    private static Logger log = LoggerFactory.getLogger( ServiceBase.class );
    protected HttpWrapperRes lastRes = null;

    protected String proxyHost;
    protected int   proxyPort;
    protected String proxyScheme;

    public ServiceBase()
    {

    }

    public HttpWrapperRes parseResponseBase( HttpWrapperRes res ) throws ServiceException
    {
        String errmsg;
        this.lastRes = res;

        if ( null == res )
        {
            errmsg = "ServiceBase, http request failed: " + HttpWrapper.getError();
            log.warn( errmsg );
            throw new ServiceException( ServiceException.ERROR_NETWORK, errmsg );
        }

        if ( res.status < 200 || res.status >= 300 )
        {
            errmsg = "ServiceBase, response not 2xx: " + res.status;
            log.warn( errmsg );
            
            ServiceException excep = new ServiceException( 
                    ServiceException.ERROR_STATUS, errmsg );
            excep.setStatusCode( res.status );
            
			if ( ! StringUtils.isBlank( res.content ) )
			{
				excep.setContent( res.getForceContent() );
			}
            
            throw excep;
        }

        return res;
    }

    public HttpWrapperRes getLastRes()
    {
        return this.lastRes;
    }

    public int getLastStatus()
    {
        return ( null == lastRes ) ? 0 : lastRes.status;
    }

    public String getLastContent()
    {
        return ( null == lastRes ) ? null : lastRes.content;
    }

    public void setProxy( String host, int port, String scheme )
    {
        proxyHost = host;
        proxyPort = port;
        proxyScheme = scheme;
    }

    protected void enableProxy()
    {
        if ( null != proxyHost && proxyPort > 0 && null != proxyScheme )
        {
            HttpWrapper.setProxy( proxyHost, proxyPort, proxyScheme );
        }
    }
}
