import org.junit.Before;
import org.junit.Test;

import com.quanshi.uclib.service.PbxService;
import com.quanshi.uclib.service.UccServerService;
import com.quanshi.uclib.service.dataobject.PbxAccessAuth;
import com.quanshi.uclib.service.dataobject.UmsTokenInfo;

public class PbxTest
{
    public String account = "adminhxh@quanshi.com";
    public String password = "11111111";
    public int siteId = 75025;

    public String authToken = "cUCXiusVww";
    public String developerKey = "b864e881ec30da85ecs3c47ied25b58ba7cf";
    public String host = "testcloud.quanshi.com";
    public String umsUrl = "http://testcloud.quanshi.com";
    public String uccServerUrl = "http://testcloud3.quanshi.com";
    public String pbxUrl = "https://webapi.easipbx.com:9443";
    public PbxService pbxService;
    public UccServerService uccServerService;
    public String proxyHost = "192.168.21.248";
    public int proxyPort = 3128;
    public String proxyScheme = "http";

    @Before
    public void Before() throws Exception
    {
        uccServerService = new UccServerService( uccServerUrl );
        UmsTokenInfo tokenInfo =  uccServerService.getUmsTokenInfo( account, password, siteId );
        if ( null == tokenInfo || tokenInfo.access_token == null || tokenInfo.access_token.isEmpty() )
        {
            throw new Exception( "not found valid access token" );
        }

        PbxAccessAuth auth = new PbxAccessAuth();


        auth.auth.token = authToken;
        auth.auth.developerKey = developerKey;

        //pbxService = new PbxService( auth );
    }

    @Test
    public void Test() throws Exception
    {
//        PbxOpenArgs args = new PbxOpenArgs();
//        List<String> ids = new ArrayList<String>();
//
//        ids.add( String.format( "%s", 11 ) );
//        ids.add( String.format( "%s", 12 ) );
//        args.usernames = ids;
//
//        args.user_options.user_flag = String.format( "%d", siteId );
//
//        HttpWrapper.setProxy( proxyHost, proxyPort, proxyScheme );
//        pbxService.open( args );
    }
}
