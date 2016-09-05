package com.quanshi.uclib.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import com.quanshi.uclib.service.ServiceBase;
import com.quanshi.uclib.service.dataobject.CasAuthLookupInfo;

public class CasService extends JsonResultService
{
    private static Logger log = LoggerFactory.getLogger( CasService.class );

    private String casUrl = null;
    private final String PREFIX_PATH = "/cas/casapi";
    private final String AUTH_LOOKUP_PATH = PREFIX_PATH + "/auth/lookup";
    private final String AUTH_LOOKUPBYSITEID_PATH = PREFIX_PATH + "/auth/lookUpBySiteId";

    public CasService( String casUrl )
    {
        super( "code", "data" );
        this.casUrl = casUrl;
    }

    public CasAuthLookupInfo authLookup( String username, String password )
        throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put( "user_account", username );
        params.put( "password", password );

        List<CasAuthLookupInfo> listInfo = postParamArray( casUrl + AUTH_LOOKUP_PATH, params, CasAuthLookupInfo.class );
        if ( null != listInfo && listInfo.size() > 0 )
        {
            return listInfo.get( 0 );
        }

        return null;
    }

    public CasAuthLookupInfo siteLookup( int siteId ) throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put( "site_id", String.format("%d", siteId ) );

        List<CasAuthLookupInfo> listInfo = postParamArray( casUrl + AUTH_LOOKUPBYSITEID_PATH, params, CasAuthLookupInfo.class );
        if ( null != listInfo && listInfo.size() > 0 )
        {
            return listInfo.get( 0 );
        }

        return null;
    }
}
