package com.quanshi.uclib.service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.quanshi.uclib.dataobject.SiteTagsResult;
import com.quanshi.uclib.service.dataobject.LdapConfBriefInfo;
import com.quanshi.uclib.service.dataobject.LdapConfCreateArgs;
import com.quanshi.uclib.service.dataobject.LdapConfDetailInfo;
import com.quanshi.uclib.service.dataobject.LdapConfEditArgs;
import com.quanshi.uclib.service.dataobject.LdapConfGetAttributeArgs;
import com.quanshi.uclib.service.dataobject.LdapConfGetClassArgs;
import com.quanshi.uclib.service.dataobject.OrgOrUserInfo;
import com.quanshi.uclib.service.dataobject.QuitUserReturn;
import com.quanshi.uclib.service.dataobject.SetOrgAuthTypeResult;
import com.quanshi.uclib.service.dataobject.UmsCreateUserInfo;
import com.quanshi.uclib.service.dataobject.UmsOrgAndUserArg;
import com.quanshi.uclib.service.dataobject.UmsOrgAuthScope;
import com.quanshi.uclib.service.dataobject.UmsOrgAuthType;
import com.quanshi.uclib.service.dataobject.UmsOrgInfo;
import com.quanshi.uclib.service.dataobject.UmsOrgInfoResponseBodyArray;
import com.quanshi.uclib.service.dataobject.UmsPbxBindResultObjects.UmsPbxBindResult;
import com.quanshi.uclib.service.dataobject.UmsPbxBindResultObjects.UmsPbxunBindResult;
import com.quanshi.uclib.service.dataobject.UmsPbxBindResultObjects.bindPbxObject;
import com.quanshi.uclib.service.dataobject.UmsPbxBindResultObjects.getUms3rdStatusReturn;
import com.quanshi.uclib.service.dataobject.UmsPbxBindResultObjects.switchStatusReturn;
import com.quanshi.uclib.service.dataobject.UmsPbxBindResultObjects.unbindPbxObject;
import com.quanshi.uclib.service.dataobject.UmsPrivilageInvisibleOrgInfo;
import com.quanshi.uclib.service.dataobject.UmsPrivilageInvisibleOrgResultContentInfo;
import com.quanshi.uclib.service.dataobject.UmsSetPrivilageInvisibleOrgArgs;
import com.quanshi.uclib.service.dataobject.UmsSiteInfo;
import com.quanshi.uclib.service.dataobject.UmsThirdPartyObjects.BindThirdPartyArgs;
import com.quanshi.uclib.service.dataobject.UmsThirdPartyObjects.UmsBindThirdPartyResult;
import com.quanshi.uclib.service.dataobject.UmsThirdPartyObjects.UmsGetThirdPartyResult;
import com.quanshi.uclib.service.dataobject.UmsThirdPartyObjects.UmsModifyThirdPartyStatusResult;
import com.quanshi.uclib.service.dataobject.UmsThirdPartyObjects.UmsUnBindThirdPartyResult;
import com.quanshi.uclib.service.dataobject.UmsUserInfo;
import com.quanshi.uclib.service.dataobject.UmsUserShortInfo;
import com.quanshi.uclib.service.dataobject.UmsUserTagsValueInfo;
import com.quanshi.uclib.service.dataobject.UmsVerifyMailMobileObjects.UmsVerifyMailMobileReturn;
import com.quanshi.uclib.service.dataobject.UmsVerifyMailMobileObjects.UmsVerifyPhoneAndMailArgs;
import com.quanshi.uclib.service.dataobject.UserByAttributeReturn;
import com.quanshi.uclib.service.dataobject.UserProductDTO;
import com.quanshi.uclib.service.dataobject.UserValidateCheckObjects.UserUniqueInfo;
import com.quanshi.uclib.service.dataobject.UserValidateCheckObjects.ValidateUserReturn;
import com.quanshi.uclib.service.dataobject.UserValidateCheckObjects.ValidateUserReturn.UserfindInfo;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

/**
 * @author shengjun.wu
 *
 */
public class UmsService extends JsonService
{
    public static Logger        log                              = LoggerFactory.getLogger( UmsService.class );
    public static final int     UC_PRODUCT_ID                    = 20;
    public static final int     PC30_PRODUCT_ID                  = 60000;
    public static final int     UC_PRODUCT_ENABLE_OR_OPENED      = 82;
    public static final short   UC_PRODUCT_DISABLE               = 0;

    private static final String POST_CONTTYPE                    = "application/json";
    private static final String URI_USER_CREATE                  = "/rs/users";
    private static final String URI_MODIFY_PASSWORD              = "/rs/users/id/%d/password";
    private static final String URI_CHANGE_PASSWORD              = "/rs/users/id/%d/change_password";
    private static final String URI_USER_BY_NAME                 = "/rs/users/getUserByName?loginName=%s&productID=" + UC_PRODUCT_ID;
    private static final String URI_USER_BY_KEYWORD              = "/rs/users/getByOrgOrUser?searchText=%s&customerCode=%s&type=1";
    private static final String URI_ORG_SEARCH_BY_KEYWORD        = "/rs/organizations/query/%s";
    private static final String URI_USER_UPDATE                  = "/rs/users/updateUser";
    private static final String URI_USER_BY_ID                   = "/rs/users/getUserById?userId=%d&productID="
            + UC_PRODUCT_ID;
    private static final String URI_USER_UNBIND                  = "/rs/users/unbind?markQuit=%s&siteId=%d";
    
    private static final String URI_USER_BY_MOBILE               = "/rs/users/mobile/%s/" + UC_PRODUCT_ID;
    private static final String URI_USER_BY_EMAIL                = "/rs/users/getUserByEmail?email=%s";

    private static final String URI_USER_IS_EXISTS               = "/rs/users/validate";
    private static final String URI_USER_VERIFY_MAIL_MOBILE      = "/rs/users/verifyPhoneAndMail";
    private static final String URI_USER_CHECK_VERIFIED          = "/rs/users/checkVerified";
    

    private static final String URI_USER_BY_IDS                  = "/rs/users/id/in";
    private static final String URI_USER_TO_ORG                  = "/rs/organizations/%d/users/%d";
    private static final String URI_SET_USER_TO_ORG              = "/rs/organizations/%d/users/%d/1";
    private static final String URI_USER_MOVE_ORG                = "/rs/organizations/change_organization";
    private static final String URI_USER_GET_ORG                 = "/rs/users/%d/organizations";
                                                                                                          // productId
    // 不同
    private static final String URI_USER_CHANGE_THIRD_STATUS     = "/rs/users/thirdparty/%d/changestatus/%d?productID="
            + UC_PRODUCT_ID;

    private static final String URI_GET_CHILD_ORGS               = "/rs/organizations/%d?scope=%s&types=%s";
    private static final String URI_GET_ORG                      = "/rs/organizations/%d/brief";
    private static final String URI_GET_ORG_BY_CUSTOMERCODE      = "/rs/organizations?customer_code=%S";
    private static final String URI_ORG_ADD                      = "/rs/organizations";
    private static final String URI_ORG_DELETE                   = "/rs/organizations/%d";
    private static final String URI_ORG_MOVE                     = "/rs/organizations/%d/parent_id/%d";
    private static final String URI_ORG_USER                     = "/rs/organizations/%d/users?productID="
            + UC_PRODUCT_ID;
    
    private static final String URI_ORG_AUTH                     = "/rs/organizations/auth/%d/%d/%s/%d";
    private static final String URI_ORG_DETAILS                  = "/rs/organizations/%d/details";
    
    private static final String URI_ORG_USER_SORT                = "/rs/organizations/changeUserOrderFlag/%d"; //组织下用户的排序
    
	private static final String URI_ORG_SITE_TAGS                = "/rs/sites/%d/productId/%d/userTags/";                          // 标签查询
    private static final String URI_ORG_TAGS_VALUES              = "/rs/users/UserTags/get/userId/%d/tagId/%d";                    // 标签查询
    private static final String URI_CREATE_ORG_USER              =  "/rs/organizations/list";
    private static final String URI_FIND_ORG_BY_NAMES            =  "/rs/organizations/findOrgByNames/%s";
    
    private static final String URI_ORG_PATH_QUERY               = "rs/organizations/%d/pathquery";                                // 组织关系名查
    private static final String URI_ORG_BATCH_QUERY              = "rs/organizations/batchquery";                                  // 批量获取组织信息
    
    private static final String URI_USER_TAG_VALUES_GET          
        = "/rs/users/UserTags/get/userId/%d?productId=" + UC_PRODUCT_ID + "&siteId=%d"; 
    private static final String URI_USER_TAG_VALUE_GET           
        = "/rs/users/UserTags/get/userId/%d/tagId/%d?productId=" + UC_PRODUCT_ID + "&siteId=%d";      //用户标签值查询
    private static final String URI_USER_TAGS_VALUE_UPDATE       = "/rs/users/UserTags/update?userId=%d";            //用户标签值更新
    private static final String URI_USER_TAGS_VALUE_ADD          = "/rs/users/UserTags/add?userId=%d&productId=" + UC_PRODUCT_ID;               //用户标签值添加
    private static final String URI_USER_TAGS_VALUE_DELETE       = "/rs/users/UserTags/del/userId/%d/tagId/%d?productId=" + UC_PRODUCT_ID;      //用户标签值删除

    private static final String URI_SITE_TAGS_GET            = "/rs/sites/%d/productId/%d/userTags/";                      // 标签查询
    private static final String URI_SITE_TAGS_ADD                = "/rs/sites/%d/productId/%d/userTags/add";                       // 标签添加
    private static final String URI_SITE_TAGS_UPDATE             = "/rs/sites/%d/productId/%d/userTags/update";                    // 站点标签修改
    private static final String URI_SITE_TAGS_DELETE             = "/rs/sites/%d/productId/%d/userTags/del/%d";                    // 标签删除

    private static final String URI_SITE_URL_GET                 = "/rs/sites?url=%s";                                             // 查询site
    
    private static final String URI_ORG_PRIVILAGE_INVISIBLE_GET   = "/rs/organizations/permission/%d";
    private static final String URI_ORG_PRIVILAGE_INVISIBLED_GET  = "/rs/organizations/permission/target/%d";
    private static final String URI_ORG_PRIVILAGE_INVISIBLE_SET   = "/rs/organizations/permission/%d/%d/%s/%d";
    private static final String URI_ORG_PRIVILAGE_INVISIBLE_SET_BATCH  = "/rs/organizations/permission/source/%d/invisible/1";
    private static final String URI_ORG_PRIVILAGE_INVISIBLED_SET_BATCH   = "/rs/organizations/permission/target/%d/invisible/1";
    private static final String URI_ORG_PRIVILAGE_INVISIBLE_DEL  = "/rs/organizations/permission/%d";

    private static final String URI_LDAP_GET_LIST                = "/rs/ldap/siteId/%d";                                           // 获取ldap配置列表
    private static final String URI_LDAP_GET                     = "/rs/ldap/%d";                                                  // 获取ldap配置详情
    private static final String URI_LDAP_CREATE                  = "/rs/ldap";                                                     // 创建ldap配置
    private static final String URI_LDAP_EDIT                    = "/rs/ldap";                                                     // 修改ldap配置
    private static final String URI_LDAP_DELETE                  = "/rs/sites/%d/ldap/%d";                                         // 删除ldap配置
    private static final String URI_LDAP_GET_CLASS               = "/rs/sites/ldap/classes";                                       // 获取ldap
                                                                                                                                   // class
    private static final String URI_LDAP_GET_ATTRIBUTE           = "/rs/sites/ldap/classes/attributes";                            // 获取ldap
    private static final String URI_SORT_ORG                     = "/rs/organizations/changeOrderFlag";
    
    private static final String URI_USER_GET_PRODUCT             = "/rs/users/getUserProductList?userId=%d&productId=%d";          // 获取用户产品列表
    private static final String URI_USER_SET_PRODUCT             = "/rs/users/setUserProduct?productId=%d&userStatus=%d&sitesId=%d&userId=%d"; // 设置用户产品

	private static final String URI_PBX_USER_BIND_THIRD_STATUS   = "/rs/users/thirdparty/bind?productID="
            + UC_PRODUCT_ID;
    private static final String URI_PBX_USER_UNBIND_THIRD_STATUS = "/rs/users/thirdparty/unbind?productID="
            + UC_PRODUCT_ID + "&tpId=%s&type=1&userId=%d";
    private static final String URI_PBX_USER_CHANGE_THIRD_STATUS = "rs/users/thirdparty/%d/changestatus/%d?productID="
            + UC_PRODUCT_ID;
    private static final String URI_PBX_USER_QUERY_THIRD_STATUS  = "rs/users/thirdparty/list/%d?productID="
            + UC_PRODUCT_ID;
    
    private static final String URI_BIND_THIRDPARTY           = "/rs/users/thirdparty/bind?productID=" + UC_PRODUCT_ID;
    private static final String URI_UNBIND_THIRDPARTY         = "/rs/users/thirdparty/unbind?productID=" + UC_PRODUCT_ID + "&tpId=%s&type=%d&userId=%d";
    private static final String URI_MODYFIY_THIRDPARTY_STATUS = "/rs/users/thirdparty/%d/changestatus/%d?productID="+ UC_PRODUCT_ID;
    private static final String URI_GET_THIRDPARTY            = "/rs/users/thirdparty/list/%d?productID=" + UC_PRODUCT_ID;
    
    private static final String URI_QUERY_QUIT_USERS          = "/rs/users/listQuitUser/%d?productID=" + UC_PRODUCT_ID + "&pageNum=%d&pageSize=%d";//分页查询离职人员
    private static final String URI_MARK_QUIT_USER            = "/rs/users/markQuitUser/%d";
    
    private static final String URI_GET_USER_BY_ATTR          = "/rs/users/attribute/%d?productID=" + UC_PRODUCT_ID;
    
    public static final int THIRD_PARTY_PBX_TYPE  = 1;
    public static final int THIRD_PARTY_CALL_TYPE = 2;
    public static final int THIRD_PARTY_CONF_TYPE = 3;
    public static final int THIRD_PARTY_CALL_PHONE_TYPE = 4;
    public static final int THIRD_PARTY_CONF_PHONE_TYPE = 5;
    public static final int THIRD_PARTY_YUNPAN_TYPE = 6;
    public static final int THIRD_PARTY_INVITE_TYPE = 7;
    public static final int THIRD_PARTY_SENDDOCINCHAT_TYPE = 8;

    public static final String  QUREY_SCOPE_SUBTREE              = "subtree";                                                      // 查询下层所有节点
    public static final String  QUERY_SCOPE_SAMELEVEL            = "samelevel";                                                    // 查询同层兄弟节点
    public static final String  QUERY_SCOPE_NEXTLEVEL            = "nextlevel";                                                    // 查询下一层的子节点

    public static final int     ORG_TYPE_ENTERPRISE              = 1;
    public static final int     ORG_TYPE_ORGANIZATION            = 3;
    public static final int     ORG_TYPE_SUB_ORGANIZATION        = 5;

    public static final String  QUERY_PERMISSION_KEY             = "invisible";
    public static final int     QUERY_PERMISSION_VALUE           = 1;

    public static final int     TAG_TYPE_SYSTEM                  = 0;                                                              // 必选标签
    public static final int     TAG_TYPE_OPTIONAL                = 1;                                                              // 可选标签
    public static final int     TAG_TYPE_CUSTOMIZED              = 2;                                                              // 自定义标签

    public static final String  TAG_CODE_SURNAME        = "tag_u_surname";
    public static final String  TAG_CODE_NAME           = "tag_u_name";
    public static final String  TAG_CODE_DISPLAY_NAME   = "tag_u_display_name";
    public static final String  TAG_CODE_LOGIN_NAME     = "tag_u_login_name";
    public static final String  TAG_CODE_DEPEARTMENT    = "tag_u_depeartment";
    public static final String  TAG_CODE_POSITON        = "tag_u_positon";
    public static final String  TAG_CODE_MOBILE         = "tag_u_mobile";
    public static final String  TAG_CODE_CONTRY         = "tag_u_contry";
    public static final String  TAG_CODE_OFFICE         = "tag_u_office";
    public static final String  TAG_CODE_EMAIL          = "tag_u_email";
    public static final String  TAG_CODE_PHONE          = "tag_u_phone";
    public static final String  TAG_CODE_PBX            = "tag_u_pbx_extension";
    
    public static final String  SET_AUTH_TYPE_SCOPE_SELF = "self";
    public static final String  SET_AUTH_TYPE_SCOPE_ALL  = "all";

    private String              serverUrl                        = null;
    private String              ldapServerUrl                        = null;
    
    public static final int UMS_RESULT_CODE_01 = -1;
    public static final int UMS_RESULT_CODE_02 = -2;
    public static final int UMS_RESULT_CODE_0 = 0;

    public UmsService(String serverUrl)
    {
        super();
        this.serverUrl = serverUrl;
    }
    
    public UmsService(String serverUrl, String ldapServerUrl)
    {
    	super();
    	this.serverUrl = serverUrl;
    	this.ldapServerUrl = ldapServerUrl;
    }

    public int createUser( UmsCreateUserInfo info ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_CREATE );
        
        String userIdStr = postJsonContent( url, info );
        
        return userIdStr != null ? Integer.valueOf( userIdStr ) : 0;
    }

    public void modifyPass( long userId, String password ) throws Exception
    {
        log.debug( "modifyPass userId: " + userId );

        String url = serverUrl + String.format( URI_MODIFY_PASSWORD, userId );
        String resp = putTextContent( url, password, "text/plain" );

        if ( !"true".equals( resp ) )
        {
            String errmsg = "modify password back content is not true, " + url;
            log.warn( errmsg );
            throw new Exception( errmsg );
        }

        log.debug( "modifyPass successful. userId: " + userId );
    }

    public void changePass( long userId, String oldPassword, String newPassword ) throws Exception
    {
        log.debug( "changePass userId: " + userId );

        Map<String, String> param = new HashMap<String, String>();
        String url = serverUrl + String.format( URI_CHANGE_PASSWORD, userId );

        param.put( "oldPassword", oldPassword );
        param.put( "newPassword", newPassword );

        String resp = putParamContent( url, param );

        if ( !"true".equals( resp ) )
        {
            String errmsg = "chanage password back content is not true, " + url;
            log.warn( errmsg );
            throw new Exception( errmsg );
        }
    }

    /**
     * 通过登录名 获取用户资料
     * 
     * @param loginName
     * @return
     * @throws Exception
     */
	public UmsUserInfo userByName( String loginName ) throws Exception
	{
		log.debug( "query userInfo by loginName:" + loginName );

		String url = serverUrl + String.format( URI_USER_BY_NAME, URLEncoder.encode( loginName.trim(), "UTF-8" ) );

		try
		{
			return getObject( url, UmsUserInfo.class );
		}
		catch ( ServiceException e )
		{
			if ( StringUtils.isNotEmpty( e.getContent() ) && e.getMessage().contains( "404" ) )
			{
				return null;
			}
			
			throw e;
		}

	}

    /**
     * 通过用户ID获取资料
     * 
     * @param id
     * @return
     * @throws ServiceException
     */
    public UmsUserInfo userById( long id ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_BY_ID, id );

        return getObject( url, UmsUserInfo.class );

    }

    /**
     * 
     * @param mobile
     * @return
     * @throws ServiceException
     */
    public UmsUserInfo userByMobile( String mobile ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_BY_MOBILE, mobile );

        return getObject( url, UmsUserInfo.class );

    }

    public UmsUserInfo userByEmail( String email ) throws Exception
    {
        String url = serverUrl + String.format( URI_USER_BY_EMAIL, URLEncoder.encode( email, "UTF-8" ) );

        return getObject( url, UmsUserInfo.class );

    }

    /**
     * 批量获取用户信息
     * 
     * @param ids
     * @return
     * @throws ServiceException
     */

    public List<UmsUserInfo> userByIds( List<Long> ids ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_BY_IDS );

        return postJsonArray( url, ids, UmsUserInfo.class );

    }

    /**
     * 判断用户是否存在
     * 
     * @param uInfo
     * @return
     * @throws ServiceException
     */
    public String userIsExists( UserUniqueInfo uInfo ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_IS_EXISTS );

        ValidateUserReturn rlt = postJsonObject( url, uInfo, ValidateUserReturn.class );
        if ( rlt.result.equals( "conflict" ) || (rlt.users != null && rlt.users.size() > 0) )
        {
            for ( UserfindInfo conflict : rlt.users )
            {
                if ( conflict.validateType != null )
                {
                    return conflict.validateType;
                }
            }

        }
        return null;
    }
    
    /**
     *  根据用户登录名、邮箱、手机号，获取已认证用户信息
     * 
     * @param uInfo
     * @return
     * @throws ServiceException
     */
    public List<UserfindInfo> getUserValidateInfo( UserUniqueInfo uInfo ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_IS_EXISTS );

        ValidateUserReturn rlt = postJsonObject( url, uInfo, ValidateUserReturn.class );
        if ( rlt.result.equals( "conflict" ) || (rlt.users != null && rlt.users.size() > 0) )
        {
            return rlt.users;
        }
        
        return null;
    }

    /**
     * 强制验证手机和邮箱
     * 
     * @param uInfo
     * @return
     * @throws ServiceException
     */
    public boolean verifyPhoneAndMail( UmsVerifyPhoneAndMailArgs mailmobile ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_CHECK_VERIFIED );

        UmsVerifyMailMobileReturn rlt = postJsonObject( url, mailmobile, UmsVerifyMailMobileReturn.class );
        if ( rlt.flag == 1 )
        {
            return true;
        }
        return false;
    }
    
    public boolean revokeMailMobile( UmsVerifyPhoneAndMailArgs mailmobile ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_VERIFY_MAIL_MOBILE );

        UmsVerifyMailMobileReturn rlt = postJsonObject( url, mailmobile, UmsVerifyMailMobileReturn.class );
        if ( rlt.flag == 1 )
        {
            return true;
        }
        return false;
    }

    /**
     * 修改用户pbx状态
     * 
     * @param userId
     * @param Status
     * @param tpDBid
     *            pbx数据库里的记录id
     * @return {Status:1}
     * @throws ServiceException
     */
    public UmsBindThirdPartyResult updateUserPbx( long userId, int Status, long tpDBid ) throws ServiceException
    {

        String url = serverUrl + String.format( URI_USER_CHANGE_THIRD_STATUS, tpDBid, Status );

        return postTextObject( url, "", POST_CONTTYPE, UmsBindThirdPartyResult.class );

    }

    /**
     * 修改用户资料
     * 
     * @param userinfo
     * @return
     * @throws Exception
     */
    public boolean updateUser( UmsCreateUserInfo userinfo ) throws Exception
    {
        String url = serverUrl + URI_USER_UPDATE;
        
        String ret = postJsonContent( url, userinfo );
        
        return Boolean.valueOf( ret ) ? true : false;
    }

    /**
     * 根据关键字搜索用户（返回详细资料）
     * 
     * @param keyWord
     * @param customerCode
     * @return
     * @throws Exception
     */
    public List<UmsUserInfo> searchUser( String keyWord, String customerCode ) throws Exception
    {
        String url = serverUrl + String.format( URI_USER_BY_KEYWORD, URLEncoder.encode( keyWord, "UTF-8" ), customerCode );

        List orgids = new ArrayList(); // 此处无值
        OrgOrUserInfo ret = postJsonObject( url, orgids, OrgOrUserInfo.class );

        if ( ret != null )
        {
            return ret.users;
        }
        return null;

    }
    
    /**
     * 根据关键字搜索指定部门的用户（返回详细资料）
     * @param keyWord 搜索关键字
     * @param customerCode
     * @param orgids 部门id
     * @return
     * @throws Exception
     */
	public List<UmsUserInfo> searchUser( String keyWord, String customerCode, List<Integer> orgids ) throws Exception
	{
		String url = serverUrl
				+ String.format( URI_USER_BY_KEYWORD, URLEncoder.encode( keyWord, "UTF-8" ), customerCode );

		OrgOrUserInfo ret = postJsonObject( url, orgids, OrgOrUserInfo.class );

		if ( ret != null )
		{
			return ret.users;
		}
		return null;

	}

    /**
     * 根据关键字，搜索用户列表
     * 
     * @param keyWord
     * @param customerCode
     * @return
     * @throws Exception
     */
    public List<UmsUserShortInfo> searchUserForSnapshoot( String keyWord, String customerCode ) throws Exception
    {
        log.debug( "query userSnapshoot by keyWord:" + keyWord );
        List<UmsUserInfo> userlist = searchUser( keyWord, customerCode );
        if ( userlist == null || userlist.size() < 1 )
        {
            return null;
        }
        List<UmsUserShortInfo> newlist = new ArrayList<UmsUserShortInfo>();
        for ( UmsUserInfo info : userlist )
        {
            UmsUserShortInfo newinfo = new UmsUserShortInfo();
            newinfo.displayName = info.displayName;
            newinfo.id = info.id;
            newinfo.mobileNumber = info.mobileNumber;
            newinfo.email = info.email;
            newinfo.loginName = info.loginName;
            newlist.add( newinfo );
        }
        return newlist;
    }

    /**
     * 将用户移动到新的组织（调岗）
     * 
     * @param userId
     * @param orgId
     * @throws ServiceException
     */
    public void addUser2Org( int userId, int toOrgId ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_TO_ORG, toOrgId, userId );

        postJsonContent( url, null );

        return;
    }

    /**
     * 将用户移动到新的组织（调岗）
     * 
     * @param userId
     * @param orgId
     * @throws ServiceException
     */
    public void setUser2Org( int userId, int toOrgId ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_SET_USER_TO_ORG, toOrgId, userId );

        postJsonContent( url, null );

        return;
    }

    /**
     * 将用户移动到新的组织（调岗）
     * 
     * @param userId
     * @param orgId
     * @throws ServiceException
     */
    public void changeUser2Org( int userId, int fromOrgId, int toOrgId ) throws ServiceException
    {
        class MoveArgs
        {
            public int id;
            public int from;
            public int to;
        }
        String url = serverUrl + String.format( URI_USER_MOVE_ORG );
        MoveArgs moveArgs = new MoveArgs();
        moveArgs.id = userId;
        moveArgs.from = fromOrgId;
        moveArgs.to = toOrgId;

        putJsonContent( url, moveArgs );

        return;
    }

    public int addOrg( Integer parentId, String name, String customerCode, int type ) throws Exception
    {
        log.debug( String.format( "add organization %s.", name ) );

        Map<String, String> param = new HashMap<String, String>();

        if ( null != parentId)
        {
        	param.put( "parentId", parentId + "" );
        }
        
        param.put( "name", name.trim() );
        param.put( "customercode", customerCode );
        param.put( "type", type + "" );

        String orgId = postJsonContent( serverUrl + URI_ORG_ADD, param );
        if ( null != orgId )
        {
            try
            {
                return Integer.parseInt( orgId );
            }
            catch ( Exception e )
            {
                String errmsg = "invalie result: " + orgId;
                log.warn( errmsg );
                throw new ServiceException( ServiceException.ERROR_FORMAT, errmsg );
            }
        }
        else
        {
            String errmsg = "result is null: " + orgId;
            log.warn( errmsg );
            throw new ServiceException( ServiceException.ERROR_FORMAT, errmsg );
        }
    }
    
    public void updateOrg( int id, int parentId, String name, String customerCode, int type ) throws Exception
    {
        log.debug( String.format( "update organization %d to %s.", id, name ) );

        Map<String, String> param = new HashMap<String, String>();

        param.put( "id", id + "" );
        param.put( "parentId", parentId + "" );
        param.put( "name", name.trim() );
        param.put( "customercode", customerCode );
        param.put( "type", type + "" );

        putJsonContent( serverUrl + URI_ORG_ADD, param );
    }

    public void deleteOrg( int id ) throws Exception
    {
        log.debug( String.format( "delete organization %d.", id ) );

        deleteContent( serverUrl + String.format( URI_ORG_DELETE, id ) );
    }

    public void moveOrg( int id, int parentId ) throws Exception
    {
        String url = serverUrl + String.format( URI_ORG_MOVE, id, parentId );

        putJsonContent( url, null );
    }

    public void sortOrg( int[] Ids ) throws Exception
    {
        String url = serverUrl + URI_SORT_ORG;

        this.postJsonContent( url, Ids );
    }
    
    public List<UmsCreateUserInfo> createOrgAndUser( List<UmsOrgAndUserArg> arg ) throws ServiceException
    {
        String url = serverUrl + URI_CREATE_ORG_USER;
        
        return this.postJsonArray(url, arg, UmsCreateUserInfo.class);
    }
    
    public UmsOrgInfo findOrgByNames( String customerCode, List<String> names ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_FIND_ORG_BY_NAMES, customerCode );
        
        String orgNames = "";
        for( int i=0,len = names.size() ;  i< len; i++ )
        {
            orgNames += ( i == len - 1 ) ? names.get( i ).trim() : names.get( i ).trim() + ";";
        }
                
       String content = postTextContent( url, orgNames, POST_CONTTYPE );
       
       if ( content != null && ! content.isEmpty() )
       {
           return this.parseResponseObject( this.getLastRes(), UmsOrgInfo.class );
       }
       
       return null;
    }
    

    public List<UmsPrivilageInvisibleOrgInfo> getPrivilageInvisibleOrg( int orgId ) throws Exception
    {
        String url = serverUrl + String.format( URI_ORG_PRIVILAGE_INVISIBLE_GET, orgId );

        UmsPrivilageInvisibleOrgResultContentInfo contentInfo = getObject( url,
                UmsPrivilageInvisibleOrgResultContentInfo.class );
        if ( null == contentInfo || contentInfo.status != 1 )
        {
            String errmsg = String.format( "response status is valid for %s, because %s", url, contentInfo.details );
            log.warn( errmsg );
            throw new ServiceException( ServiceException.ERROR_RESULT, errmsg );
        }

        List<UmsPrivilageInvisibleOrgInfo> bodys = contentInfo.body;
        if ( null == bodys || bodys.size() == 0 )
        {
            return null;
        }

        for ( int i = 0; i < bodys.size(); i++ )
        {
            UmsPrivilageInvisibleOrgInfo orgInfo = bodys.get( i );
            if ( !"invisible".equals( orgInfo.permissionKey ) || !"1".equals( orgInfo.permissionValue ) )
            {
                bodys.remove( i );
                i--;
            }
        }

        return bodys;
    }
    
    /**
     * 获取不可见该组织的组织
     * @param orgId
     * @return
     * @throws Exception
     */
    public List<UmsPrivilageInvisibleOrgInfo> getPrivilageInvisibledOrg( int orgId ) throws Exception
    {
        String url = serverUrl + String.format( URI_ORG_PRIVILAGE_INVISIBLED_GET, orgId );

        UmsPrivilageInvisibleOrgResultContentInfo contentInfo = getObject( url,
                UmsPrivilageInvisibleOrgResultContentInfo.class );
        if ( null == contentInfo || contentInfo.status != 1 )
        {
            String errmsg = String.format( "response status is valid for %s, because %s", url, contentInfo.details );
            log.warn( errmsg );
            throw new ServiceException( ServiceException.ERROR_RESULT, errmsg );
        }

        List<UmsPrivilageInvisibleOrgInfo> bodys = contentInfo.body;
        if ( null == bodys || bodys.size() == 0 )
        {
            return null;
        }

        for ( int i = 0; i < bodys.size(); i++ )
        {
            UmsPrivilageInvisibleOrgInfo orgInfo = bodys.get( i );
            if ( !"invisible".equals( orgInfo.permissionKey ) || !"1".equals( orgInfo.permissionValue ) )
            {
                bodys.remove( i );
                i--;
            }
        }

        return bodys;
    }
    
    /**
     * 设置组织的不可见组织
     * @param id
     * @param targetId
     * @param key
     * @param value
     * @throws Exception
     */
    public void setPrivilageInvisibleOrg( int id, int targetId, String key, int value ) throws Exception
    {
        String url = serverUrl + String.format( URI_ORG_PRIVILAGE_INVISIBLE_SET, id, targetId, key, value );

        UmsSetPrivilageInvisibleOrgArgs orgArgs = new UmsSetPrivilageInvisibleOrgArgs();
        orgArgs.id = id;
        orgArgs.targetId = targetId;
        orgArgs.key = key;
        orgArgs.value = value;

        UmsPrivilageInvisibleOrgResultContentInfo contentInfo = putJsonObject( url, orgArgs,
                UmsPrivilageInvisibleOrgResultContentInfo.class );

        if ( null == contentInfo || contentInfo.status != 1 )
        {
            String errmsg = String.format( "response status is valid for %s, because %s", url, contentInfo.details );
            log.warn( errmsg );
            throw new ServiceException( ServiceException.ERROR_RESULT, errmsg );
        }
    }
    
    /**
     * 批量设置组织的不可见组织
     * @param id
     * @param ids
     * @throws Exception
     */
    public void setPrivilageInvisibleOrgs( int id, List<Integer> ids ) throws Exception
    {
        String url = serverUrl + String.format( URI_ORG_PRIVILAGE_INVISIBLE_SET_BATCH, id );
        
        UmsPrivilageInvisibleOrgResultContentInfo contentInfo = putJsonObject( url, ids,
                UmsPrivilageInvisibleOrgResultContentInfo.class );
        
        if ( null == contentInfo || contentInfo.status != 1 )
        {
            String errmsg = String.format( "response status is valid for %s, because %s", url, contentInfo.details );
            log.warn( errmsg );
            throw new ServiceException( ServiceException.ERROR_RESULT, errmsg );
        }
    }
    
    /**
     * 批量设置不可见该组织的组织
     * @param id
     * @param ids
     * @throws Exception
     */
    public void setPrivilageInvisibledOrgs( int id, List<Integer> ids ) throws Exception
    {
        String url = serverUrl + String.format( URI_ORG_PRIVILAGE_INVISIBLED_SET_BATCH, id );
        
        UmsPrivilageInvisibleOrgResultContentInfo contentInfo = putJsonObject( url, ids,
                UmsPrivilageInvisibleOrgResultContentInfo.class );
        
        
        if ( null == contentInfo || contentInfo.status != 1 )
        {
            String errmsg = String.format( "response status is valid for %s, because %s", url, contentInfo.details );
            log.warn( errmsg );
            throw new ServiceException( ServiceException.ERROR_RESULT, errmsg );
        }
    }
    
    /**
     * 删除组织的不可见组织
     * @param permissionId
     * @throws Exception
     */
    public void delPrivilageInvisibleOrg( int permissionId ) throws Exception
    {
        String url = serverUrl + String.format( URI_ORG_PRIVILAGE_INVISIBLE_DEL, permissionId );
        UmsPrivilageInvisibleOrgResultContentInfo contentInfo = deleteObject( url,
                UmsPrivilageInvisibleOrgResultContentInfo.class );

        if ( null == contentInfo || contentInfo.status != 1 )
        {
            String errmsg = String.format( "response status is valid for %s, because %s", url, contentInfo.details );
            log.warn( errmsg );
            throw new ServiceException( ServiceException.ERROR_RESULT, errmsg );
        }
    }

    public List<UmsUserInfo> getOrgAccounts( long orgId ) throws Exception
    {
        String url = serverUrl + String.format( URI_ORG_USER, orgId );
        return getArray( url, UmsUserInfo.class );
    }
    
    /**
     * 获取用户的组织信息
     * @param userId
     * @return
     * @throws ServiceException
     */
    public List<UmsOrgInfo> getOrgInfoByUserId( Integer userId ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_GET_ORG, userId );
        return getArray( url, UmsOrgInfo.class );
    }
    
    /**
     * 获取用户所有的标签值
     * @param siteId
     * @param userId
     * @return
     * @throws ServiceException
     */
    public List<UmsUserTagsValueInfo> getUserTagValues( Long siteId, Long userId ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_TAG_VALUES_GET, userId, siteId );

        return getArray( url, UmsUserTagsValueInfo.class );
    }
    
    /**
     * 获取用户标签值
     * @param siteId
     * @param userId
     * @param tagId
     * @return
     * @throws ServiceException
     */
    public List<UmsUserTagsValueInfo> getUserTagValue( Long siteId, Long userId, Long tagId ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_TAG_VALUE_GET, userId, tagId, siteId );

        return getArray( url, UmsUserTagsValueInfo.class );
    }

    /**
     * 更新用户标签值
     * @param userId
     * @param tagValues tagId必选
     * @return
     * @throws ServiceException
     */
    public boolean updateUserTagsValue( long userId, List<UmsUserTagsValueInfo> tagValues ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_TAGS_VALUE_UPDATE, userId );

        String ret = postJsonContent( url, tagValues );
        
        return Boolean.valueOf( ret ) ? true : false;
    }
    
    /**
     * 添加用户标签值
     * @param userId
     * @param tagValues
     * @return
     * @throws ServiceException
     */
    public List<UmsUserTagsValueInfo> addUserTagsValue( long userId, List<UmsUserTagsValueInfo> tagValues ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_TAGS_VALUE_ADD, userId );
        
        return putJsonArray( url, tagValues, UmsUserTagsValueInfo.class  );
    }
    
    /**
     * 删除用户标签值
     * @param userId
     * @param tagId 用户的标签ID
     * @return
     * @throws ServiceException
     */
    public boolean delUserTagsValue( long userId, long tagId ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_TAGS_VALUE_DELETE, userId, tagId );
        String ret = this.deleteContent( url );
        
        return Boolean.valueOf( ret ) ? true : false;

    }
    
    /**
     * 查询站点标签
     * @param siteId
     * @param productID
     * @return
     * @throws Exception
     */
    public List<SiteTagsResult> getSiteTags( long siteId, int productID ) throws Exception
    {
        String url = serverUrl + String.format( URI_SITE_TAGS_GET, siteId, productID );

        return getArray( url, SiteTagsResult.class );
    }
    
    /**
     * 添加站点标签
     * @param siteId
     * @param productId
     * @param tags
     * @return
     * @throws Exception
     */
    public List<SiteTagsResult> addSiteTags( long siteId, int productId, List<SiteTagsResult> tags ) throws Exception
    {
        String url = serverUrl + String.format( URI_SITE_TAGS_ADD, siteId, productId );

        return putJsonArray( url, tags, SiteTagsResult.class );
    }
    
    /**
     * 更新站点标签
     * @param siteId
     * @param productId
     * @param tags
     * @throws Exception
     */
    public void updateSiteTags( long siteId, int productId, List<SiteTagsResult> tags ) throws Exception
    {
        String url = serverUrl + String.format( URI_SITE_TAGS_UPDATE, siteId, productId );

        super.postJsonContent( url, tags );
    }
    
    /**
     * 删除站点标签
     * @param siteId
     * @param productId
     * @param tagId
     * @throws Exception
     */
    public void deleteSiteTags( long siteId, int productId, long tagId ) throws Exception
    {
        String url = serverUrl + String.format( URI_SITE_TAGS_DELETE, siteId, productId, tagId );

        super.deleteContent( url );
    }

    public List<UmsOrgInfo> getChildOrgs( int id, String scope, String type ) throws Exception
    {
        log.debug( "get child Orgs by id:" + id );

        String url = serverUrl + String.format( URI_GET_CHILD_ORGS, id, scope, type );

        return getArray( url, UmsOrgInfo.class );
    }

    /**
     * 获取当前org的族谱
     * 
     * @param id
     * @return
     * @throws ServiceException
     */
    public List<String> getParentOrgNames( int id ) throws ServiceException
    {

        String url = serverUrl + String.format( URI_ORG_PATH_QUERY, id );

        try
        {
            return postJsonArray( url, null, String.class );

        }
        catch ( ServiceException e )
        {
            throw new ServiceException( ServiceException.ERROR_RESULT, "getParentOrgNames" );
        }
    }

    /**
     * 获取一批组织信息
     * 
     * @param ids
     * @return
     * @throws ServiceException
     */
    public List<UmsOrgInfo> getOrgBatch( List<Integer> ids ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_ORG_BATCH_QUERY );

        return postJsonArray( url, ids, UmsOrgInfo.class );

    }

    public List<UmsOrgInfo> getOrgsByCustomerCode( String customerCode ) throws Exception
    {
        log.debug( "get org info by customerCode:" + customerCode );

        String url = serverUrl + String.format( URI_GET_ORG_BY_CUSTOMERCODE, customerCode );

        return this.getArray( url, UmsOrgInfo.class );

    }

    public UmsOrgInfo getOrg( int id ) throws Exception
    {
        log.debug( "get org info by id:" + id );

        String url = serverUrl + String.format( URI_GET_ORG, id );

        return this.getObject( url, UmsOrgInfo.class );

    }

    public Integer createLdap( LdapConfCreateArgs args ) throws ServiceException
    {
        String url = ldapServerUrl + URI_LDAP_CREATE;
        String ldapId = postJsonContent( url, args );

        if ( null != ldapId )
        {
            return Integer.parseInt( ldapId );
        }

        return null;
    }

    public void deleteLdap( int siteId, int ldapId ) throws ServiceException
    {
        String url = ldapServerUrl + String.format( URI_LDAP_DELETE, siteId, ldapId );

        deleteContent( url );
    }

    public void editLdap( LdapConfEditArgs args ) throws ServiceException
    {
        String url = ldapServerUrl + URI_LDAP_EDIT;

        putJsonObject( url, args, null );
    }

    public LdapConfDetailInfo getLdap( int ldapId ) throws ServiceException
    {
        String url = ldapServerUrl + String.format( URI_LDAP_GET, ldapId );

        return getObject( url, LdapConfDetailInfo.class );
    }

    public List<String> getLdapClass( LdapConfGetClassArgs args ) throws ServiceException
    {
        String url = ldapServerUrl + URI_LDAP_GET_CLASS;

        return postJsonArray( url, args, String.class );
    }

    public List<String> getLdapAttribute( LdapConfGetAttributeArgs args ) throws ServiceException
    {
        String url = ldapServerUrl + URI_LDAP_GET_ATTRIBUTE;

        return postJsonArray( url, args, String.class );
    }

    public List<LdapConfBriefInfo> getLdapList( int siteId ) throws Exception
    {
        String url = ldapServerUrl + String.format( URI_LDAP_GET_LIST, siteId );
        
        try
		{
        	return getArray( url, LdapConfBriefInfo.class );
		}
		catch ( ServiceException e )
		{
			if ( StringUtils.isNotEmpty( e.getContent() ) && e.getMessage().contains( "404" ) )
			{
				return null;
			}
			
			throw e;
		}
    }

    public UserProductDTO getUserProduct( long userId, Integer productId ) throws ServiceException
    {
        if ( null == productId )
        {
            productId = UC_PRODUCT_ID;
        }

        String url = serverUrl + String.format( URI_USER_GET_PRODUCT, userId, productId );

        try
        {
            return getObject( url, UserProductDTO.class );
        }
        catch ( ServiceException e )
        {
            if ( e.getStatusCode() == 404 )
            {
                return null;
            }
            else
            {
                throw e;
            }
        }
    }
    
    public Boolean setUserProduct(long siteId, long userId, int productId, int umsBeeStatus ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_USER_SET_PRODUCT, productId, umsBeeStatus, siteId, userId );
        
        String ret = this.postTextContent( url, "", POST_CONTTYPE );
        
        return Boolean.valueOf( ret ) ? true : false;
    }
    
    public UmsBindThirdPartyResult bindThirdParty( BindThirdPartyArgs args ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_BIND_THIRDPARTY );

        return postJsonObject( url, args, UmsBindThirdPartyResult.class );
    }
    
    public UmsUnBindThirdPartyResult unbindThirdParty( String tpId, int tpType, int userId ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_UNBIND_THIRDPARTY, tpId, tpType, userId );

        return postJsonObject( url, null, UmsUnBindThirdPartyResult.class );
    }
    
    public UmsModifyThirdPartyStatusResult modifyThirdPartyStatus( long id, int status ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_MODYFIY_THIRDPARTY_STATUS, id, status );

        return postJsonObject( url, null, UmsModifyThirdPartyStatusResult.class );
    }
    
    public UmsGetThirdPartyResult getThirdParty( long userId ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_GET_THIRDPARTY, userId );
        
        return getObject( url, UmsGetThirdPartyResult.class );
    }
    
    public UmsSiteInfo getSiteByUrl(String siteUrl) throws ServiceException
    {
    	String url = serverUrl + String.format(URI_SITE_URL_GET, siteUrl);
    	return getObject( url, UmsSiteInfo.class );
    }

    public List<UmsOrgInfo> searchOrg( String keyWord, String customerCode ) throws Exception
    {
        String url = serverUrl + String.format( URI_ORG_SEARCH_BY_KEYWORD, customerCode );
        UmsOrgInfoResponseBodyArray ret = null;
        ret = postTextObject(url, keyWord, "application/text", UmsOrgInfoResponseBodyArray.class);
        if(ret != null){        	
        	return ret.body;
        };
        return null;
    }

	public SetOrgAuthTypeResult setOrgAuthType( Integer orgId, UmsOrgAuthType authType, UmsOrgAuthScope scope,
			Integer ldapId ) throws ServiceException
	{
		String url = serverUrl
				+ String.format( URI_ORG_AUTH, orgId, authType.getValue(), scope.getValue(),
						UmsOrgAuthType.LDAP.equals( authType ) ? ( null == ldapId ? 0 : ldapId ) : 0 );

		return postJsonObject( url, null, SetOrgAuthTypeResult.class );
	}

	public UmsOrgInfo getOrgDetails( Integer orgId ) throws ServiceException
	{
		String url = serverUrl + String.format( URI_ORG_DETAILS, orgId );

		return getObject( url, UmsOrgInfo.class );
	}
	
	/**
	 * 用户离职处理 
	 * 1、解除用户与组织关系 
	 * 2、删除常用联系人数据
	 * 
	 * @param userIds 离职员工id列表
	 * @return 处理结果
	 * @throws ServiceException ums服务异常
	 */
    public boolean userUnbind( List<Integer> userIds, Long siteId ) throws ServiceException
    {
        String result = postJsonContent( serverUrl + String.format( URI_USER_UNBIND, "true", siteId ), userIds );

        return Boolean.parseBoolean( result );
    }

    /**********************************
     * * PBX ******************************** 绑定用户pbx信息
     * 
     * @param userId
     * @param pbxNumber
     *            PBX电话号码
     * @param Status
     * @return
     * @throws ServiceException
     */
    public UmsPbxBindResult umsBindUserPbx( long userId, String pbxNumber ) throws ServiceException
    {
        getUms3rdStatusReturn rlt = umsGetUserPbx( userId );

        boolean isModify = false;

        if ( rlt != null && rlt.status == 1 && rlt.body != null && !rlt.body.isEmpty() )
        {
            for ( getUms3rdStatusReturn.statusBody statusBody : rlt.body )
            {
                if ( UmsService.THIRD_PARTY_PBX_TYPE == statusBody.tpType )
                {
                    isModify = true;

                    String url = serverUrl
                            + String.format( URI_PBX_USER_CHANGE_THIRD_STATUS, statusBody.id, 1 );

                    postJsonObject( url, null, switchStatusReturn.class );
                }
            }

        }

        if ( isModify )
        {
            return new UmsPbxBindResult();
        }

        return umsBindUserPbx( userId, pbxNumber, 1 );

    }

    public UmsPbxBindResult umsBindUserPbx( long userId, String pbxNumber, int Status ) throws ServiceException
    {
        bindPbxObject pbx = new bindPbxObject();
        pbx.userId = userId;
        pbx.tpId = pbxNumber;
        pbx.tpStatus = Status;

        String url = serverUrl + String.format( URI_PBX_USER_BIND_THIRD_STATUS );

        return postJsonObject( url, pbx, UmsPbxBindResult.class );
    }

    public UmsPbxunBindResult umsUnbindUserPbx( long userId, String pbxNumber ) throws ServiceException
    {
        unbindPbxObject pbx = new unbindPbxObject();
        pbx.userId = userId;
        pbx.tpId = pbxNumber;

        String url = serverUrl + String.format( URI_PBX_USER_UNBIND_THIRD_STATUS, pbxNumber, userId );

        return postJsonObject( url, null, UmsPbxunBindResult.class );
    }

    public switchStatusReturn umsSwitchUserPbxStatus( long userId, int status ) throws Exception
    {
        getUms3rdStatusReturn rlt = umsGetUserPbx( userId );
        if ( rlt == null || rlt.status != 1 || rlt.body == null || rlt.body.size() < 1 )
        {
            return null;
        }

        for ( getUms3rdStatusReturn.statusBody statusBody : rlt.body)
        {
            if ( UmsService.THIRD_PARTY_PBX_TYPE == statusBody.tpType )
            {
                String url = serverUrl + String.format( URI_PBX_USER_CHANGE_THIRD_STATUS, statusBody.id, status );
                
                return postJsonObject( url, null, switchStatusReturn.class );
            }
        }
        
        return null;

    }

    public getUms3rdStatusReturn umsGetUserPbx( long userId ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_PBX_USER_QUERY_THIRD_STATUS, userId );

        return getObject( url, getUms3rdStatusReturn.class );
    }

	public void sortAccount( Integer orgId, List<Integer> userIds ) throws ServiceException
	{
		String url = serverUrl + String.format( URI_ORG_USER_SORT, orgId );

		try
		{
			postJsonObject( url, userIds, null );
		}
		catch ( ServiceException e )
		{
			if ( ServiceException.ERROR_FORMAT != e.getErrorType() )
			{
				throw e;
			}
		}
	}

    /**
     * 分页查询离职人员
     * 
     * @param pageNum
     * @return
     * @throws ServiceException
     */
    public QuitUserReturn getQuitUser( int pageNum, int pageSize, int siteId ) throws ServiceException
    {

        String url = serverUrl + String.format( URI_QUERY_QUIT_USERS, siteId, pageNum, pageSize );

        return getObject( url, QuitUserReturn.class );
    }

    /**
     * 批量标记离职人员已清理
     * 
     * @param pageNum
     * @return
     * @throws ServiceException
     */
    public void markQuitUser( List<Integer> userIds, int siteId ) throws ServiceException
    {

        String url = serverUrl + String.format( URI_MARK_QUIT_USER, siteId );

        postJsonObject( url, userIds, null );
        
    }

    /**
     * 根据用户扩展属性获取用户信息
     * @param siteId
     * @param attrName
     * @param attrValue
     * @return
     * @throws ServiceException
     */
    public UserByAttributeReturn userByAttr( int siteId, String attrName, String attrValue ) throws ServiceException
    {
        String url = serverUrl + String.format( URI_GET_USER_BY_ATTR, siteId );
        Map<String, String> param = new HashMap<String, String>();
        param.put( "attrName", attrName );
        param.put( "attrValue", attrValue );
        return postJsonObject( url, param, UserByAttributeReturn.class );
    }
}
