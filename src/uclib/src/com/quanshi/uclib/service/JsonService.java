package com.quanshi.uclib.service;

import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import name.rex.commlib.net.HttpWrapper;
import name.rex.commlib.net.HttpWrapperRes;
import name.rex.commlib.format.JSONHelper;

public class JsonService extends StringService
{
    private static Logger log = LoggerFactory.getLogger( JsonService.class );

    public JsonService()
    {
        super();
    }

    // JSON
    protected JSONObject parseResponseJson( HttpWrapperRes res ) 
        throws ServiceException 
    {
        parseResponseContent( res );

        String errmsg;
        JSONObject responseJSON = JSONHelper.parseObject( res.content );
        if( null == responseJSON )
        {
            errmsg = "JsonService, response is invalid format for json object: " + res.content;
            log.warn( errmsg );
            throw new ServiceException( ServiceException.ERROR_FORMAT, errmsg );
        }

        return responseJSON;
    }

    protected JSONArray parseResponseJsonArray( HttpWrapperRes res ) 
        throws ServiceException 
    {
        parseResponseContent( res );

        String errmsg;
        JSONArray responseJSONArray = JSONHelper.parseArray( res.content );
        if( null == responseJSONArray )
        {
            errmsg = "JsonService, response is invalid format for json array: " + res.content;
            log.warn( errmsg );
            throw new ServiceException( ServiceException.ERROR_FORMAT, errmsg );
        }

        return responseJSONArray;
    }

    // OBJECT
    protected <T> T parseResponseObject( HttpWrapperRes res, Class<T> valueType ) 
        throws ServiceException
    {
        parseResponseContent( res );

        String errmsg;
        T t = JSONHelper.parseObject( res.content, valueType );
        if ( null == t )
        {
            errmsg = "JsonService, response is invalid format for object: " + res.content;
            log.warn( errmsg );
            throw new ServiceException( ServiceException.ERROR_FORMAT, "parseResponseObject failed." );
        }
        return t;
    }

    protected <T> List<T> parseResponseArray( HttpWrapperRes res, Class<T> valueType ) 
        throws ServiceException
    {
        parseResponseContent( res );

        String errmsg;
        List<T> listT = JSONHelper.parseArray( res.content, valueType );
        if ( null == listT )
        {
            errmsg = "JsonService, response is invalid format for array: " + res.content;
            log.warn( errmsg );
            throw new ServiceException( ServiceException.ERROR_FORMAT, "getObjectList failed." );
        }
        return listT;
    }

    // GET
    protected JSONObject getJson( String url ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.get( url, null, false );
        return parseResponseJson( res );
    }

    protected JSONArray getJsonArray( String url ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.get( url, null, false );
        return parseResponseJsonArray( res );
    }

    protected <T> T getObject( String url, Class<T> valueType ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.get(url, null, false );
        return parseResponseObject( res, valueType );
    }

    protected <T> List<T> getArray( String url,  Class<T> valueType ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.get( url, null, false );
        return parseResponseArray( res, valueType ); 
    }

    // POST TEXT
    protected JSONObject postTextJson( String url, String text, String contentType ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postText( url, text, contentType, null, false );
        return parseResponseJson( res );
    }

    protected JSONArray postTextJsonArray( String url, String text, String contentType ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postText( url, text, contentType, null, false );
        return parseResponseJsonArray( res );
    }

    protected <T> T postTextObject( String url, String text, String contentType,
            Class<T> valueType ) throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postText( url, text, contentType, null, false );
        return parseResponseObject( res, valueType );
    }

    protected <T> List<T> postTextArray( String url, String text, String contentType,
            Class<T> valueType ) throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postText( url, text, contentType, null, false );
        return parseResponseArray( res, valueType );
    }

    // POST PARAM
    protected JSONObject postParamJson( String url, Map<String, ? extends Object> params ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postParam( url, params, null, false );
        return parseResponseJson( res );
    }

    protected JSONArray postParamJsonArray( String url, Map<String, ? extends Object> params ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postParam( url, params, null, false );
        return parseResponseJsonArray( res );
    }

    protected <T> T postParamObject( String url, Map<String, 
            ? extends Object> params, Class<T> valueType ) throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postParam( url, params, null, false );
        return parseResponseObject( res, valueType );
    }

    protected <T> List<T> postParamArray( String url, 
            Map<String, ? extends Object> params, Class<T> valueType ) throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postParam( url, params, null, false );
        return parseResponseArray( res, valueType );
    }

    // POST JSON
    protected JSONObject postJsonJson( String url, Object object ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postJson( url, object, null, false );
        return parseResponseJson( res ); 
    }

    protected JSONArray postJsonJsonArray( String url, Object object ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postJson( url, object, null, false );
        return parseResponseJsonArray( res ); 
    }

    protected <T> T postJsonObject( String url, Object object, Class<T> valueType ) 
        throws ServiceException
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postJson( url, object, null, false );
        return parseResponseObject( res, valueType );
    }

    protected <T> List<T> postJsonArray( String url, Object object, Class<T> valueType ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postJson( url, object, null, false );
        return parseResponseArray( res, valueType ); 
    }

    // PUT TEXT
    protected JSONObject putTextJson( String url, String text, String contentType ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.putText( url, text, contentType, null, false );
        return parseResponseJson( res );
    }

    protected JSONArray putTextJsonArray( String url, String text, String contentType ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.putText( url, text, contentType, null, false );
        return parseResponseJsonArray( res );
    }

    protected <T> T putTextObject( String url, String text, String contentType,
            Class<T> valueType ) throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.putText( url, text, contentType, null, false );
        return parseResponseObject( res, valueType );
    }

    protected <T> List<T> putTextArray( String url, String text, String contentType,
            Class<T> valueType ) throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.putText( url, text, contentType, null, false );
        return parseResponseArray( res, valueType );
    }

    // PUT PARAM
    protected JSONObject putParamJson( String url, Map<String, ? extends Object> params ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.putParam( url, params, null, false );
        return parseResponseJson( res );
    }

    protected JSONArray putParamJsonArray( String url, Map<String, ? extends Object> params ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.putParam( url, params, null, false );
        return parseResponseJsonArray( res );
    }

    protected <T> T putParamObject( String url, Map<String, ? extends Object> params, Class<T> valueType ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.putParam( url, params, null, false );
        return parseResponseObject( res, valueType );
    }

    protected <T> List<T> putParamArray( String url, Map<String, ? extends Object> params, Class<T> valueType ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.putParam( url, params, null, false );
        return parseResponseArray( res, valueType );
    }

    // PUT JSON
    protected JSONObject putJsonJson( String url, Object object ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.putJson( url, object, null, false );
        return parseResponseJson( res ); 
    }

    protected JSONArray putJsonJsonArray( String url, Object object ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.putJson( url, object, null, false );
        return parseResponseJsonArray( res ); 
    }

    protected <T> T putJsonObject( String url, Object object, Class<T> valueType ) 
        throws ServiceException
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.putJson( url, object, null, false );
        return parseResponseObject( res, valueType );
    }

    protected <T> List<T> putJsonArray( String url, Object object, Class<T> valueType ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.putJson( url, object, null, false );
        return parseResponseArray( res, valueType ); 
    }
    
    protected <T> T deleteObject( String url, Class<T> classType) throws ServiceException
    {
    	enableProxy();
    	HttpWrapperRes res = HttpWrapper.delete( url, null, false );
    	return parseResponseObject( res, classType );
    }
}
