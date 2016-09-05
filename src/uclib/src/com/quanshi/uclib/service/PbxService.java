package com.quanshi.uclib.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

import org.apache.commons.lang.StringUtils;

import com.quanshi.uclib.service.dataobject.PbxAccessAuth;
import com.quanshi.uclib.service.dataobject.PbxCheckOutSideExtArgs;
import com.quanshi.uclib.service.dataobject.PbxCheckOutSideExtReturn;
import com.quanshi.uclib.service.dataobject.PbxCloseArgs;
import com.quanshi.uclib.service.dataobject.PbxCloseReturn;
import com.quanshi.uclib.service.dataobject.PbxOpenArgs;
import com.quanshi.uclib.service.dataobject.PbxOpenReturn;
import com.quanshi.uclib.service.dataobject.PbxSiteOpenOrCloseArgs;
import com.quanshi.uclib.service.dataobject.PbxSiteOpenOrCloseReturn;
import com.quanshi.uclib.service.dataobject.PbxUserNames;
import com.quanshi.uclib.service.dataobject.PbxServiceReturn.PbxGetDomainInfoReturn;
import com.quanshi.uclib.util.MiscUtil;

public class PbxService extends JsonService
{
	public static Logger log = LoggerFactory.getLogger( UmsService.class );

	public static final int UC_PRODUCT_ID = 20;
	public static final int SUCCESS = 1;
	public static final int PBX_OPEN = 1;
	public static final int PBX_CLOSE = 0;
	
	public static final int PBX_RESULT_CODE_3 = 3;//分机号被占用
	public static final int PBX_RESULT_CODE_4 = 4;//分机号被振铃组占用了
	public static final int PBX_RESULT_CODE_5 = 5;//分机号不符合规则

	private static final String URI_PBX_OPEN = "/api/createUsersWithDeveloperKeyByJson"; // 自定义标签
	private static final String URI_PBX_CLOSE = "/api/closeUsersWithDeveloperKeyByJson"; // 自定义标签
	private static final String URI_SITE_OPEN_OR_CLOSE = "/api/handleSiteWithDeveloperKeyByJson";
    private static final String URI_GETDOMAININFO_BY_DEVELOPERKEY = "/api/GetDomainInfoByDeveloperKey";
    
    private static final String URI_CHECKOUT_SIDEEXT = "/rest/developer/apiForBee/checkOutsideExt";//查询分机号是否可用接口

	PbxAccessAuth Auth;
	String pbxServerUrl;
	String pbxDomainServerUrl;

	public PbxService( PbxAccessAuth auth, String serverUrl, String domainServerUrl ) throws Exception
	{
		super();

		if ( !MiscUtil.valString( auth.auth.token ) || !MiscUtil.valString( auth.auth.developerKey ) )
		{
			throw new Exception( "pbx init: invalid parameters" );
		}

		Auth = auth;
		pbxServerUrl = serverUrl;
		pbxDomainServerUrl = domainServerUrl;
	}

	public PbxOpenReturn open( PbxOpenArgs openArgs ) throws Exception
	{
		openArgs.auth = Auth.auth;
		PbxOpenReturn pbxOpenRst = null;

		Map<String, Object> params = generateOpenAccountParams( openArgs );

		try
		{
			String url = pbxServerUrl + String.format( URI_PBX_OPEN );
			pbxOpenRst = postJsonObject( url, params, PbxOpenReturn.class );
		}
		catch ( ServiceException se )
		{
			int status = se.getStatusCode();
			if ( status != 200 )
			{
				throw new Exception( "pbx server issue: httpCode=" + status );
			}
			else
			{
				throw se;
			}
		}

		if ( pbxOpenRst.code != 1 )
		{
			throw new Exception( "fail to Open pbx" );
		}

		return pbxOpenRst;

	}

	/**
	 * 关闭pbx
	 * 
	 * @param closeArgs.usernames必填
	 * 
	 * @return
	 * @throws Exception
	 */
	public PbxCloseReturn close( PbxCloseArgs closeArgs ) throws Exception
	{
		closeArgs.auth = Auth.auth;

		Map<String, Object> params = generatePbxCloseParams( closeArgs );

		String url = pbxServerUrl + String.format( URI_PBX_CLOSE );
		PbxCloseReturn pbxCloseRst = postJsonObject( url, params, PbxCloseReturn.class );

		if ( pbxCloseRst.code != 1 )
		{
			throw new Exception( "fail to close pbx" );
		}

		return pbxCloseRst;

	}

	public PbxSiteOpenOrCloseReturn siteOpenOrClose( PbxSiteOpenOrCloseArgs siteOpenOrCloseArgs ) throws Exception
	{
		siteOpenOrCloseArgs.auth = Auth.auth;

		Map<String, Object> params = generatePbxSiteOpenOrCloseParams( siteOpenOrCloseArgs );

		String url = pbxServerUrl + String.format( URI_SITE_OPEN_OR_CLOSE );
		PbxSiteOpenOrCloseReturn pbxSiteOpenOrCloseRst = postJsonObject( url, params, PbxSiteOpenOrCloseReturn.class );

		if ( SUCCESS != pbxSiteOpenOrCloseRst.code )
		{
			throw new Exception( "errorCode : " + pbxSiteOpenOrCloseRst.code + ";errorMessage : "
					+ pbxSiteOpenOrCloseRst.message );
		}

		return pbxSiteOpenOrCloseRst;

	}

	private Map<String, Object> generatePbxSiteOpenOrCloseParams( PbxSiteOpenOrCloseArgs siteOpenOrCloseArgs )
	{
		Map<String, Object> params = null;

		if ( null != siteOpenOrCloseArgs )
		{
			params = new HashMap<String, Object>();

			if ( null != siteOpenOrCloseArgs.auth )
			{
				Map<String, String> auth = generateAuthParams( siteOpenOrCloseArgs.auth );

				params.put( "auth", auth );
			}

			params.put( "outside_org_id", siteOpenOrCloseArgs.outsideOrgId );
			params.put( "name", siteOpenOrCloseArgs.name );
			params.put( "action", siteOpenOrCloseArgs.action );
		}

		return params;
	}

	private Map<String, String> generateAuthParams( PbxAccessAuth.Auth auth )
	{

		Map<String, String> authMap = new HashMap<String, String>();

		authMap.put( "developer_key", auth.developerKey );
		authMap.put( "token", auth.token );

		return authMap;
	}

	private Map<String, Object> generateOpenAccountParams( PbxOpenArgs openArgs )
	{
		Map<String, Object> params = null;

		if ( null != openArgs )
		{
			params = new HashMap<String, Object>();

			if ( null != openArgs.auth )
			{
				Map<String, String> auth = generateAuthParams( openArgs.auth );

				params.put( "auth", auth );
			}

			if ( null != openArgs.userOptions )
			{
				Map<String, String> userOptions = new HashMap<String, String>();

				if ( StringUtils.isNotEmpty( openArgs.userOptions.userFlag ) )
				{
					userOptions.put( "user_flag", openArgs.userOptions.userFlag );
				}

				userOptions.put( "easiio_pstn", openArgs.userOptions.easiioPstn );
				userOptions.put( "city_call", openArgs.userOptions.cityCall );
				userOptions.put( "national_call", openArgs.userOptions.nationalCall );
				userOptions.put( "international_call", openArgs.userOptions.internationalCall );

				params.put( "user_options", userOptions );
			}

			if ( null != openArgs.userNames && !openArgs.userNames.isEmpty() )
			{
				Map<String, String> pbxNameMap = null;

				List<Map<String, String>> pbxNameMapList = new ArrayList<Map<String, String>>();

				for ( PbxUserNames pbxName : openArgs.userNames )
				{
					pbxNameMap = new HashMap<String, String>();

					if ( StringUtils.isNotEmpty( pbxName.userName ) )
					{
						pbxNameMap.put( "username", pbxName.userName );
					}

					if ( StringUtils.isNotEmpty( pbxName.firstName ) )
					{
						pbxNameMap.put( "firstname", pbxName.firstName );
					}

					if ( StringUtils.isNotEmpty( pbxName.lastName ) )
					{
						pbxNameMap.put( "lastname", pbxName.lastName );
					}

					if ( StringUtils.isNotEmpty( pbxName.email ) )
					{
						pbxNameMap.put( "email", pbxName.email );
					}

					pbxNameMap.put( "outside_ext", pbxName.outsideExt );

					if ( StringUtils.isNotEmpty( pbxName.outsideOrgId ) )
					{
						pbxNameMap.put( "outside_org_id", pbxName.outsideOrgId );
					}

					pbxNameMapList.add( pbxNameMap );
				}

				params.put( "usernames", pbxNameMapList );
			}

		}
		return params;
	}

	private Map<String, Object> generatePbxCloseParams( PbxCloseArgs closeArgs )
	{
		Map<String, Object> params = null;

		if ( null != closeArgs )
		{
			params = new HashMap<String, Object>();

			if ( null != closeArgs.auth )
			{
				Map<String, String> auth = generateAuthParams( closeArgs.auth );

				params.put( "auth", auth );
			}

			if ( null != closeArgs.userNames && !closeArgs.userNames.isEmpty() )
			{
				params.put( "usernames", closeArgs.userNames );
			}
		}

		return params;
	}

    public PbxGetDomainInfoReturn getDomainInfoByDeveloperKey( String developerKey ) throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();

        params.put( "developer_key", developerKey );

        PbxGetDomainInfoReturn res = postParamObject( pbxDomainServerUrl + URI_GETDOMAININFO_BY_DEVELOPERKEY, 
                params, PbxGetDomainInfoReturn.class );

        if ( null == res || 1 != res.code )
        {
            throw new Exception( "fail to get domainInfo by developer key: " + developerKey );
        }
        
		if ( null != res.domains && StringUtils.isNotBlank( res.domains.restapi ) )
		{
			if ( res.domains.restapi.contains( "/api" ) )
			{
				res.domains.restapi = res.domains.restapi.substring( 0, res.domains.restapi.indexOf( "/api" ) );
			}
			else
			{
				res.domains.restapi = res.domains.restapi;
			}
		}
        
        return res;
    }
    
    /**
     * 查询分机号是否可用接口
     * @param checkSideExtArgs
     * @return
     * @throws Exception
     */
    public PbxCheckOutSideExtReturn checkOutSideExt( PbxCheckOutSideExtArgs checkSideExtArgs ) throws Exception
    {
        checkSideExtArgs.auth = Auth.auth;
        Map<String, Object> params = null;
        if ( null != checkSideExtArgs )
        {
            params = new HashMap<String, Object>();
            if ( null != checkSideExtArgs.auth )
            {
                Map<String, String> auth = generateAuthParams( checkSideExtArgs.auth );
                params.put( "auth", auth );
            }
            if ( null != checkSideExtArgs.bee_siteid )
            {
                params.put( "bee_siteid", checkSideExtArgs.bee_siteid );
            }
            if ( null != checkSideExtArgs.outside_ext )
            {
                params.put( "outside_ext", checkSideExtArgs.outside_ext );
            }
        }
        String url = pbxServerUrl + String.format( URI_CHECKOUT_SIDEEXT );
        return postJsonObject( url, params, PbxCheckOutSideExtReturn.class );
    }
    
}
