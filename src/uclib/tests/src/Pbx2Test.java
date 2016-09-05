package test;

import org.junit.Before;
import org.junit.Test;

import name.rex.commlib.format.JSONHelper;
import com.quanshi.uclib.service.PbxService2;

public class Pbx2Test
{
    public String domainServer = "https://pbx.easiio.cn";

    @Test
    public void getDomainInfo() throws Exception
    {
        PbxService2 pbxService2 = new PbxService2( domainServer, null, null );
        PbxService2.DomainInfo domainInfo = pbxService2.getDomainInfoByDeveloperKey( "b864e881ec30da85ecs3c47ied25b58ba7cf" ); 

        System.out.println( "DomainInfo: " + JSONHelper.toJSONString( domainInfo ) );
    }
}
