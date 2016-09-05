package com.quanshi.uclib.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

import name.rex.commlib.format.JSONHelper;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.quanshi.uclib.service.dataobject.YunPanEntInfoRes;
import com.quanshi.uclib.service.dataobject.YunPanEntTokenRes;
import com.quanshi.uclib.service.dataobject.YunPanInfo;
import com.quanshi.uclib.service.dataobject.YunPanMemberInfo;
import com.quanshi.uclib.service.dataobject.YunPanRes;
import com.quanshi.uclib.util.HmacSha;
import com.quanshi.uclib.util.MiscUtil;

public class YunPanService extends JsonService
{
	public static Logger log = LoggerFactory.getLogger( YunPanService.class );

	public static final String YUNPAN_ERROR_CODE_SUCCESS = "0"; // 成功

	public static final String YUNPAN_ERROR_CODE_EXIST = "40098"; // 云盘已经开通

	public static final int YUNPAN_TYPE_CLOSE = 0; // 云盘退订
	
	public static final int YUNPAN_TYPE_CREATE = 1; // 云盘开通，这里开通的是试用版，三个月过期

	public static final int YUNPAN_TYPE_SUBSCRIBE = 2;// 云盘购买

	public static final int YUNPAN_TYPE_UPGRADE = 3; // 云盘升级/扩容

	public static final int YUNPAN_TYPE_RENEW = 4;// 云盘续费

	public static final String YUNPAN_API_UNSUBSCRIBE = "unsubscribe";
	
	public static final String YUNPAN_API_RENEW = "renew";

	public static final String YUNPAN_API_UPGRADE = "upgrade";

	public static final String YUNPAN_API_SUBSCRIBE = "subscribe";

	public static final String YUNPAN_DEFAULT_VALUE_MONTH = "12";

	public static final String YUNPAN_DEFAULT_VALUE_SPACE = "1024";

	public static final String YUNPAN_DEFAULT_VALUE_MEMBERCOUNT = "-1";

	private static final String URI_YUNPAN_CREATE = "/1/thirdparty/create_ent";

	private static final String URI_YUNPAN_ORDER = "/1/thirdparty/order";
	
	private static final String URI_ENT_INFO = "/1/thirdparty/ent_info";
	
	private static final String URI_GET_TOKEN = "/1/thirdparty/get_token";
	
	private static final String URI_ADD_SYNC_MEMBER = "/1/ent/add_sync_member";
	
	private static final String URI_DEL_SYNC_MEMBER = "/1/ent/del_sync_member";
	
	private static final String URI_ADD_SYNC_GROUP_MEMBER = "/1/ent/add_sync_group_member";

	private String clientId = null;

	private String clientSecret = null;

	private String serverUrl = null;
	
	private String entUrl = null;

	public YunPanService( String serverUrl, String entUrl, String clientId, String clientSecret )
	{
		super();
		this.serverUrl = serverUrl;
		this.entUrl = entUrl;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}
	
	private Map<String, String> generateCreateEntParams( YunPanInfo yunPanInfo )
			throws UnsupportedEncodingException, Exception
	{
		Map<String, String> params = new TreeMap<String, String>();
		
		params.put( "__setting_site_url", yunPanInfo.siteUrl );
		params.put( "client_id", clientId );
		params.put( "contact_address", null == yunPanInfo.contactAddress ? "" : yunPanInfo.contactAddress );
		params.put( "contact_email", null == yunPanInfo.contactEmail ? "" : yunPanInfo.contactEmail );
		params.put( "contact_mobile", null == yunPanInfo.contacMobile ? "" : yunPanInfo.contacMobile );
		params.put( "contact_name", null == yunPanInfo.contactName ? "" : yunPanInfo.contactName );
		params.put( "dateline", String.valueOf( yunPanInfo.dateline ) );
		params.put( "ent_name", null == yunPanInfo.entName ? "" : yunPanInfo.entName );
		params.put( "out_id", yunPanInfo.outId );
		params.put( "sign", generateSign( params ) );
		
		return params;
	}

	private String generateSign( Map<String, String> params ) throws UnsupportedEncodingException, Exception
	{
		String sign = params.values().toString().replace( "[", "" ).replace( "]", "" ).replaceAll( ", ", "\n" );
		return URLEncoder.encode( MiscUtil.base64Encode( HmacSha.hmacSHA1Encrypt( sign, clientSecret ) ), "UTF-8" );
	}

	/**
	 * 查询企业云盘信息
	 * @param outId 企业id
	 * @return 站点云盘信息
	 * @throws Exception 未知异常
	 */
	public YunPanEntInfoRes getEntInfo( int outId ) throws Exception
	{
		String url = serverUrl + String.format( URI_ENT_INFO );

		Map<String, String> params = new TreeMap<String, String>();
		
        params.put( "client_id", clientId );
        params.put( "out_id", String.valueOf( outId ) );
        params.put( "dateline", String.valueOf( new Date().getTime() ) );
        params.put( "sign", generateSign( params ) );
        
		log.info( String.format( "getEntInfo:%s", params.toString() ) );

		try
		{
			return postParamObject( url, params, YunPanEntInfoRes.class );
		}
		catch ( ServiceException e )
		{
			if ( StringUtils.isNotEmpty( e.getContent() ) && e.getMessage().contains( "40" ) )
			{
				return null;
			}
			
			throw e;
		}
	}
	
	/**
	 * 获取企业token
	 * 
	 * @param outId 企业id
	 * @return 企业token
	 * @throws Exception 未知异常
	 */
	public YunPanEntTokenRes getEntToken( int outId ) throws Exception
	{
	    String url = serverUrl + String.format( URI_GET_TOKEN );
	    
	    Map<String, String> params = new TreeMap<String, String>();
	    
	    params.put( "client_id", clientId );
	    params.put( "out_id", String.valueOf( outId ) );
	    params.put( "dateline", String.valueOf( new Date().getTime() ) );
	    params.put( "sign", generateSign( params ) );
	    
	    log.info( String.format( "getEntToken:%s", params.toString() ) );
	    
	    try
	    {
	        return postParamObject( url, params, YunPanEntTokenRes.class );
	    }
	    catch ( ServiceException e )
	    {
	        if ( StringUtils.isNotEmpty( e.getContent() ) && e.getMessage().contains( "40" ) )
	        {
	            return null;
	        }
	        
	        throw e;
	    }
	}
	
	/**
	 * 添加或修改同步成员
	 * @param member 账号信息
	 * @param token 企业token
	 * @return
	 * @throws Exception
	 */
	public YunPanRes addGroupMember( YunPanMemberInfo member, String token ) throws Exception
	{
	    String url = entUrl + String.format( URI_ADD_SYNC_GROUP_MEMBER );
	    
	    Map<String, String> params = new TreeMap<String, String>();
	    
	    params.put( "token", token );
	    params.put( "token_type", "ent" );
	    params.put( "members", String.valueOf( member.id ) );
	    params.put( "sign", generateSign( params ) );
	    
	    log.info( String.format( "addGroupMember:%s", params.toString() ) );
	    
	    try
        {
            return parseYunPanRes( postParamJson( url, params ) );
        }
        catch ( ServiceException e )
        {
            if ( StringUtils.isNotEmpty( e.getContent() ) )
            {
                return parseYunPanRes( JSONHelper.parseObject( e.getContent() ) );
            }
            throw e;
        }
	}
	
	/**
	 * 添加或修改同步成员
	 * @param member 账号信息
	 * @param token 企业token
	 * @return
	 * @throws Exception
	 */
	public YunPanRes addMember( YunPanMemberInfo member, String token ) throws Exception
	{
	    String url = entUrl + String.format( URI_ADD_SYNC_MEMBER );
	    
	    Map<String, String> params = new TreeMap<String, String>();
	    
	    params.put( "token", token );
	    params.put( "token_type", "ent" );
	    params.put( "out_id", String.valueOf( member.id ) );
	    params.put( "member_name", member.memberName );
	    params.put( "account", member.account );
	    params.put( "sign", generateSign( params ) );
	    
	    log.info( String.format( "addMember:%s", params.toString() ) );
	    
	    try
	    {
	        return parseYunPanRes( postParamJson( url, params ) );
	    }
	    catch ( ServiceException e )
	    {
	        if ( StringUtils.isNotEmpty( e.getContent() ) )
	        {
	            return parseYunPanRes( JSONHelper.parseObject( e.getContent() ) );
	        }
	        throw e;
	    }
	}
	
    /**
     * 删除同步成员
     * 
     * @param userIds 用户id列表
     * @param token 企业token
     * @return
     * @throws Exception 未知异常
     */
    public YunPanRes delMember( List<Integer> userIds, String token ) throws Exception
    {
        if ( null == userIds || userIds.isEmpty() )
        {
            return null;
        }

        String members = userIds.toString().replace( "[", "" ).replace( "]", "" ).replaceAll( " ", "" );

        String url = entUrl + String.format( URI_DEL_SYNC_MEMBER );

        Map<String, String> params = new TreeMap<String, String>();

        params.put( "token", token );
        params.put( "token_type", "ent" );
        params.put( "members", members );
        params.put( "sign", generateSign( params ) );

        log.info( String.format( "delMember:%s", params.toString() ) );

        try
        {
            return parseYunPanRes( postParamJson( url, params ) );
        }
        catch ( ServiceException e )
        {
            if ( StringUtils.isNotEmpty( e.getContent() ) )
            {
                return parseYunPanRes( JSONHelper.parseObject( e.getContent() ) );
            }
            throw e;
        }
    }
	
	/**
	 * 开通试用版
	 * 
	 * @param yunPanInfo 云盘信息
	 * @return 开通结果
	 * @throws UnsupportedEncodingException 编码不支持
	 * @throws Exception 未知异常
	 */
	public YunPanRes createEnt( YunPanInfo yunPanInfo ) throws UnsupportedEncodingException, Exception
	{
	    String url = serverUrl + String.format( URI_YUNPAN_CREATE );
	    
	    Map<String, String> params = generateCreateEntParams( yunPanInfo );
	    
	    log.info( String.format( "createEnt:%s", params.toString() ) );
	    
	    try
	    {
	        return parseYunPanRes( postParamJson( url, params ) );
	    }
	    catch ( ServiceException e )
	    {
	        if ( StringUtils.isNotEmpty( e.getContent() ) && e.getMessage().contains( "400" ) )
	        {
	            return parseYunPanRes( JSONHelper.parseObject( e.getContent() ) );
	        }
	        throw e;
	    }
	}

	/**
	 * 正式开通
	 * 
	 * @param yunPanInfo 云盘信息
	 * @return 开通结果
	 * @throws UnsupportedEncodingException 编码不支持
	 * @throws Exception 未知异常
	 */
	public YunPanRes orderSubscribe( YunPanInfo yunPanInfo ) throws UnsupportedEncodingException, Exception
	{
		String url = serverUrl + String.format( URI_YUNPAN_ORDER );

		Map<String, String> params = new TreeMap<String, String>();
		params.put( "client_id", clientId );
		params.put( "dateline", String.valueOf( yunPanInfo.dateline ) );
		params.put( "member_count", null == yunPanInfo.memberCount ? YUNPAN_DEFAULT_VALUE_MEMBERCOUNT
				: String.valueOf( yunPanInfo.memberCount ) );
		params.put( "month",
				null == yunPanInfo.month ? YUNPAN_DEFAULT_VALUE_MONTH : String.valueOf( yunPanInfo.month ) );
		params.put( "out_id", yunPanInfo.outId );
		params.put( "space",
				null == yunPanInfo.space ? YUNPAN_DEFAULT_VALUE_SPACE : String.valueOf( yunPanInfo.space ) );
		params.put( "type", YUNPAN_API_SUBSCRIBE );
		params.put( "sign", generateSign( params ) );
		
		log.info( String.format( "orderSubscribe:%s", params.toString() ) );
		
		return parseYunPanRes( postParamJson( url, params ) );
	}

	/**
	 * 升级扩容
	 * 
	 * @param yunPanInfo 云盘信息
	 * @return 升级扩容结果
	 * @throws UnsupportedEncodingException 编码不支持
	 * @throws Exception 未知异常
	 */
	public YunPanRes orderUpgrade( YunPanInfo yunPanInfo ) throws UnsupportedEncodingException, Exception
	{
		String url = serverUrl + String.format( URI_YUNPAN_ORDER );

		Map<String, String> params = new TreeMap<String, String>();
		params.put( "client_id", clientId );
		params.put( "dateline", String.valueOf( yunPanInfo.dateline ) );
		params.put( "member_count", null == yunPanInfo.memberCount ? YUNPAN_DEFAULT_VALUE_MEMBERCOUNT
				: String.valueOf( yunPanInfo.memberCount ) );
		params.put( "out_id", yunPanInfo.outId );
		params.put( "space",
				null == yunPanInfo.space ? YUNPAN_DEFAULT_VALUE_SPACE : String.valueOf( yunPanInfo.space ) );
		params.put( "type", YUNPAN_API_UPGRADE );
		params.put( "sign", generateSign( params ) );
		
		log.info( String.format( "orderUpgrade:%s", params.toString() ) );
		
		return parseYunPanRes( postParamJson( url, params ) );
	}

	/**
	 * 续费
	 * 
	 * @param yunPanInfo 云盘信息
	 * @return 续费结果
	 * @throws UnsupportedEncodingException 编码不支持
	 * @throws Exception 未知异常
	 */
	public YunPanRes orderRenew( YunPanInfo yunPanInfo ) throws UnsupportedEncodingException, Exception
	{
		String url = serverUrl + String.format( URI_YUNPAN_ORDER );

		Map<String, String> params = new TreeMap<String, String>();
		params.put( "client_id", clientId );
		params.put( "dateline", String.valueOf( yunPanInfo.dateline ) );
		params.put( "month",
				null == yunPanInfo.month ? YUNPAN_DEFAULT_VALUE_MONTH : String.valueOf( yunPanInfo.month ) );
		params.put( "out_id", yunPanInfo.outId );
		params.put( "type", YUNPAN_API_RENEW );
		params.put( "sign", generateSign( params ) );
		
		log.info( String.format( "orderRenew:%s", params.toString() ) );
		
		return parseYunPanRes( postParamJson( url, params ) );
	}
	
	/**
	 * 退订
	 * 
	 * @param yunPanInfo 云盘信息
	 * @return 退订结果
	 * @throws UnsupportedEncodingException 编码不支持
	 * @throws Exception 未知异常
	 */
	public YunPanRes unsubscribe( YunPanInfo yunPanInfo ) throws UnsupportedEncodingException, Exception
	{
	    String url = serverUrl + String.format( URI_YUNPAN_ORDER );
	    
	    Map<String, String> params = new TreeMap<String, String>();
	    params.put( "client_id", clientId );
	    params.put( "dateline", String.valueOf( yunPanInfo.dateline ) );
	    params.put( "out_id", yunPanInfo.outId );
	    params.put( "type", YUNPAN_API_UNSUBSCRIBE );
	    params.put( "sign", generateSign( params ) );
	    
	    log.info( String.format( "unsubscribe:%s", params.toString() ) );
	    
        try
        {
            return parseYunPanRes( postParamJson( url, params ) );
        }
        catch ( ServiceException e )
        {
            if ( StringUtils.isNotEmpty( e.getContent() ) )
            {
                return parseYunPanRes( JSONHelper.parseObject( e.getContent() ) );
            }
            throw e;
        }
	}

	public YunPanRes parseYunPanRes( JSONObject jsonRes )
	{
		if (null == jsonRes)
		{
			return null;
		}
		
		YunPanRes res = new YunPanRes();
		
		res.errorCode = jsonRes.getString( "error_code" );
		res.errorMsg = jsonRes.getString( "error_msg" );
		
		return res;
	}
}