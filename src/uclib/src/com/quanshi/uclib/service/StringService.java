package com.quanshi.uclib.service;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import name.rex.commlib.net.HttpWrapper;
import name.rex.commlib.net.HttpWrapperRes;

public class StringService extends ServiceBase
{
    private static Logger log = LoggerFactory.getLogger( StringService.class );
    
    public StringService()
    {
        super();
    }

    protected String parseResponseContent( HttpWrapperRes res ) throws ServiceException
    {
        parseResponseBase( res );
        return res.getForceContent();
    }

    // GET
    protected String getContent( String url ) throws ServiceException
    {
        enableProxy();
        HttpWrapperRes res = HttpWrapper.get( url, null, false );
        return parseResponseContent( res );
    }

    //PUT DATA
    protected String postDataContent( String url, byte[] data, String contentType ) throws ServiceException
    {
        enableProxy();
        HttpWrapperRes res = HttpWrapper.postData( url, data, contentType, null, false); 
        return parseResponseContent( res );
    }

    // POST TEXT
    protected String postTextContent( String url, String text, String contentType ) throws ServiceException
    {
        enableProxy();
        HttpWrapperRes res = HttpWrapper.postText( url, text, contentType, null, false );
        return parseResponseContent( res );
    }

    // POST PARAM
    protected String postParamContent( String url, Map<String, ? extends Object> params ) throws ServiceException 
    {
        enableProxy();
        HttpWrapperRes res = HttpWrapper.postParam( url, params, null, false );
        return parseResponseContent( res );
    }

    // POST JSON
    protected String postJsonContent( String url, Object object ) throws ServiceException 
    {
        enableProxy();
        HttpWrapperRes res = HttpWrapper.postJson( url, object, null, false );
        return parseResponseContent( res ); 
    }

    //PUT DATA
    protected String putDataContent( String url, byte[] data, String contentType ) throws ServiceException
    {
        enableProxy();
        HttpWrapperRes res = HttpWrapper.putData( url, data, contentType, null, false); 
        return parseResponseContent( res );
    }
    
    // PUT TEXT
    protected String putTextContent( String url, String text, String contentType ) throws ServiceException
    {
        enableProxy();
        HttpWrapperRes res = HttpWrapper.putText( url, text, contentType, null, false );
        return parseResponseContent( res );
    }

    // PUT PARAM
    protected String putParamContent( String url, Map<String, ? extends Object> params ) throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.putParam( url, params, null, false );
        return parseResponseContent( res );
    }

    // PUT JSON
    protected String putJsonContent( String url, Object object ) throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.putJson( url, object, null, false );
        return parseResponseContent( res ); 
    }
    
    protected String deleteContent( String url ) throws ServiceException
    {
    	enableProxy();
    	HttpWrapperRes res = HttpWrapper.delete( url, null, false );
    	return parseResponseContent( res );
    }     
    
}
