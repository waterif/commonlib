package com.quanshi.uclib.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.quanshi.uclib.service.dataobject.YunPanEntInfoRes;
import com.quanshi.uclib.service.dataobject.YunPanEntTokenRes;
import com.quanshi.uclib.service.dataobject.YunPanInfo;
import com.quanshi.uclib.service.dataobject.YunPanMemberInfo;
import com.quanshi.uclib.service.dataobject.YunPanRes;

import name.rex.commlib.format.JSONHelper;
import name.rex.commlib.net.HttpWrapper;

public class YunPanServiceTest
{
	private YunPanService yunPanService = null;

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
		yunPanService = new YunPanService( "http://yk3-api.goukuai.cn", "http://yk3-api-ent.goukuai.cn", "gwrPNsdWB09z69bJ05CxMHzSDU",
				"JfaDxE98LDpYXpIdRQ8hndDlvc" );
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testCreateEnt()
	{
		YunPanInfo yunPanInfo = new YunPanInfo();
		yunPanInfo.outId = String.valueOf( "75751" );
		yunPanInfo.siteUrl = "http://oncloud.quanshi.com/";
		YunPanRes res;
		try
		{
			res = yunPanService.createEnt( yunPanInfo );
			System.out.println( res.errorCode );
			System.out.println( res.errorMsg );
//			Assert.assertEquals("40098", res.errorCode);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateEnt2()
	{
		YunPanInfo yunPanInfo = new YunPanInfo();
		yunPanInfo.outId = String.valueOf( "72386" );
		yunPanInfo.siteUrl = "http://devcloud.quanshi.com/";
		YunPanRes res;
		try
		{
			res = yunPanService.createEnt( yunPanInfo );
			System.out.println( res.errorMsg );
			Assert.assertEquals("40098", res.errorCode);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testOrderSubscribe()
	{
		YunPanInfo yunPanInfo = new YunPanInfo();
		yunPanInfo.outId = String.valueOf( "75751" );
		yunPanInfo.memberCount = 10;
		yunPanInfo.month = 10;
		yunPanInfo.space = 1024;
		
		YunPanRes res;
		try
		{
			res = yunPanService.orderSubscribe( yunPanInfo );
			System.out.println( res.errorMsg );
			Assert.assertEquals("0", res.errorCode);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOrderSubscribe2()
	{
		YunPanInfo yunPanInfo = new YunPanInfo();
		yunPanInfo.outId = String.valueOf( "72386" );
		yunPanInfo.memberCount = 0;
		yunPanInfo.month = 0;
		yunPanInfo.space = 0;
		
		YunPanRes res;
		try
		{
			res = yunPanService.orderSubscribe( yunPanInfo );
			System.out.println( res.errorMsg );
			Assert.assertEquals("0", res.errorCode);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testOrderUpgrade()
	{
		YunPanInfo yunPanInfo = new YunPanInfo();
		yunPanInfo.outId = String.valueOf( "72386" );
		yunPanInfo.memberCount = 10;
		yunPanInfo.space = 1024;
		
		YunPanRes res;
		try
		{
//			HttpWrapper.setProxy( "192.168.21.248", 3128, "http" );
			
			res = yunPanService.orderUpgrade( yunPanInfo );

//			HttpWrapper.clearProxy();
			
			System.out.println( res.errorMsg );
			Assert.assertEquals("0", res.errorCode);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOrderUpgrade2()
	{
		YunPanInfo yunPanInfo = new YunPanInfo();
		yunPanInfo.outId = String.valueOf( "72386" );
		yunPanInfo.memberCount = 0;
		yunPanInfo.space = 0;
		
		YunPanRes res;
		try
		{
//			HttpWrapper.setProxy( "192.168.23.164", 8080, "http" );
//			HttpWrapper.setProxy( "192.168.21.248", 3128, "http" );
			
			
			res = yunPanService.orderUpgrade( yunPanInfo );
			
//			HttpWrapper.clearProxy();
			
			
			System.out.println( res.errorCode );
			System.out.println( res.errorMsg );
			Assert.assertEquals("0", res.errorCode);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	@Test
	public void unsubscribe()
	{
		YunPanInfo yunPanInfo = new YunPanInfo();
		yunPanInfo.outId = String.valueOf( "72386" );
		
		YunPanRes res;
		try
		{
			res = yunPanService.unsubscribe( yunPanInfo );
			System.out.println( JSONHelper.toJSONString( res ) );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOrderRenew()
	{
	    YunPanInfo yunPanInfo = new YunPanInfo();
	    yunPanInfo.outId = String.valueOf( "72386" );
	    yunPanInfo.month = 12;
	    
	    YunPanRes res;
	    try
	    {
	        res = yunPanService.orderRenew( yunPanInfo );
	        System.out.println( res.errorMsg );
	        Assert.assertEquals("0", res.errorCode);
	    }
	    catch ( Exception e )
	    {
	        e.printStackTrace();
	    }
	}
	
	@Test
	public void testOrderRenew2()
	{
		YunPanInfo yunPanInfo = new YunPanInfo();
		yunPanInfo.outId = String.valueOf( "72386" );
		yunPanInfo.month = 1;
		
		YunPanRes res;
		try
		{
			res = yunPanService.orderRenew( yunPanInfo );
			System.out.println( res.errorMsg );
			Assert.assertEquals("0", res.errorCode);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOrderRenew3()
	{
		YunPanInfo yunPanInfo = new YunPanInfo();
		yunPanInfo.outId = String.valueOf( "72386" );
		yunPanInfo.month = 0;
		
		YunPanRes res;
		try
		{
			res = yunPanService.orderRenew( yunPanInfo );
			System.out.println( res.errorMsg );
			Assert.assertEquals("40003", res.errorCode);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void getEntInfo()
	{
	    
	    YunPanEntInfoRes res;
	    try
	    {
	        res = yunPanService.getEntInfo( 72112 );
	        System.out.println( JSONHelper.toJSONString( res ) );
	    }
	    catch ( Exception e )
	    {
	        e.printStackTrace();
	    }
	}
	
	@Test
	public void getEntToken()
	{
	    
	    YunPanEntTokenRes res;
	    try
	    {
	        res = yunPanService.getEntToken( 72112 );
	        System.out.println( JSONHelper.toJSONString( res ) );
	    }
	    catch ( Exception e )
	    {
	        e.printStackTrace();
	    }
	}
	
	@Test
	public void addMember()
	{
	    YunPanMemberInfo member = new YunPanMemberInfo();
	    
	    member.id = "63618866";
	    member.account = "test_0729_61@quanshi.com";
	    member.memberName = "test_0729_61";
	    
	    String token = "80ba0def90e4b35630b5f0663bac25d9";
	    
	    YunPanRes res;
	    try
	    {
	        res = yunPanService.addMember( member, token );
	        System.out.println( JSONHelper.toJSONString( res ) );
	    }
	    catch ( Exception e )
	    {
	        e.printStackTrace();
	    }
	}
	
	@Test
	public void addGroupMember()
	{
	    YunPanMemberInfo member = new YunPanMemberInfo();
	    
	    member.id = "63662282";
	    
	    String token = "0917999914c0f901490e125d6f5a00d7";
	    
	    YunPanRes res;
	    try
	    {
	        res = yunPanService.addGroupMember( member, token );
	        System.out.println( JSONHelper.toJSONString( res ) );
	    }
	    catch ( Exception e )
	    {
	        e.printStackTrace();
	    }
	}
	
	@Test
	public void delMember()
	{
//	    YunPanMemberInfo member = new YunPanMemberInfo();
//	    
//	    member.id = "63613932";
//	    member.account = "test_0728_01@quanshi.com";
//	    member.memberName = "test_0728_01";
	    
	    String token = "80ba0def90e4b35630b5f0663bac25d9";
	    
	    List<Integer> userIds = new ArrayList<Integer>();
	    userIds.add( 63613932 );
	    userIds.add( 63613933 );
	    
	    YunPanRes res;
	    try
	    {
	        res = yunPanService.delMember( userIds, token );
	        System.out.println( JSONHelper.toJSONString( res ) );
	    }
	    catch ( Exception e )
	    {
	        e.printStackTrace();
	    }
	}

}
