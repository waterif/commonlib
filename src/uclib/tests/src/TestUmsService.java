import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.quanshi.uclib.dataobject.SiteTagsResult;
import com.quanshi.uclib.service.ServiceException;
import com.quanshi.uclib.service.UmsService;
import com.quanshi.uclib.service.dataobject.FindOrgByNamesInfo;
import com.quanshi.uclib.service.dataobject.UmsCreateUserInfo;
import com.quanshi.uclib.service.dataobject.UmsOrgAndUserArg;
import com.quanshi.uclib.service.dataobject.UmsOrgInfo;
import com.quanshi.uclib.service.dataobject.UmsPrivilageInvisibleOrgInfo;
import com.quanshi.uclib.service.dataobject.UmsThirdPartyObjects.BindThirdPartyArgs;
import com.quanshi.uclib.service.dataobject.UmsThirdPartyObjects.UmsBindThirdPartyResult;
import com.quanshi.uclib.service.dataobject.UmsThirdPartyObjects.UmsGetThirdPartyResult;
import com.quanshi.uclib.service.dataobject.UmsThirdPartyObjects.UmsModifyThirdPartyStatusResult;
import com.quanshi.uclib.service.dataobject.UmsThirdPartyObjects.UmsUnBindThirdPartyResult;
import com.quanshi.uclib.service.dataobject.UmsUserInfo;
import com.quanshi.uclib.service.dataobject.UmsUserTagsValueInfo;
import com.quanshi.uclib.service.dataobject.UmsVerifyMailMobileObjects.UmsVerifyMailMobileReturn;
import com.quanshi.uclib.service.dataobject.UmsVerifyMailMobileObjects.UmsVerifyPhoneAndMailArgs;
import com.quanshi.uclib.service.dataobject.UserProductDTO;
import com.quanshi.uclib.service.dataobject.UserValidateCheckObjects.UserUniqueInfo;
import com.quanshi.uclib.service.dataobject.UserValidateCheckObjects.ValidateUserReturn.UserfindInfo;

import name.rex.commlib.format.JSONHelper;

public class TestUmsService {

	private UmsService umsService = null;

	@Before
	public void setUp() throws Exception 
	{
		umsService = new UmsService( "http://192.168.28.173:8081/umsapi", "http://192.168.39.20:8091/" );
	}

	@Test
	public void testModifyPass() {  //62077886
		try {
			umsService.modifyPass(62077886, "11111111");
		} 
		catch (Exception e) {			
			e.printStackTrace();
		}
	}

	
	@Test
	public void testChangePass() {  //62077886
		try {
			umsService.changePass(62077886, "111111", "11111111");
		} 
		catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testUserByName() {
		try {
			UmsUserInfo userInfo = umsService.userByName( "maoyandev_b1" );
			if ( null != userInfo)
			{
				System.out.println( userInfo.id);
			}
		}
		catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryOrg()
	{
		try
		{			
			UmsOrgInfo umsOrg = umsService.getOrg( 54758 );
			if( null != umsOrg )
			{
				System.out.println( umsOrg.name );
			}
			
			List<UmsOrgInfo> list = umsService.getChildOrgs( 54767, UmsService.QUREY_SCOPE_SUBTREE, UmsService.ORG_TYPE_ORGANIZATION + "");
			if( list != null )
			{
				System.out.println( list.size() );
			}	
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetOrgAccounts()
	{
		try
		{
			List<UmsUserInfo> users = umsService.getOrgAccounts(309);
			if( users != null )
			{
				System.out.println( users.size() );
			}	
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddOrg()
	{
		try
		{		
			int orgId = umsService.addOrg( 733, "zhz测试部门5", "003530", UmsService.ORG_TYPE_ORGANIZATION );
			System.out.println( orgId );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateOrg()
	{
		try
		{			
			umsService.updateOrg( 54759, 733, "zhz测试部门1", "003530", UmsService.ORG_TYPE_ORGANIZATION );			
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteOrg()
	{
		try
		{			
			umsService.deleteOrg( 54758 );			
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetPrivilageInvisibleOrg()
	{
		try
		{
			List<UmsPrivilageInvisibleOrgInfo> users = umsService.getPrivilageInvisibleOrg(309);
			if( users != null )
			{
				System.out.println( users.size() );
			}	
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSetPrivilageInvisibleOrg()
	{
		try
		{
			umsService.setPrivilageInvisibleOrg( 54280, 12372, UmsService.QUERY_PERMISSION_KEY, UmsService.QUERY_PERMISSION_VALUE );
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelPrivilageInvisibleOrg()
	{
		try
		{
			umsService.delPrivilageInvisibleOrg( 98 );
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMoveOrg()
	{
		try
		{
			umsService.moveOrg( 54280, 54281 );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testSortOrg()
	{
		try
		{
			int[] aaa = { 54279, 54288 };
			umsService.sortOrg( aaa );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}

    @Test 
    public void testUserByIds()
    {
        List<Long> ids = new ArrayList<Long>();
        Long id;
        
        id = (long)62247225;
        ids.add( id );

        try
        {
            List<UmsUserInfo> infos = umsService.userByIds( ids );
            System.out.println( JSONHelper.toJSONString( infos ) );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testCreateUser()
    {
        UmsCreateUserInfo info = new UmsCreateUserInfo();
        info.loginName = "junitTest_0@quanshi.com";
        info.displayName = "junitTest_0";
        info.firstName = "hongliang";
        info.lastName = "cao";
        info.email = "junitTest_0@quanshi.com";
        info.position = "staff";
        info.namepinyin = "CHL";
        info.passType = 1;
        
        try
        {
            int userId = umsService.createUser( info );
            System.out.println( userId );
        }
        catch ( ServiceException e )
        {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testUpdateUser()
    {
        UmsCreateUserInfo info = new UmsCreateUserInfo();
        info.id = 62755660;
        info.loginName = "junitTest_1@quanshi.com";
        
        try
        {
            boolean success = umsService.updateUser( info  );
            System.out.println( success );
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testUserIsExists()
    {
        UserUniqueInfo info = new UserUniqueInfo();
        info.loginName = "test_test0624_08@quanshi.com";
        info.email = "waterif@live.com";
//        info.phone.phoneNumber = "15306137329";
        
        try
        {
            String r = umsService.userIsExists( info );
            System.out.println( r );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testVerifyPhoneAndMail()
    {
        
        UmsVerifyPhoneAndMailArgs mailmobile = new UmsVerifyPhoneAndMailArgs();
//        mailmobile.email = "test_test_062509@quanshi.com";
//        mailmobile.mobile.phoneNumber = "15306137329";
//        mailmobile.mobile.phoneNumber = "26593654895";
        
        try
        {
            boolean yes = umsService.verifyPhoneAndMail( mailmobile );
            System.out.println( yes );
//            assertTrue( "yes", yes );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
//    @Test
//    public void verifyPhoneAndMail2()
//    {
//    	
//    	UmsVerifyPhoneAndMailArgs mailmobile = new UmsVerifyPhoneAndMailArgs();
//        mailmobile.email = "test_test_062509@quanshi.com";
////        mailmobile.mobile.phoneNumber = "15306137329";
//        mailmobile.mobile.phoneNumber = "26593654895";
//    	
//    	try
//    	{
//    		JSONObject res = umsService.verifyPhoneAndMail2( mailmobile );
//    		System.out.println( JSONHelper.toJSONString( res ) );
////            assertTrue( "yes", yes );
//    	}
//    	catch ( ServiceException e )
//    	{
//    		// TODO Auto-generated catch block
//    		e.printStackTrace();
//    	}
//    }
    
    @Test
    public void userByEmail()
    {
    	
    	UmsVerifyPhoneAndMailArgs mailmobile = new UmsVerifyPhoneAndMailArgs();
    	mailmobile.email = "waterif0625@live.com";
//    	mailmobile.email = "test_test_062509@quanshi.com";
//        mailmobile.mobile.phoneNumber = "15306137329";
//    	mailmobile.mobile.phoneNumber = "26593654895";
    	
    	try
    	{
    		UmsUserInfo res = umsService.userByEmail( mailmobile.email );
    		System.out.println( JSONHelper.toJSONString( res ) );
    	}
    	catch ( Exception e )
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    
    
    @Test
    public void userByMobile()
    {
    	
    	UmsVerifyPhoneAndMailArgs mailmobile = new UmsVerifyPhoneAndMailArgs();
//    	mailmobile.email = "test_test_062509@quanshi.com";
        mailmobile.mobile.phoneNumber = "15306137329";
//    	mailmobile.mobile.phoneNumber = "26593654895";
    	
    	try
    	{
    		UmsUserInfo res = umsService.userByMobile( mailmobile.mobile.phoneNumber );
    		System.out.println( JSONHelper.toJSONString( res ) );
    	}
    	catch ( ServiceException e )
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    
    
    
    @Test
    public void getUserValidateInfo()
    {
    	
    	
    	UserUniqueInfo uInfo = new UserUniqueInfo();
//    	uInfo.loginName = "test_test_062509@quanshi.com";
    	uInfo.email = "waterif2016@yeah.net";
//    	uInfo.phone.phoneNumber = "15306137349";
//    	uInfo.email = "waterif0625@live.com";
//    	uInfo.phone.phoneNumber = "15306137329";
//    	uInfo.phone.phoneNumber = "123345556666";
    	
    	try
    	{
    		List<UserfindInfo> userfindInfo = umsService.getUserValidateInfo( uInfo );
    		System.out.println( JSONHelper.toJSONString( userfindInfo ) );
    	}
    	catch ( ServiceException e )
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    
    @Test
    public void testGetUserProduct()
    {
        int userId = 63506110;
        
        try
        {
            UserProductDTO dto = umsService.getUserProduct( userId, null );
            System.out.println( JSONHelper.toJSONString( dto ) );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            if ( e.getStatusCode() == 404 )
            {
                System.out.println( "not open bee product." );
            }
        }
        
    }
    
    @Test
    public void testGetThirdParty()
    {
        int userId = 62755660;
        try
        {
            UmsGetThirdPartyResult rst = umsService.getThirdParty( userId );
            System.out.println( JSONHelper.toJSONString( rst ) );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testBindThirdParty()
    {
        BindThirdPartyArgs args  = new BindThirdPartyArgs();
        args.userId = 62755660;
        args.tpId = "12345678";
        args.tpStatus = 0;
        args.tpType = 2;
        
        try
        {
            UmsBindThirdPartyResult rst = umsService.bindThirdParty( args );
            System.out.println( JSONHelper.toJSONString( rst ) );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testUnbindThirdParty()
    {
        int userId = 62755660;
        String tpId = "12345678";
        int tpType = 1;
        
        try
        {
            UmsUnBindThirdPartyResult rst = umsService.unbindThirdParty( tpId, tpType, userId );
            System.out.println( JSONHelper.toJSONString( rst ) );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testModifyThirdPartyStatus()
    {
        long id = 480;
        int status = 1;
        try
        {
            UmsModifyThirdPartyStatusResult rst = new UmsModifyThirdPartyStatusResult();
            
            rst = umsService.modifyThirdPartyStatus( id, status  );
            
            System.out.println( JSONHelper.toJSONString( rst ) );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testCreateOrgAndUser()
    {
        List<UmsOrgAndUserArg> args =  new ArrayList<UmsOrgAndUserArg>();
        
        UmsOrgAndUserArg org = new UmsOrgAndUserArg();
        org.name = "子组织1/子组织2";
        org.customercode = "002869";
        org.parentId = (long) 163;
        org.type = 3;
        //org.users = null;
        
        args.add( org );
        
        try
        {
            List<UmsCreateUserInfo> i =  umsService.createOrgAndUser( args  );
            System.out.println( i );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testFindOrgByNames()
    {
        String customerCode = "002869";
        ArrayList<String> names = new ArrayList<String>();
        
        names.add( "子组织1" );
        names.add( "子组织2" );
        names.add( "子组织3" );
        
        
        try
        {
            UmsOrgInfo rst = umsService.findOrgByNames( customerCode, names );
            System.out.println( JSONHelper.toJSONString( rst ) );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void testGetSiteTags()
    {
        long siteId = 72112;
        try
        {
            List<SiteTagsResult> siteTagList = umsService.getSiteTags( siteId, UmsService.UC_PRODUCT_ID );
            System.out.println( JSONHelper.toJSONString( siteTagList ) );
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    @Test
    public void testAddSiteTags()
    {
        long siteId = 72112;
        List<SiteTagsResult> tags = new ArrayList<SiteTagsResult>();
        
        SiteTagsResult tag = new SiteTagsResult();
        tag.tagName = "测试ceshi";
        tag.tagType = 2;
        tag.tagCode = "";
        tag.enable = 1;
        tag.clientEditable = 1;
        tag.clientSearchable = 1;
        tag.clientVisible = 1;
        tag.siteId = 72112;
        
        tags.add( tag );
        
        try
        {
            umsService.addSiteTags( siteId, UmsService.UC_PRODUCT_ID, tags );
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    @Test
    public void testUpdateSiteTags()
    {
        long siteId = 72112;
        List<SiteTagsResult> tags = new ArrayList<SiteTagsResult>();
        
        SiteTagsResult tag = new SiteTagsResult();
        tag.tagName = "测试ceshi2";
        tag.tagType = 2;
        tag.tagCode = "";
        tag.enable = 1;
        tag.clientEditable = 1;
        tag.clientSearchable = 1;
        tag.clientVisible = 1;
        tag.siteId = 72112;
        tag.id = 185370;//////////
        
        tags.add( tag );
        
        try
        {
            umsService.updateSiteTags( siteId, UmsService.UC_PRODUCT_ID, tags );
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    @Test
    public void testDeleteSiteTags()
    {
        int siteId = 72112;
        long tagId = 185370;
        try
        {
            umsService.deleteSiteTags( siteId, UmsService.UC_PRODUCT_ID, tagId );
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testGetUserTagValues()
    {
    	 long userId = 62253256;
         long siteId = 72111; 
         try
         {
             List<UmsUserTagsValueInfo> tagList = umsService.getUserTagValues( siteId, userId  );
             printJson( tagList );
         }
         catch ( Exception e )
         {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
    }
    
    @Test
    public void testGetUserTagsValue()
    {
        long userId = 62253256;
        long tagId = 183927;
        long siteId = 72111; 
        try
        {
            List<UmsUserTagsValueInfo> tagList = umsService.getUserTagValue( siteId, userId, tagId  );
            printJson( tagList );
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testAddUserTagsValue()
    {
        int userId = 62253256;
        List<UmsUserTagsValueInfo> tagValues = new ArrayList<UmsUserTagsValueInfo>();
        
        UmsUserTagsValueInfo tagValue = new UmsUserTagsValueInfo();
        tagValue.tagId = (long) 183927;
        //tagValue.tagName = "女人";
        tagValue.userId = (long) userId;
        tagValue.tagValue = "女人";
        
        tagValues.add( tagValue );
        
        try
        {
            List<UmsUserTagsValueInfo> tagsValueList = umsService.addUserTagsValue( userId, tagValues  );
            printJson( tagsValueList );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    @Test
    public void testUpdateUserTagsValue()
    {
        int userId = 62253256;
        List<UmsUserTagsValueInfo> tagValues = new ArrayList<UmsUserTagsValueInfo>();
        
        UmsUserTagsValueInfo tagValue = new UmsUserTagsValueInfo();
        tagValue.tagId = (long) 182687;
        //tagValue.tagName = "女人";
        tagValue.userId = (long) userId;
        tagValue.tagValue = "女人3";
        tagValue.id = 71344L;////
        
        tagValues.add( tagValue );
        
        try
        {
            boolean ret = umsService.updateUserTagsValue( userId, tagValues  );
            printJson( ret );        
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    @Test
    public void testDelUserTagsValue()
    {
        int userId = 62253256;
        long tagId = 182687;
        try
        {
            umsService.delUserTagsValue( userId, tagId );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    @Test
    public void testSetUserProduct()
    {
        long siteId = 68897;
        long userId = 61359734L;
        short umsBeeStatus;
        
        try
        {
            boolean success = umsService.setUserProduct( siteId, userId, UmsService.UC_PRODUCT_ID , UmsService.UC_PRODUCT_ENABLE_OR_OPENED );
            System.out.println( success );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
    protected void printJson( Object o )
    {
        System.out.println( JSONHelper.toJSONString( o ) );
    }
    
}
