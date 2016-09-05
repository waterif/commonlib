package com.quanshi.uclib.service;

import java.util.HashMap;
import java.util.Map;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

import com.quanshi.uclib.service.dataobject.AdvertisementResult;
import com.quanshi.uclib.service.dataobject.PbxOpenReturn;

public class AdvertisementService extends JsonService
{
	public static Logger log = LoggerFactory.getLogger( AdvertisementService.class );
	
	private static final String URI_ADVERTISEMENT_LOGINCHECK  = "/interface/site/ad/loginCheck";


	private String serverUrl = null;

	public AdvertisementService( String serverUrl )
	{
		super();
		this.serverUrl = serverUrl;
	}
	
	/**
	 * 登陆调用AD广告服务器
	 * @param userId
	 * @return
	 * @throws ServiceException
	 */
	public AdvertisementResult loginCheck( Integer userId) throws ServiceException{
	    String url = serverUrl + String.format( URI_ADVERTISEMENT_LOGINCHECK );
        log.info( "ADloginCheck request:" + url );
        Map<String, Object> params = new HashMap<String, Object>();
        params.put( "id", userId );
        return postJsonObject( url, params,AdvertisementResult.class );
	}

}