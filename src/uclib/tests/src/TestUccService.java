
import org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.quanshi.uclib.dataobject.ClientTypeEnum;
import com.quanshi.uclib.service.UccServerService;
import com.quanshi.uclib.service.dataobject.UccServerLoginClientInfo;
import com.quanshi.uclib.service.dataobject.UccServerLoginInfo;

public class TestUccService
{	
	private UccServerService uccServer = null;
	
	@Before
	public void setUp() throws Exception 
	{
		uccServer = new UccServerService( "http://devcloud2.quanshi.com/" );
	}

	@Test
	public void testUserLogin() 
	{
		UccServerLoginClientInfo clientInfo = new UccServerLoginClientInfo();
		clientInfo.mac = "08-9E-01-11-92-C6";
		try 
		{
			UccServerLoginInfo loginInfo = uccServer.userLogin( "maoyandev_b1", "11111111", clientInfo, 4);
			if ( null != loginInfo )
			{
				System.out.println( loginInfo.user_id );
			}
		} 		
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}
	
//	@Test
//	public void testSendMobileMsg()
//	{
//		UccServerLoginClientInfo clientInfo = new UccServerLoginClientInfo();
//		clientInfo.mac = "08-9E-01-11-92-C6";
//		try 
//		{
//			UccServerLoginInfo loginInfo = uccServer.userLogin( "maoyandev_b1", "11111111", clientInfo, 4);
//			if ( null != loginInfo )
//			{
//				System.out.println( loginInfo.user_id );
//			}
//			
//			uccServer.sendMobileMsg( loginInfo.user_id, "15306130600", "asdfasdfasdfasdf");
//		} 		
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}		
//	}

}
