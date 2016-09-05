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

public class JsonResultService extends JsonService
{
    private static Logger log = LoggerFactory.getLogger( JsonResultService.class );
    private Integer resultCode = -1;
    protected String codeName = "code";
    protected String dataName = "data";

    public JsonResultService( String codeName, String dataName )
    {
        super();
        this.codeName = codeName;
        this.dataName = dataName;
    }

    public Integer getResultCode()
    {
        return resultCode;
    }

    protected JSONObject parseResponseResult( HttpWrapperRes res ) 
        throws ServiceException
    {
        String errmsg;
        JSONObject responseJSON = parseResponseJson( res );
        
        resultCode = responseJSON.getInteger( codeName );
        if ( null ==resultCode )
        {
            errmsg = String.format( 
                    "invalid json result format, not found %s node: %s", 
                    codeName, res.content );
            log.error( errmsg );
            throw new ServiceException( ServiceException.ERROR_FORMAT, errmsg );
        }
        
        if ( 0 != resultCode )
        {
            errmsg = String.format( "ServiceBase, reponse error code: %d: response: %s", 
                    resultCode, res.content );
            log.warn( errmsg );

            ServiceException excep = new ServiceException( 
                    ServiceException.ERROR_RESULT, errmsg );

            excep.setResultCode( resultCode );
            throw excep;
        }

        return responseJSON;
    }

    protected JSONObject parseResponseResultJson( HttpWrapperRes res ) 
        throws ServiceException
    {
        JSONObject responseJSON = parseResponseResult( res );

        return responseJSON.getJSONObject( dataName );
    }

    protected JSONArray parseResponseResultJsonArray( HttpWrapperRes res )
        throws ServiceException
    {
        JSONObject responseJSON = parseResponseResult( res );

        return responseJSON.getJSONArray( dataName );
    }

    protected String parseResponseResultString( HttpWrapperRes res )
        throws ServiceException
    {
        JSONObject responseJSON = parseResponseResult( res );

        return responseJSON.getString( dataName );
    }

    protected Short parseResponseResultShort( HttpWrapperRes res )
        throws ServiceException
    {
        JSONObject responseJSON = parseResponseResult( res );

        return responseJSON.getShort( dataName );
    }

    protected Integer parseResponseResultInteger( HttpWrapperRes res )
        throws ServiceException
    {
        JSONObject responseJSON = parseResponseResult( res );

        return responseJSON.getInteger( dataName );
    }

    protected Long parseResponseResultLong( HttpWrapperRes res )
        throws ServiceException
    {
        JSONObject responseJSON = parseResponseResult( res );

        return responseJSON.getLong( dataName );
    }

    protected <T> List<T> parseResponseResultArray( HttpWrapperRes res, Class<T> valueType ) 
        throws ServiceException
    {
        JSONObject responseJSON = parseResponseResult( res );

        try
        {
            List<T> listT = JSONHelper.getObjectList( responseJSON, dataName, valueType );
            return listT;
        }
        catch ( Exception e )
        {
            String errmsg = String.format( 
                    "invalid json format, eception: %s, content: %s ", 
                    e.getMessage(), res.content );
            log.error( errmsg );
            throw new ServiceException( ServiceException.ERROR_FORMAT, errmsg );
        }
    }

    protected <T> T parseResponseResultObject( HttpWrapperRes res, Class<T> valueType )  
        throws ServiceException
    {
        JSONObject responseJSON = parseResponseResult( res );

        try
        {
            T  t = JSONHelper.getObject( responseJSON, dataName, valueType );
            return t;
        }
        catch ( Exception e )
        {
            String errmsg = String.format( 
                    "invalid json format, eception: %s, content: %s ", 
                    e.getMessage(), res.content );
            log.error( errmsg );
            throw new ServiceException( ServiceException.ERROR_FORMAT, errmsg );
        }
    }

    // GET
    protected JSONObject getJson( String url ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.get( url, null, false );
        return parseResponseResultJson( res );
    }

    protected JSONArray getJsonArray( String url ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.get( url, null, false );
        return parseResponseResultJsonArray( res );
    }

    protected <T> T getObject( String url, Class<T> valueType ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.get(url, null, false );
        return parseResponseResultObject( res, valueType );
    }

    protected <T> List<T> getArray( String url,  Class<T> valueType ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.get( url, null, false );
        return parseResponseResultArray( res, valueType ); 
    }

    // POST TEXT
    protected JSONObject postTextJson( String url, String text, String contentType ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postText( url, text, contentType, null, false );
        return parseResponseResultJson( res );
    }

    protected JSONArray postTextJsonArray( String url, String text, String contentType ) 
        throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postText( url, text, contentType, null, false );
        return parseResponseResultJsonArray( res );
    }

    protected <T> T postTextObject( String url, String text, String contentType,
            Class<T> valueType ) throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postText( url, text, contentType, null, false );
        return parseResponseResultObject( res, valueType );
    }

    protected <T> List<T> postTextArray( String url, String text, String contentType,
            Class<T> valueType ) throws ServiceException 
    {
    	enableProxy();
        HttpWrapperRes res = HttpWrapper.postText( url, text, contentType, null, false );
        return parseResponseResultArray( res, valueType );
    }

    // POST PARAM
    protected <T> List<T> postParamArray( String url, 
            Map<String, ? extends Object> params, Class<T> valueType ) 
        throws ServiceException 
    {
        HttpWrapperRes res = HttpWrapper.postParam( url, params, null, false );
        return parseResponseResultArray( res, valueType ); 
    }

    protected <T> T postParamObject( String url, Map<String, ? extends Object> params, Class<T> valueType ) 
        throws ServiceException 
    {
        HttpWrapperRes res = HttpWrapper.postParam( url, params, null, false );
        return parseResponseResultObject( res, valueType ); 
    }

    protected void postParam( String url, Map<String, ? extends Object> params ) 
        throws ServiceException 
    {
        HttpWrapperRes res = HttpWrapper.postParam( url, params, null, false );
        parseResponseResult( res ); 
    }

    // POST JSON
    protected <T> List<T> postJsonArray( String url, Object object, Class<T> valueType ) 
        throws ServiceException 
    {
        HttpWrapperRes res = HttpWrapper.postJson( url, object, null, false );
        return parseResponseResultArray( res, valueType ); 
    }

    protected <T> T postJsonObject( String url, Object object, Class<T> valueType ) 
        throws ServiceException
    {
        HttpWrapperRes res = HttpWrapper.postJson( url, object, null, false );
        return parseResponseResultObject( res, valueType );
    }

    protected Integer postJsonInteger( String url, Object object ) 
        throws ServiceException 
    {
        HttpWrapperRes res = HttpWrapper.postJson( url, object, null, false );
        return parseResponseResultInteger( res ); 
    }

    protected void postJson( String url, Object object ) 
        throws ServiceException 
    {
        HttpWrapperRes res = HttpWrapper.postJson( url, object, null, false );
        parseResponseResult( res ); 
    }
}
