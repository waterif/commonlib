package com.quanshi.uclib.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

public class ExtapiService extends JsonResultService
{
    public static class TicketInfo
    {
        public Integer  appId;
	    public String   ticket;
	    public String   expires;
    }

    /////////////////////////////////////////////////////////////////////////////////
    public static Logger log = LoggerFactory.getLogger( UmsService.class );
    private static String serverUrl = null;
	private static final String URI_PREFIX = "/extapi";
	private static final String URI_GET_TICKET = URI_PREFIX + "/ticket/getticket";

    public ExtapiService( String serverUrl )
    {
        super( "code", "data" );
        this.serverUrl = serverUrl;
    }

	public TicketInfo getTicket( Long siteId, Long appId, String build ) throws Exception
	{
        Map<String, Object> data = new HashMap<String, Object>();

        data.put( "siteId", siteId );
        data.put( "appId", appId );
        
        if ( null != build )
        {
            data.put( "build", build );
        }

		Map<String, Object> param = new HashMap<String, Object>();
		param.put( "data", data );
		
		return postJsonObject( serverUrl + URI_GET_TICKET, param, TicketInfo.class );
	}
}
