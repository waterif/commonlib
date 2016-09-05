package com.quanshi.uclib.service;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import name.rex.commlib.format.JSONHelper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.quanshi.uclib.service.dataobject.UccBatchLogoutResult;

public class UccServerServiceTest
{
	private UccServerService uccServerService = null;
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
		uccServerService = new UccServerService("http://testcloud3.quanshi.com/");
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testUserLogout()
	{
		
	}

	@Test
	public void testUpdateTags()
	{
		fail( "Not yet implemented" );
	}

	@Test
	public void testBatchUserLogout()
	{
		List<Integer> users = new ArrayList<Integer>();
		users.add( 62829358 );
		
		try
		{
			List<UccBatchLogoutResult> res = uccServerService.batchUserLogout( users );
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testLogoutBySite()
	{
		try
		{
			List<UccBatchLogoutResult> res = uccServerService.logoutBySite( 72112 );
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testnotyfy()
	{
		try
		{
			 uccServerService.notyfy( 72112,62829358,1 );
//			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
