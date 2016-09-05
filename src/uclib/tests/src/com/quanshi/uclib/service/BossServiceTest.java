package com.quanshi.uclib.service;

import java.util.ArrayList;
import java.util.HashMap;

import name.rex.commlib.format.JSONHelper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.quanshi.uclib.service.dataobject.BossActiveAccountSellingProductsArg;
import com.quanshi.uclib.service.dataobject.SellingProductInfo;

public class BossServiceTest
{
	BossService bossService = null;
	
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
		bossService = new BossService("http://192.168.17.102:8880/");
	}

	@After
	public void tearDown() throws Exception
	{
	}
	
	@Test
	public void testActiveAccountSellingProduct()
	{
		BossActiveAccountSellingProductsArg arg = new BossActiveAccountSellingProductsArg();
		arg.templateUUID = "uctestc.quanshi.com";
		arg.callback = "http://testcloud3.quanshi.com/ucadmin/interface/account/callback";
		arg.createdTime = ( int ) (System.currentTimeMillis() / 1000);
		arg.creator = "ucadmin_refactor";
		arg.type = "update";
		arg.requestId = System.currentTimeMillis();
		System.out.println("requestId:" + arg.requestId);

		arg.customer = new BossActiveAccountSellingProductsArg.Customer();
		arg.customer.customerCode = "000092";

		arg.customer.contract = new BossActiveAccountSellingProductsArg.Customer.Contract();
		arg.customer.contract.id = 15844L;

		arg.customer.users = new ArrayList<BossActiveAccountSellingProductsArg.Customer.User>();

		BossActiveAccountSellingProductsArg.Customer.User user = new BossActiveAccountSellingProductsArg.Customer.User();
		user.id = 63505030;
		user.accountId = "119302";

		arg.customer.users.add( user );

		SellingProductInfo.Components sellingComponent = new SellingProductInfo.Components();
		sellingComponent.id = 22L;
		sellingComponent.name = "PC3.0";
		sellingComponent.status = 1;
		sellingComponent.property = new HashMap<String, String>();
		sellingComponent.property.put( "allowUserVoice", "0" );

		SellingProductInfo sellingProductInfo = new SellingProductInfo();
		sellingProductInfo.id = 1388L;
		
		sellingProductInfo.components = new ArrayList<SellingProductInfo.Components>();
		sellingProductInfo.components.add( sellingComponent );

		user.sellingProducts = new ArrayList<SellingProductInfo>();
		user.sellingProducts.add( sellingProductInfo );
		
		String res;
		try
		{
			res = bossService.activeAccountSellingProduct( arg );
			System.out.println(JSONHelper.toJSONString( res ));
		}
		catch ( ServiceException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
