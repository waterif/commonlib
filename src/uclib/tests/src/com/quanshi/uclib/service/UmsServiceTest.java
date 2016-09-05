package com.quanshi.uclib.service;

import java.util.ArrayList;
import java.util.List;

import name.rex.commlib.format.JSONHelper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.quanshi.uclib.service.dataobject.LdapConfDetailInfo;
import com.quanshi.uclib.service.dataobject.LdapConfGetClassArgs;
import com.quanshi.uclib.service.dataobject.SetOrgAuthTypeResult;
import com.quanshi.uclib.service.dataobject.UmsOrgAuthScope;
import com.quanshi.uclib.service.dataobject.UmsOrgAuthType;
import com.quanshi.uclib.service.dataobject.UmsOrgInfo;
import com.quanshi.uclib.service.dataobject.UmsUserInfo;
import com.quanshi.uclib.service.dataobject.UmsThirdPartyObjects.UmsGetThirdPartyResult;
import com.quanshi.uclib.service.dataobject.UserByAttributeReturn;
import com.quanshi.uclib.service.dataobject.UserProductDTO;

public class UmsServiceTest
{
	UmsService mmsService = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{
		mmsService = new UmsService("http://192.168.28.173:8081/umsapi/", "http://192.168.39.20:8091/");
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testAddUser2Org()
	{
		int userId = 62051309;
		int orgId = 54169;
		try
		{
			mmsService.addUser2Org( userId, orgId );
		}
		catch ( ServiceException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testaddOrg()
	{
		try
		{
			int id = mmsService.addOrg( null, "晶科能源有限公司", "000092", 3 );
			System.out.println(id);
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testdeleteOrg()
	{
		try
		{
			mmsService.deleteOrg( 96457 );
			System.out.println();
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testuserByName()
	{
		try
		{
			UmsUserInfo user = mmsService.userByName("test_0630_6@quanshi.com");
			System.out.println(JSONHelper.toJSONString(user));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void getLdap()
	{
		try
		{
			LdapConfDetailInfo ldap = mmsService.getLdap(225);
			System.out.println(JSONHelper.toJSONString( ldap ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void getLdapClass()
	{
		LdapConfGetClassArgs args = new LdapConfGetClassArgs();
		args.hostname = "192.168.12.178";
		args.port = "389";
		args.basedn = "OU=maytwo,Dc=haier,Dc=com";
		args.admindn = "cn=Administrator,cn=Users,Dc=haier,Dc=com";
		args.adminpassword  = "gathink";
		args.servertype = "1";
		
		try
		{
			List<String> res = mmsService.getLdapClass( args );
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void deleteLdap()
	{
		
		try
		{
			 mmsService.deleteLdap( 72112, 224 );
//			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void setOrgAuthType()
	{
		try
		{
			SetOrgAuthTypeResult res = mmsService.setOrgAuthType( 93324, UmsOrgAuthType.LDAP, UmsOrgAuthScope.ALL, null );
//			SetOrgAuthTypeResult res = mmsService.setOrgAuthType( 93324, UmsOrgAuthType.COMMON, UmsOrgAuthScope.ALL, 202 );
//			SetOrgAuthTypeResult res = mmsService.setOrgAuthType( 96465, UmsOrgAuthType.COMMON, UmsOrgAuthScope.SELF, 0 );
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void getOrgDetails()
	{
		try
		{
			UmsOrgInfo res = mmsService.getOrgDetails( 54169 );
//			UmsOrgInfo res = mmsService.getOrgDetails( 96465 );
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void userById()
	{
		try
		{
			UmsUserInfo res = mmsService.userById(63672543);
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void modifyPass()
	{
		long userId = 63524326;
		String password = "11111111";
		try
		{
			mmsService.modifyPass( userId, password );
//			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void searchUser()
	{
		String keyWord = "test";
		String customerCode = "000092";
		List<Integer> orgIds = new ArrayList<Integer>();
//		orgIds.add( 96504 );
//		orgIds.add( 93206 );
		orgIds.add( 96425 );
		try
		{
			List<UmsUserInfo> res = mmsService.searchUser( keyWord, customerCode,orgIds );
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void getChildOrgs()
	{
		 int id = 93206;
		 String scope = "subtree";
		 String type = "3";
		try
		{
			List<UmsOrgInfo> res = mmsService.getChildOrgs( id, scope,type );
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void getOrgAccounts()
	{
		int id = 96512;
		try
		{
			List<UmsUserInfo> res = mmsService.getOrgAccounts( id );
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void getThirdParty()
	{
		int id = 63505004;
		try
		{
			UmsGetThirdPartyResult res = mmsService.getThirdParty(id);
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void sortAccount()
	{
		int orgId = 96569;
		List<Integer> userIds = new ArrayList<Integer>();
		userIds.add( 63505179 );
		userIds.add( 63505054 );
		userIds.add( 63505132 );
		userIds.add( 63505178 );
		userIds.add( 63505180 );
		userIds.add( 63505051 );
		try
		{
			mmsService.sortAccount( orgId, userIds );
//			System.out.println( JSONHelper.toJSONString( res ) );
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println( "--------" + e.getMessage() );
		}
	}
	
	@Test
	public void getOrgAccounts2()
	{
		int orgId = 96569;
		try
		{
			List<UmsUserInfo> res = mmsService.getOrgAccounts( orgId );
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void getSubOrgDetails()
	{
		try
		{
			UmsOrgInfo res = mmsService.getOrgDetails( 96466 );
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void getChildOrgs2()
	{
		try
		{
			List<UmsOrgInfo> res = mmsService.getChildOrgs(54169, "nextlevel","1,2,3,4,5");
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void findOrgByNames()
	{
		String customerCode = "000092";
		List<String> names = new ArrayList<String>();
		names.add( "qinyantest" );
		names.add( "" );
		names.add( "" );
		try
		{
			UmsOrgInfo res = mmsService.findOrgByNames(customerCode, names);
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
    @Test
    public void userUnbing()
    {
        List<Integer> userIds = new ArrayList<Integer>();
        userIds.add( 63504719 );
        long siteId = 75437;

        try
        {
            boolean res = mmsService.userUnbind( userIds, siteId );
            System.out.println( JSONHelper.toJSONString( res ) );
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println( "--------" + e.getMessage() );
        }
    }
	
	@Test
	public void userByName()
	{
		try
		{
			UmsUserInfo res = mmsService.userByName("wu_0824_01@quanshi.com");
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void getOrgInfoByUserId()
	{
		try
		{
			List<UmsOrgInfo> res = mmsService.getOrgInfoByUserId(63508299);
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
	@Test
	public void getParentOrgNames()
	{
		int orgId = 96441;
		try
		{
			List<String> res = mmsService.getParentOrgNames( orgId );
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------" + e.getMessage());
		}
	}
	
    @Test
    public void userByAttr()
    {
        int siteId = 72112;
        String attrName = "pbx_extension";
        String attrValue = "22130";
        try
        {
            UserByAttributeReturn res = mmsService.userByAttr( siteId, attrName, attrValue );
            System.out.println( JSONHelper.toJSONString( res ) );
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println( "--------" + e.getMessage() );
        }
    }
	
	@Test
	public void searchUser2()
	{
	    String keyWord = "测试" ;
	    String customerCode = "000092";
	    try
	    {
	        List<UmsUserInfo> res = mmsService.searchUser(keyWord, customerCode);
	        System.out.println(JSONHelper.toJSONString( res ));
	    }
	    catch ( Exception e )
	    {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        System.out.println("--------" + e.getMessage());
	    }
	}
	
    @Test
    public void setUser2Org()
    {
        int userId = 63506143;
        int toOrgId = 96569;
        try
        {
            mmsService.setUser2Org( userId, toOrgId );
            // System.out.println(JSONHelper.toJSONString( res ));
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println( "--------" + e.getMessage() );
        }
    }
    
    @Test
    public void addUser2Org()
    {
        int userId = 63506143;
        int toOrgId = 96570;
        try
        {
            mmsService.addUser2Org( userId, toOrgId );
            // System.out.println(JSONHelper.toJSONString( res ));
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println( "--------" + e.getMessage() );
        }
    }
    
    @Test
    public void getUserProduct()
    {
        int userId = 63672543;
        int productId = 20;
        try
        {
            UserProductDTO res = mmsService.getUserProduct( userId, productId );
             System.out.println(JSONHelper.toJSONString( res ));
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println( "--------" + e.getMessage() );
        }
    }

}
