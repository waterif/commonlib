package com.quanshi.uclib.service;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

import com.quanshi.uclib.service.dataobject.UcAdminResponseObj;

public class UcAdminApiService extends JsonService
{
	public static Logger log = LoggerFactory.getLogger( UcAdminApiService.class );
	
	private static final String URI_ADMIN_TOKEN_CHECK  = "/api/site/administrator/token/check?token=%s";

	private String serverUrl = null;

	public UcAdminApiService( String serverUrl ){
		super();
		this.serverUrl = serverUrl;
	}
	
	/**
	 * 调用ucadmin校验token的对错
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	public UcAdminResponseObj tokenCheck( String token) throws ServiceException{
	    String url = serverUrl + String.format( URI_ADMIN_TOKEN_CHECK , token );
        log.info( "UcAdminTokenCheck request:" + url );
        return getObject( url, UcAdminResponseObj.class );
	}

}