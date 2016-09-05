package com.quanshi.uclib.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import name.rex.commlib.net.HttpWrapper;

public class UcAdminService extends JsonResultService
{
    //////////////////////////////////////////////////////////////////////
    public static class AdminInfo 
    {
        public String customerCode;
        public int siteId;
    }

    public static class AppInfo 
    {
        public int      id;
        public int      siteId;
        public String   app_title;
        public String   authorization_code;
        public int      isMessage;
        public int      status;
    }

    public static final int FUNCTION_STATUS_CLOSE = 0;
    public static final int FUNCTION_STATUS_OPEN  = 3;

    public static class AccountInfoBase
    {
        public String loginname;        //必选
    	public String lastname;         //必选
    	public String firstname;        //必选
    	public String displayname;
    	public String namepinyin;	
    	public String position;	
    	public String mobile;
    	public String email;
    	public String country;
    	public String officephone;
        public String pbxNumber;

        public Integer beeStatus;
        public Integer pbxStatus;
        public Integer confStatus;
        public Integer confPhoneStatus;
        public Integer callStatus;
        public Integer callPhoneStatus;
        public Integer yunpanStatus;
        public Integer sendDocInChat;
        public Integer inviteStatus;

        public void trim()
        {
            loginname 	= ( null != loginname )   ? loginname.trim() : null;
    	    lastname 	= ( null != lastname )    ? lastname.trim() : null;
    	    firstname 	= ( null != firstname )   ? firstname.trim() : null;
    	    displayname = ( null != displayname ) ? displayname.trim() : null;
    	    namepinyin 	= ( null != namepinyin )  ? namepinyin.trim() : null;	
    	    position 	= ( null != position )    ? position.trim() : null;	
    	    mobile 	    = ( null != mobile )  ? mobile.trim() : null;
    	    email 	    = ( null != email )   ? email.trim() : null;
    	    country 	= ( null != country ) ? country.trim() : null;
    	    officephone = ( null != officephone ) ? officephone.trim() : null;
            pbxNumber   = ( null != pbxNumber ) ? pbxNumber.trim() : null;
        }
    }

    public static class AccountCreateInfo extends AccountInfoBase
    {	
    	public List<String> departments;     //必选

        public void trim()
        {
            super.trim();

            if ( null != departments )
            {
                List<String> tmpDepartments = new ArrayList<String>();

                for( String d: departments )
                {
                    if ( null != d )
                    {
                        continue;
                    }

                    d = d.trim();
                    if ( d.isEmpty() )
                    {
                        continue;
                    }

                    tmpDepartments.add( d );
                }

                departments = tmpDepartments;
            }
        }
    }

    public static class AccountUpdateInfo extends AccountInfoBase
    {

    }

    public static class AccountQueryInfo extends AccountInfoBase
    {
    	public int id;
    	public Integer meetProductStatus;   // pc3.0产品状态，0-禁用，82-启用, 9-启用的试用账号
    	public Integer ucProductStatus;     // 蜜蜂产品状态，0-禁用，82-启用， 9-启用的试用账号
    }

    public static class AccountOrgQueryInfo
    {
        public String name;
        public List<String> departments;
    }

    public static class DepartmentEnumInfo
    {
        public List<String> parentDepart;
        public List<String> childrenDepart;
        public List<AccountQueryInfo> users;
    }

    public static class PbxConfig
    {
        public static class Proxy
        {
            public String host;
            public Integer port;
            public String scheme;
        }

        public String   developerKey;
        public String   token;
        public String   server;
        public String   web;
        public Boolean  enableProxy;
        public Proxy    proxy;

        public boolean isEnableProxy()
        {
            if ( null != enableProxy && ! enableProxy )
            {
                return false;
            }

            return true;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    private static Logger log = LoggerFactory.getLogger( UcAdminService.class );

    private final static String URL_PREFIX          = "/ucadmin";
    private final static String GETADMININFO_PATH   = URL_PREFIX + "/interface/config/getAdminInfo";
    private final static String ACCOUNT_CREATE      = URL_PREFIX + "/interface/account/create";
    private final static String ACCOUNT_UPDATE      = URL_PREFIX + "/interface/account/update";
    private final static String ACCOUNT_ENABLE      = URL_PREFIX + "/interface/account/enable";
    private final static String ACCOUNT_DISABLE     = URL_PREFIX + "/interface/account/disable";
    private final static String ACCOUNT_DELETE      = URL_PREFIX + "/interface/account/delete";
    private final static String ACCOUNT_QUERY       = URL_PREFIX + "/interface/account/getUserInfo";
    private final static String ACCOUNT_ORG_CHANGE  = URL_PREFIX + "/interface/account/changeOrganization";
    private final static String ACCOUNT_ORG_QUERY   = URL_PREFIX + "/interface/account/getAccountOrganization";
    private final static String ACCOUNT_MODIFYPASS  = URL_PREFIX + "/interface/account/modifyPassword";
    private final static String ORG_CREATE          = URL_PREFIX + "/interface/organization/create";
    private final static String ORG_UPDATE          = URL_PREFIX + "/interface/organization/update";
    private final static String ORG_DELETE          = URL_PREFIX + "/interface/organization/delete";
    private final static String ORG_MOVE            = URL_PREFIX + "/interface/organization/move";
    private final static String ORG_ENUM            = URL_PREFIX + "/interface/organization/getChildDepartsAndUsers";
    private final static String ORG_GETID           = URL_PREFIX + "/interface/organization/getOrgId";
    private final static String APP_GETINFO         = URL_PREFIX + "/interface/config/getAppInfo";
    private final static String SITE_GET_PBXCONFIG  = URL_PREFIX + "/interface/site/integration/getPbxConfig";

    public final static int ORG_ENUM_TYPE_ALL       = 0;
    public final static int ORG_ENUM_TYPE_ACCOUNT   = 1;
    public final static int ORG_ENUM_TYPE_DEPARTMENT = 2;
  
    private String serverUrl = null;

    public UcAdminService( String serverUrl )
    {
        super( "code", "data" );
        this.serverUrl = serverUrl;
    }

    public AdminInfo getAdminInfo( int userId ) 
        throws ServiceException
    {
        Map<String, String> params = new HashMap<String, String>();

        params.put( "user_id", String.format( "%d", userId ) );
        
        String url = HttpWrapper.buildURL( serverUrl + GETADMININFO_PATH, params );
        
        return getObject( url, AdminInfo.class );
    }

    public AppInfo getAppInfo( int siteId, int appId ) 
        throws ServiceException
    {
        Map<String, String> params = new HashMap<String, String>();

        params.put( "siteId", String.format( "%d", siteId ) );
        params.put( "app_id", String.format( "%d", appId ) );
        
        String url = HttpWrapper.buildURL( serverUrl + APP_GETINFO, params );
        
        return getObject( url, AppInfo.class );
    }

    public void createAccount( String customerCode, int siteId, List<AccountCreateInfo> accounts )
        throws ServiceException
	{
		String url = serverUrl + ACCOUNT_CREATE;
        Map<String, Object> params = new HashMap<String, Object>();

        params.put( "customerCode", customerCode );
        params.put( "siteId", siteId );
        params.put( "users", accounts );
		
        postJson( url, params );
	}

    public void createAccount( String customerCode, int siteId, AccountCreateInfo accountInfo )
        throws ServiceException
	{
        List<AccountCreateInfo> accounts = new ArrayList<AccountCreateInfo>();

        accounts.add( accountInfo );

        createAccount( customerCode, siteId, accounts );
    }
    
    public void updateAccount( String customerCode, int siteId, List<AccountUpdateInfo> accounts ) 
        throws ServiceException
    {
        String url = serverUrl + ACCOUNT_UPDATE;
        Map<String, Object> params = new HashMap<String, Object>();

        params.put( "customerCode", customerCode );
        params.put( "siteId", siteId );
        params.put( "users", accounts );
		
        postJson( url, params );
    }

    public void updateAccount( String customerCode, int siteId, AccountUpdateInfo accountInfo )
        throws ServiceException
	{
        List<AccountUpdateInfo> accounts = new ArrayList<AccountUpdateInfo>();

        accounts.add( accountInfo );

        updateAccount( customerCode, siteId, accounts );
    }

    public void setAccountStatus( String customerCode, int siteId, 
            List<Integer> userIds, boolean enable ) 
        throws ServiceException
    {
        String url = serverUrl + ( ( enable ) ? ACCOUNT_ENABLE : ACCOUNT_DISABLE );
        Map<String, Object> params = new HashMap<String, Object>();

        params.put( "customerCode", customerCode );
        params.put( "siteId", siteId );
        params.put( "userIds", userIds );

        postJson( url, params );
    }

    public void setAccountStatus( String customerCode, int siteId, 
            int userId, boolean enable ) 
        throws ServiceException
    {
        List<Integer> userIds = new ArrayList<Integer>();

        userIds.add( userId );
        setAccountStatus( customerCode, siteId, userIds, enable );
    }

    public void enableAccount( String customerCode, int siteId, 
            List<Integer> userIds )
        throws ServiceException
    {
        setAccountStatus( customerCode, siteId, userIds, true );
    }

    public void enableAccount( String customerCode, int siteId, int userId )
        throws ServiceException
    {
        setAccountStatus( customerCode, siteId, userId, true );
    }

    public void disableAccount( String customerCode, int siteId, 
            List<Integer> userIds )
        throws ServiceException
    {
        setAccountStatus( customerCode, siteId, userIds, false );
    }

    public void disableAccount( String customerCode, int siteId, int userId )
        throws ServiceException
    {
        setAccountStatus( customerCode, siteId, userId, false );
    }

    // delete
    public void deleteAccount( String customerCode, int siteId, 
            List<Integer> userIds ) throws ServiceException
    {
        String url = serverUrl + ACCOUNT_DELETE;
        Map<String, Object> params = new HashMap<String, Object>();

        params.put( "customerCode", customerCode );
        params.put( "siteId", siteId );
        params.put( "userIds", userIds );

        postJson( url, params );
    }

    public void deleteAccount( String customerCode, int siteId, int userId ) 
        throws ServiceException
    {
        List<Integer> userIds = new ArrayList<Integer>();

        userIds.add( userId );

        deleteAccount( customerCode, siteId, userIds );
    }

    // password
    public void modifyPassword( String customerCode, int siteId, 
            int userId, String password )
        throws ServiceException
    {
        String url = serverUrl + ACCOUNT_MODIFYPASS;
        Map<String, Object> params = new HashMap<String, Object>();

        params.put( "customerCode", customerCode );
        params.put( "siteId", siteId );
        params.put( "userId", userId );
        params.put( "password", password );

        postJson( url, params );
    }

    // getAccountInfo
    public List<AccountQueryInfo> getAccountInfoByName( String customerCode, int siteId, 
            List<String> loginNames ) throws ServiceException
    {
    	String url = serverUrl + ACCOUNT_QUERY;
        Map<String, Object> params = new HashMap<String, Object>();

        params.put( "customerCode", customerCode );
        params.put( "siteId", siteId );
        params.put( "loginNames", loginNames );

        return postJsonArray( url, params, AccountQueryInfo.class );
    }

    public Map<String, AccountQueryInfo> convertAccountInfoListToMap( List<AccountQueryInfo> accountInfos )
    {
        if ( null == accountInfos )
        {
            return null;
        }

        Map<String, AccountQueryInfo> res = new HashMap<String, AccountQueryInfo>();

        for( AccountQueryInfo accountInfo: accountInfos )
        {
            String name = accountInfo.loginname.trim().toLowerCase();

            res.put( name, accountInfo );
        }
        
        return res;
    }

    public AccountQueryInfo getAccountInfoByName( String customerCode, int siteId, 
            String loginName ) throws ServiceException
    {
        List<String> loginNames = new ArrayList<String>();

        loginNames.add( loginName );

        List<AccountQueryInfo> res = getAccountInfoByName( customerCode, siteId, loginNames );
        Map<String, AccountQueryInfo> mapRes = convertAccountInfoListToMap( res );

        if ( null == mapRes )
        {
            return null;
        }

        return mapRes.get( loginName.trim().toLowerCase() );
    }

    public void changeAccountDepartment( String customerCode, int siteId, 
            int userId, String[] newDepartments ) throws ServiceException
    {
    	String url = serverUrl + ACCOUNT_ORG_CHANGE;
        Map<String, Object> params = new HashMap<String, Object>();

		params.put( "customerCode", customerCode );
		params.put( "siteId", siteId );
		params.put( "id", userId );	
		params.put( "newDepartments", newDepartments );

        postJson( url, params );
    }

    public void changeAccountDepartment( String customerCode, int siteId, 
            int userId, List<String> newDepartments ) throws ServiceException
    {
        changeAccountDepartment( customerCode, siteId, userId, newDepartments.toArray( new String[0] ) );
    }

    public List<AccountOrgQueryInfo> getAccountOrgInfo( String customerCode, int siteId, int userId ) 
        throws ServiceException
    {
        String url = serverUrl + ACCOUNT_ORG_QUERY;
        Map<String, Object> params = new HashMap<String, Object>();

		params.put( "customerCode", customerCode );
		params.put( "siteId", siteId );
		params.put( "userId", userId );	

        return postJsonArray( url, params, AccountOrgQueryInfo.class );
    }
    
    public void createDepartment( String customerCode, int siteId, 
            String name,  String[] parentDepartments  ) throws ServiceException
    {
    	String url = serverUrl + ORG_CREATE;
        Map<String, Object> params = new HashMap<String, Object>();

        params.put( "customerCode", customerCode );
		params.put( "siteId", siteId );
		params.put( "name", name );	
		params.put( "parentDepartments", parentDepartments );

        postJson( url, params );
    }

    public void updateDepartment( String customerCode, int siteId, 
            List<String> departments, String newName ) throws ServiceException
    {
        String url = serverUrl + ORG_UPDATE;
        Map<String, Object> params = new HashMap<String, Object>();

        params.put( "customerCode", customerCode );
		params.put( "siteId", siteId );
		params.put( "name", newName );	
		params.put( "departments", departments );

        postJson( url, params );
    }

    public void deleteDepartment( String customerCode, int siteId,
            List<String> departments ) throws ServiceException
    {
        String url = serverUrl + ORG_DELETE;
        Map<String, Object> params = new HashMap<String, Object>();

        params.put( "customerCode", customerCode );
		params.put( "siteId", siteId );
		params.put( "departments", departments );

        postJson( url, params );
    }

    public void moveDepartment( String customerCode, int siteId,
            List<String> departments, List<String> newDepartments ) 
        throws ServiceException
    {
        String url = serverUrl + ORG_MOVE;
        Map<String, Object> params = new HashMap<String, Object>();

        params.put( "customerCode", customerCode );
		params.put( "siteId", siteId );
		params.put( "departments", departments );
        params.put( "newDepartments", newDepartments );

        postJson( url, params );
    }

    public Integer getDepartmentId( String customerCode, int siteId,
            List<String> departments ) throws ServiceException
    {
        String url = serverUrl + ORG_GETID;
        Map<String, Object> params = new HashMap<String, Object>();

        params.put( "customerCode", customerCode );
		params.put( "siteId", siteId );
		params.put( "departments", departments );	

        return postJsonInteger( url, params );
    }

    public List<DepartmentEnumInfo> enumDepartment( String customerCode, int siteId,
            List<String[]> listDepartments, int childType ) throws ServiceException
    {
        String url = serverUrl + ORG_ENUM;
        Map<String, Object> params = new HashMap<String, Object>();

        params.put( "customerCode", customerCode );
		params.put( "siteId", siteId );
		params.put( "departments", listDepartments );
        params.put( "childType", 
                ( ORG_ENUM_TYPE_ACCOUNT == childType ) ? "account" 
                    : ( ( ORG_ENUM_TYPE_DEPARTMENT == childType ) ? "department" : "all" ) );
        
        return postJsonArray( url, params, DepartmentEnumInfo.class );
    }

    public DepartmentEnumInfo enumDepartment( String customerCode, int siteId,
            String[] departments, int childType ) throws ServiceException
    {
        List<String[]> listDepartments = new ArrayList<String[]>();

        listDepartments.add( departments );

        List<DepartmentEnumInfo> res = enumDepartment( customerCode, siteId, listDepartments, childType );

        if ( null == res || res.size() <= 0 )
        {
            return null;
        }

        return res.get( 0 );
    }

    public PbxConfig getPbxConfig( int siteId ) throws ServiceException
    {
        String url = serverUrl + SITE_GET_PBXCONFIG;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put( "siteId", siteId );

        url = HttpWrapper.buildURL( url, params );

        return getObject( url, PbxConfig.class );
    }
}
