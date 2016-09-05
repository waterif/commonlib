package com.quanshi.uclib.service;

import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import com.alibaba.fastjson.JSONObject;

import name.rex.commlib.format.JSONHelper;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import name.rex.commlib.net.HttpWrapper;
import name.rex.commlib.net.HttpWrapperRes;

import com.quanshi.uclib.dataobject.ClientTypeEnum;
import com.quanshi.uclib.service.dataobject.UccBatchLogoutResult;
import com.quanshi.uclib.service.dataobject.UccServerLoginClientInfo;
import com.quanshi.uclib.service.dataobject.UccServerLoginInfo;
import com.quanshi.uclib.service.dataobject.UccServerUserInfo;
import com.quanshi.uclib.service.dataobject.UccUpdateUserInfoRes;
import com.quanshi.uclib.service.dataobject.UccUserInfo;
import com.quanshi.uclib.service.dataobject.UccUserTag;
import com.quanshi.uclib.service.dataobject.UccUserTagList;
import com.quanshi.uclib.service.dataobject.UmsTokenInfo;
import com.quanshi.uclib.service.dataobject.UccServerUserCheckInfo;
import com.quanshi.uclib.service.dataobject.UccServerMessageDeliverItemResult;
import com.quanshi.uclib.service.dataobject.UccServerMessageDeliverResult;
import com.quanshi.uclib.service.dataobject.UccServerMessageBroadcastItemResult;
import com.quanshi.uclib.service.dataobject.UccServerMessageBroadcastResult;
import com.quanshi.uclib.service.dataobject.UccServerOAStatusChangeInfo;
import com.quanshi.uclib.service.dataobject.UccServerOAStatusChangeResult;
import com.quanshi.uclib.service.dataobject.UccRes;
import com.quanshi.uclib.service.dataobject.UccServerGroupCreateInfo;
import com.quanshi.uclib.service.dataobject.UccServerGroupCreateResult;

public class UccServerService extends JsonResultService
{
    private static Logger            log                               = LoggerFactory
            .getLogger( UccServerService.class );

    private String                   serverUrl                         = null;
    private UccServerLoginClientInfo clientInfo;

    private static final String      URI_PREFIX                        = "/uccserver/uccapi";
    private static final String      USER_LOGIN_PATH                   = URI_PREFIX + "/user/login";
    private static final String      USER_LOGOUT_PATH                  = URI_PREFIX + "/user/logout";
    private static final String      USER_ACCESS_TOKEN                 = URI_PREFIX + "/user/authorize";
    private static final String      USER_REFRESH_TOKEN                = URI_PREFIX + "/user/token";
    private static final String      USER_REFRESH_TAG                  = URI_PREFIX + "/user/tagUpdate";
    private static final String      USER_UPDATE                       = URI_PREFIX + "/user/update";
    private static final String      USER_BATCH_LOGOUT                 = URI_PREFIX + "/user/accountlogout";

    private static final String      SEND_MOBILE_MESSAGE               = URI_PREFIX + "/async/sendMobileMsg";
    private static final String      USER_INFOBYNAME_PATH              = URI_PREFIX + "/user/infobyname";
    private static final String      USER_CHECK_PATH                   = URI_PREFIX + "/user/check";
    private static final String      MESSAGE_DELIVER_PATH              = URI_PREFIX + "/message/deliver";
    private static final String      MESSAGE_BROADCAST_PATH            = URI_PREFIX + "/message/broadcast";
    private static final String      MESSAGE_OASTATUSCHANGEBYGUID_PATH = URI_PREFIX + "/message/oastatuschangebyguid";
    private static final String      MESSAGE_NOTIFY					   = URI_PREFIX + "/message/notify";
    private static final String      GROUP_CREATE_PATH                 = URI_PREFIX + "/group/create";
    private static final String      GROUP_QUIT_PATH                   = URI_PREFIX + "/group/quit";
    private static final String      GROUP_MEMBER_CLEAN                = URI_PREFIX + "/group/memberClean";
    private static final String      GROUP_STATUS_UPDATE               = URI_PREFIX + "/group/statusUpdate";
    
    public static final int GROUP_MEMBER_CLEAN_CLOSE = 0;
    public static final int GROUP_MEMBER_CLEAN_RECOVERY = 1;

    public UccServerService(String serverUrl)
    {
        super( "code", "data" );

        this.serverUrl = serverUrl;

        clientInfo = new UccServerLoginClientInfo();
        clientInfo.mac = "08-9E-01-11-92-C6";
    }

    public UccServerLoginInfo userLogin( String username, String password, UccServerLoginClientInfo clientInfo,
            Integer clientType ) throws ServiceException
    {
        Map<String, Object> params = new HashMap<String, Object>();

        params.put( "user_account", username );
        params.put( "password", password );
        params.put( "client_type", String.format( "%d", (null != clientType) ? clientType : ClientTypeEnum.BACKEND ) );
        params.put( "client_info", JSONHelper.toJSONString( (null != clientInfo) ? clientInfo : this.clientInfo ) );

        List<UccServerLoginInfo> listInfo = postParamArray( serverUrl + USER_LOGIN_PATH, params,
                UccServerLoginInfo.class );

        if ( null == listInfo || 0 >= listInfo.size() )
        {
            return null;
        }

        return listInfo.get( 0 );
    }
    
	public UccUpdateUserInfoRes updateUser( UccUserInfo userInfo ) throws Exception
	{
		Map<String, String> params = new HashMap<String, String>();

		params.put( "user_id", String.valueOf( userInfo.userId ) );
		params.put( "session_id", userInfo.sessionId );
		params.put( "email", userInfo.email );

		Map<String, String> data = new HashMap<String, String>();

		if ( null != userInfo.loginName )
		{
			data.put( "login_name", userInfo.loginName );
		}

		if ( null != userInfo.mobile )
		{
			data.put( "mobile", userInfo.mobile );
		}

		if ( null != userInfo.displayName )
		{
			data.put( "display_name", userInfo.displayName );
		}

		if ( null != userInfo.firstName )
		{
			data.put( "first_name", userInfo.firstName );
		}

		if ( null != userInfo.middleName )
		{
			data.put( "middle_name", userInfo.middleName );
		}

		if ( null != userInfo.lastName )
		{
			data.put( "last_name", userInfo.lastName );
		}

		if ( null != userInfo.pinyin )
		{
			data.put( "name_pinyin", userInfo.pinyin );
		}

		if ( null != userInfo.position )
		{
			data.put( "position", userInfo.position );
		}

		if ( null != userInfo.sex )
		{
			data.put( "sex", String.valueOf( userInfo.sex ) );
		}

		if ( null != userInfo.avatar )
		{
			data.put( "avatar", userInfo.avatar );
		}

		if ( null != userInfo.userForgetFlag )
		{
			data.put( "user_forget_flag", userInfo.userForgetFlag );
		}

		if ( null != userInfo.personalSign )
		{
			data.put( "personal_sign", userInfo.personalSign );
		}

		if ( null != userInfo.fixTel )
		{
			data.put( "fix_tel", userInfo.fixTel );
		}

		params.put( "data", data.toString() );

		UccUpdateUserInfoRes res = postParamObject( serverUrl + USER_UPDATE, params, UccUpdateUserInfoRes.class );

		return res;
	}

    public String getUserAccessToken( String account, String password, int siteId ) throws ServiceException
    {
        class retdata
        {
            public String access_token;
            public String token_type;
            public String refresh_token;
            public String expires_in;
            public String scope;
        }

        Map<String, String> params = new HashMap<String, String>();
        
        params.put( "user_account", account );
        params.put( "password", password );
        params.put( "site_id", siteId + "" );
        params.put( "grant_type", "password" );
        
        List<retdata> acsList = postParamArray( serverUrl + USER_ACCESS_TOKEN, params, retdata.class );

        log.debug( "debug2" );
        if ( null == acsList )
        {
            log.debug( "debug3" );
        }
        
        if ( acsList.size() > 0 )
        {
            log.debug( "debug1" );
            return acsList.get( 0 ).access_token;
        }

        return null;
    }

    public UmsTokenInfo getUmsTokenInfo( String account, String password, int siteId ) throws Exception
    {
        log.debug( "get ums token info." );

        Map<String, String> params = new HashMap<String, String>();
        params.put( "user_account", account );
        params.put( "password", password );
        params.put( "site_id", siteId + "" );
        params.put( "grant_type", "password" );
        List<UmsTokenInfo> acsList = postParamArray( serverUrl + USER_ACCESS_TOKEN, params, UmsTokenInfo.class );

        if ( acsList.size() == 0 )
        {
            throw new Exception( "get ums token info from ucc failed." );
        }

        return acsList.get( 0 );
    }

    public UmsTokenInfo refreshUmsToken( String refreshToken, String grant_type ) throws Exception
    {
        log.debug( "refresh ums token." );

        Map<String, String> params = new HashMap<String, String>();
        params.put( "refresh_token", refreshToken );

        if ( null == grant_type )
        {
            params.put( "grant_type", "refresh_token" );
        }
        else
        {
            params.put( "grant_type", grant_type );
        }

        List<UmsTokenInfo> acsList = postParamArray( serverUrl + USER_REFRESH_TOKEN, params, UmsTokenInfo.class );

        if ( acsList.size() == 0 )
        {
            throw new Exception( "refresh ums token failed." );
        }

        return acsList.get( 0 );
    }

    public void userLogout( long user_id, String session_id ) throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        params.put( "user_id", String.format( "%d", user_id ) );
        params.put( "session_id", session_id );

        postParam( serverUrl + USER_LOGOUT_PATH, params );
    }

	public UccRes updateTags( UccUserTagList userTags ) throws Exception
	{

		Map<String, String> params = new HashMap<String, String>();
		params.put( "user_id", String.valueOf( userTags.userId ) );
		params.put( "session_id", String.valueOf( userTags.siteId ) );

		if ( null != userTags.uccUserTags && !userTags.uccUserTags.isEmpty() )
		{
			List<Map<String, String>> userTagMaps = new ArrayList<Map<String, String>>();
			Map<String, String> userTagMap = null;

			for ( UccUserTag uccUserTag : userTags.uccUserTags )
			{
				userTagMap = new HashMap<String, String>();

				userTagMap.put( "tag_id", String.valueOf( uccUserTag.tagId ) );
				userTagMap.put( "tag_name", uccUserTag.tagName );
				userTagMap.put( "tag_value", uccUserTag.tagValue );

				userTagMaps.add( userTagMap );
			}

			params.put( "data", userTagMaps.toString() );
		}

		String url = serverUrl + USER_REFRESH_TAG;
		UccRes res = postParamObject( url, params, UccRes.class );

		return res;
	}
	
	public List<UccBatchLogoutResult> batchUserLogout( List<Integer> userIds ) throws Exception
	{
		if ( null == userIds || userIds.isEmpty() )
		{
			return null;
		}

		Map<String, String> params = new HashMap<String, String>();

		params.put( "data", userIds.toString() );

		String url = serverUrl + USER_BATCH_LOGOUT;

		return postParamArray( url, params, UccBatchLogoutResult.class );
	}
	
	public List<UccBatchLogoutResult> logoutBySite( Integer siteId ) throws Exception
	{
		if ( null == siteId )
		{
			return null;
		}
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put( "site_id", String.valueOf( siteId ) );
		
		String url = serverUrl + USER_BATCH_LOGOUT;
		
		return postParamArray( url, params, UccBatchLogoutResult.class );
	}
	
	public void notyfy( Integer siteId, Integer userId, Integer type ) throws Exception
	{
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put( "to_user_id", String.valueOf( userId ) );
		params.put( "site_id", String.valueOf( siteId ) );
		params.put( "type", String.valueOf( type ) );
		
		String url = serverUrl + MESSAGE_NOTIFY;
		
		postParamJson( url, params );
	}

    /**
     * 短信发送失败（http请求失败，或者uccserver的返回code非0 ）抛出异常
     *
     * @param user_id
     * @param mobile
     * @param message
     */
    public void sendMobileMsg( long user_id, String mobile, String message ) throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        params.put( "user_id", String.format( "%d", user_id ) );

        if ( StringUtils.isBlank( message ) || StringUtils.isBlank( mobile ) )
        {
            throw new Exception( "mobile or message content is bland!" );
        }

        params.put( "content", message );
        params.put( "mobile", mobile );

		log.info( String.format( "send mobile msg[%s] to UccServer[%s]", serverUrl + SEND_MOBILE_MESSAGE,
				params.toString() ) );
		
        postParam( serverUrl + SEND_MOBILE_MESSAGE, params );
    }

    public UccServerUserInfo userInfoByName( String account ) throws Exception
    {
        List<String> listUser = new ArrayList<String>();
        listUser.add( account );

        List<UccServerUserInfo> listInfo = userInfoByName( listUser );

        if ( null == listInfo || 0 >= listInfo.size() )
        {
            return null;
        }

        return listInfo.get( 0 );
    }

    public List<UccServerUserInfo> userInfoByName( List<String> listUser ) throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();

        params.put( "data", JSONHelper.toJSONString( listUser ) );

        return postParamArray( serverUrl + USER_INFOBYNAME_PATH, params, UccServerUserInfo.class );
    }

    public UccServerUserCheckInfo userCheck( long userId, String sessionId ) throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();

        params.put( "user_id", String.format( "%d", userId ) );
        params.put( "session_id", sessionId );

        return postParamObject( serverUrl + USER_CHECK_PATH, params,
                UccServerUserCheckInfo.class );
    }

    public UccServerMessageDeliverResult messageDeliver( int nosendself, byte arrData[] ) throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();

        params.put( "nosendself", String.format( "%d", nosendself ) );

        String url = serverUrl + MESSAGE_DELIVER_PATH;
        url = HttpWrapper.buildURL( url, params );
        HttpWrapperRes res = HttpWrapper.postData( url, arrData, "application/octet-stream", null, false );
        JSONObject responseJSON = parseResponseResult( res );

        UccServerMessageDeliverResult result = new UccServerMessageDeliverResult();

        result.success_data = JSONHelper.getObjectList( responseJSON, "success_data",
                UccServerMessageDeliverItemResult.class );
        result.failed_data = JSONHelper.getObjectList( responseJSON, "failed_data",
                UccServerMessageDeliverItemResult.class );

        return result;
    }

    class BroadcastRange
    {
        public int           siteid;
        public List<Integer> orgid;
        public List<Integer> userid;
    }

    /**
     * 广播消息不支持状态改变; 广播消息一次全部成功、一次全部失败 (不区分单个userId、partId的发送结果)
     * 
     * @param siteId
     * @param orgIds
     * @param userIds
     * @param arrData
     * @return
     * @throws UCResultException
     */
    public UccServerMessageBroadcastResult messageBroadcast( int siteId, List<Integer> orgIds, List<Integer> userIds,
            byte arrData[] ) throws Exception
    {
        BroadcastRange range = new BroadcastRange();
        range.siteid = siteId;
        range.orgid = orgIds;
        range.userid = userIds;

        Map<String, String> params = new HashMap<String, String>();

        params.put( "type", "openapi" );
        params.put( "range", JSONHelper.toJSONString( range ) );

        String url = serverUrl + MESSAGE_BROADCAST_PATH;
        url = HttpWrapper.buildURL( url, params );
        HttpWrapperRes res = HttpWrapper.postData( url, arrData, "application/octet-stream", null, false );
        JSONObject responseJSON = parseResponseResult( res );

        UccServerMessageBroadcastResult result = new UccServerMessageBroadcastResult();

        result.success_data = JSONHelper.getObjectList( responseJSON, "success_data",
                UccServerMessageBroadcastItemResult.class );
        result.failed_data = JSONHelper.getObjectList( responseJSON, "failed_data",
                UccServerMessageBroadcastItemResult.class );

        return result;
    }

    public List<UccServerOAStatusChangeResult> oaStatusChangeByGuid( 
            List<UccServerOAStatusChangeInfo> listStatusInfo )
        throws ServiceException
    {
        Map<String, String> params = new HashMap<String, String>();
        params.put( "data", JSONHelper.toJSONString( listStatusInfo ) );

        List<UccServerOAStatusChangeResult> listInfo = postParamArray( serverUrl + MESSAGE_OASTATUSCHANGEBYGUID_PATH,
                params, UccServerOAStatusChangeResult.class );

        return listInfo;
    }

    public UccServerOAStatusChangeResult oaStatusChangeByGuid( 
            UccServerOAStatusChangeInfo statusInfo )
            throws ServiceException
    {
        List<UccServerOAStatusChangeInfo> listInfo = new ArrayList<UccServerOAStatusChangeInfo>();

        listInfo.add( statusInfo );

        List<UccServerOAStatusChangeResult> listResult = oaStatusChangeByGuid( listInfo );

        if( null != listResult && 0 < listResult.size() )
        {
            return listResult.get( 0 );
        }

        return null;
    }

    public UccServerGroupCreateResult groupCreate( UccServerGroupCreateInfo groupInfo ) throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        params.put( "group_name", groupInfo.group_name );
        params.put( "is_display", groupInfo.is_display + "" );
        params.put( "logo_level", groupInfo.logo_level + "" );
        params.put( "name_flag", groupInfo.name_flag + "" );
        params.put( "site_id", groupInfo.site_id + "" );
        params.put( "data", "{\"member\":" + JSONHelper.toJSONString( groupInfo.member ) + "}" );

        List<UccServerGroupCreateResult> listRes = postParamArray( serverUrl + GROUP_CREATE_PATH, params,
                UccServerGroupCreateResult.class );
        if ( listRes.size() == 0 )
        {
            throw new Exception( "data is invalid array format." );
        }

        return listRes.get( 0 );
    }

    public void groupQuit( long siteId, long userId, long groupId ) throws Exception
    {
        Map<String, String> params = new HashMap<String, String>();
        params.put( "group_id", groupId + "" );
        params.put( "site_id", siteId + "" );
        params.put( "user_id", userId + "" );

        postParam( serverUrl + GROUP_QUIT_PATH, params );
    }
    
    public void memberClean( List<Integer> userIds, int type ) throws Exception
    {
        if ( null == userIds || userIds.isEmpty() )
        {
            return;
        }

        Map<String, String> params = new HashMap<String, String>();

        params.put( "user_ids", userIds.toString() );
        params.put( "type", String.valueOf( type ) );

        String url = serverUrl + GROUP_MEMBER_CLEAN;

        postParamContent( url, params );
    }

    public void groupStatusUpdate( long groupId, long userId, 
            long type, String statusInfo )
        throws ServiceException
    {
        Map<String, Object> params = new LinkedHashMap<String, Object>();

        params.put( "group_id", groupId );
        params.put( "user_id", userId );
        params.put( "type", type );

        if ( null != statusInfo )
        {
            params.put( "statusInfo", statusInfo );
        }

        String url = serverUrl + GROUP_STATUS_UPDATE;

        postParam( url, params );
    }
}
