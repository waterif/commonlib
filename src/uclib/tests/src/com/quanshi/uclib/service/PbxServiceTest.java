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

import com.quanshi.uclib.service.dataobject.PbxAccessAuth;
import com.quanshi.uclib.service.dataobject.PbxCloseArgs;
import com.quanshi.uclib.service.dataobject.PbxCloseReturn;
import com.quanshi.uclib.service.dataobject.PbxOpenArgs;
import com.quanshi.uclib.service.dataobject.PbxOpenReturn;
import com.quanshi.uclib.service.dataobject.PbxSiteOpenOrCloseArgs;
import com.quanshi.uclib.service.dataobject.PbxSiteOpenOrCloseReturn;
import com.quanshi.uclib.service.dataobject.PbxUserNames;

public class PbxServiceTest
{
	PbxAccessAuth      pbxAuth;
	private String     pbxServer = "";
	PbxService pbxService;

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
		pbxAuth = new PbxAccessAuth();
		pbxServer = "https://webapi.qs.easipbx.com:8300";
//		pbxServer = "https://webapi.easipbx.com:9443";
        pbxAuth.auth.token = "cUCXiusVww";
        pbxAuth.auth.developerKey = "b864e881ec30da85ecs3c47ied25b58ba7cf";
        
        pbxService = new PbxService( pbxAuth, pbxServer,"" );
        
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testOpen()
	{
		
		
		PbxOpenArgs openArg = new PbxOpenArgs();
		
		openArg.userOptions.userFlag = "72112";

		List<PbxUserNames> userNames = new ArrayList<PbxUserNames>();
		
		PbxUserNames userName = new PbxUserNames();
		userName.userName = "62056329";
		userName.email = "62051309@quanshi.com";
		userName.firstName = "62051309";
		userName.lastName = "62051309";
		userName.outsideOrgId = "72112";
		userName.outsideExt = "6501";
		
		userNames.add( userName );
		openArg.userNames = userNames;
		
        try
		{
			PbxOpenReturn res = pbxService.open( openArg );
			
			System.out.println( JSONHelper.toJSONString( res ) );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
        
	}

	@Test
	public void testClose()
	{
		PbxCloseArgs closeArgs = new PbxCloseArgs();

		List<String> userNames = new ArrayList<String>();
		userNames.add( "62056329" );

		closeArgs.userNames = userNames;

		try
		{
			PbxCloseReturn res = pbxService.close( closeArgs );

			System.out.println( JSONHelper.toJSONString( res ) );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void siteOpenOrClose()
	{
		PbxSiteOpenOrCloseArgs siteOpenOrCloseArgs = new PbxSiteOpenOrCloseArgs();
		siteOpenOrCloseArgs.outsideOrgId = String.valueOf( 72112 );
		siteOpenOrCloseArgs.name = String.valueOf( 72112 );
		siteOpenOrCloseArgs.action = 1;
		try
		{
			PbxSiteOpenOrCloseReturn res = pbxService.siteOpenOrClose( siteOpenOrCloseArgs );
			if ( null != res )
			{
				System.out.println( res.code );
				System.out.println( res.status );
				System.out.println( res.message );
				System.out.println( JSONHelper.toJSONString( res ) );
				
			}
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
