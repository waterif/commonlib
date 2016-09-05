package com.quanshi.uclib.service;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

import org.apache.commons.lang.StringUtils;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

public class PbxService2 extends JsonService
{
    ///////////////////////////////////////////////////////////////////////////////////
    private class AuthArg
    {
        public String developer_key;
        public String token;
    }

    public static class BaseResult
    {
        public Integer  code;
        public String   status;
    }

    // DomainInfo
    public static class DomainInfo
    {
        public String name;
        public String web;
        public String restapi;
    }

    public static class GetDomainInfoResult extends BaseResult
    {
        public DomainInfo domains;
    }

    // CallRecord
    public static class CallRecord
    {
        public Integer  id;
        public String   uuid;
        public String   channel_type;
        public String   direction;
        public Integer  duration;
        public Integer  billsec;
        public String   caller_number;
        public String   caller_easiioid;
        public String   called_number;
        public String   called_easiioid;
        public Long     start_time;
        public Long     answer_time;
        public Long     hangup_time;
        public String   record_url;
        public Integer  caller_bee_userid;
        public String   caller_bee_name;
        public Integer  called_bee_userid;
        public String   called_bee_name;
    }

    public static class QueryCallRecordResult extends BaseResult
    {
        public List<CallRecord>  datas;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    private static Logger log = LoggerFactory.getLogger( PbxService2.class );

    private static final String URI_DOMAININFO_GET_BY_DEVELOPERKEY = "/api/GetDomainInfoByDeveloperKey";
    private static final String URI_CALLRECORD_QUERY =  "/rest/developer/apiForBee/callRecords";

    private String serverUrl;
    private String developerKey;
    private String token;

    public PbxService2( String serverUrl, String developerKey, String token )
    {
        this.serverUrl = serverUrl;
        this.developerKey = developerKey;
        this.token = token;
    }

    private AuthArg getAuthArg()
    {
        AuthArg authArg = new AuthArg();

        authArg.developer_key = developerKey;
        
        if ( ! StringUtils.isBlank( token ) )
        {
            authArg.token = token;
        }

        return authArg;
    }

    private void processException( ServiceException se ) throws ServiceException
    {
        if ( se.getErrorType() == ServiceException.ERROR_STATUS )
        {
            int statusCode = se.getStatusCode();

            if ( 500 == statusCode 
                    || 501 == statusCode
                    || 512 == statusCode )
            {
                throw new ServiceException( ServiceException.ERROR_INVAL,
                        "invalid devloperKey or token" );
            }
        }

        throw se;
    }

    private void processBaseResult( BaseResult baseResult )
        throws ServiceException
    {
        if ( null == baseResult )
        {
            throw new ServiceException( ServiceException.ERROR_FORMAT, 
                    "not found valid json response." );
        }

        if ( 1 != baseResult.code )
        {
            ServiceException se = new ServiceException( ServiceException.ERROR_RESULT,
                    baseResult.status );

            se.setResultCode( baseResult.code );
            throw se;
        }
    }

    public DomainInfo getDomainInfoByDeveloperKey( String developerKey ) 
        throws ServiceException 
    {
        String url = serverUrl + URI_DOMAININFO_GET_BY_DEVELOPERKEY;
        Map<String, Object> params = new LinkedHashMap<String, Object>();

        params.put( "developer_key", developerKey );

        GetDomainInfoResult result = null;

        try
        {
            result = postParamObject( url, params, GetDomainInfoResult.class );
        }
        catch( ServiceException se )
        {
            processException( se );
        }

        processBaseResult( result );

        if ( null != result.domains && StringUtils.isNotBlank( result.domains.restapi ) )
        {
            int pos = result.domains.restapi.indexOf( "/api" );

            if ( -1 != pos )
            {
                result.domains.restapi = result.domains.restapi.substring( 0, pos );
            }
        }

        return result.domains;
    }

    public List<CallRecord> queryCallRecord( Integer siteId, Integer userId,
            long startTime, long endTime ) throws ServiceException
    {
        if ( null == siteId || 0 >= siteId )
        {
            throw new ServiceException( ServiceException.ERROR_INVAL, 
                    "siteId can not be empty." );
        }

        if ( null != userId && 0 >= userId )
        {
            throw new ServiceException( ServiceException.ERROR_INVAL, 
                    "userId can not be less than zero." );
        }

        if ( 0 >= startTime || 0 >= endTime || endTime <= startTime )
        {
            throw new ServiceException( ServiceException.ERROR_INVAL,
                    "invalid startTime or endTime" );
        }

        String url = serverUrl + URI_CALLRECORD_QUERY;
        Map<String, Object> params = new LinkedHashMap<String, Object>();

        params.put( "auth", getAuthArg() );
        params.put( "call_start_time", String.valueOf( startTime ) );
        params.put( "call_end_time", String.valueOf( endTime ) );
        params.put( "bee_siteid", siteId );

        if ( null == userId )
        {
            params.put( "query_type", "site" );
        }
        else
        {
            params.put( "query_type", "person" );
            params.put( "bee_userid", userId );
        }

        QueryCallRecordResult result = null;

        try
        {
            result = postJsonObject( url, params, QueryCallRecordResult.class );
        }
        catch( ServiceException e )
        {
            processException( e );
        }

        processBaseResult( result );

        return result.datas;
    }

    public List<CallRecord> queryCallRecordBySite( Integer siteId, 
            long startTime, long endTime ) throws ServiceException
    {
        return queryCallRecord( siteId, null, startTime, endTime );
    }
}
