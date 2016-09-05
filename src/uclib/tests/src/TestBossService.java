

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.quanshi.uclib.service.BossService;
import com.quanshi.uclib.service.ServiceException;
import com.quanshi.uclib.service.UmsServiceTest;
import com.quanshi.uclib.service.dataobject.BossDataObjects.CustomerInfo;
import com.quanshi.uclib.service.dataobject.SellingProductInfo;

import name.rex.commlib.format.JSONHelper;

public class TestBossService
{
    private BossService bossService = null;

    @Before
    public void setUp() throws Exception 
    {
        bossService = new BossService( "http://192.168.17.102:8880/" );
    }
    
    @Test
    public void testGetCustomerInfo()
    {
        String customerCode = "000025";
        try
        {
            CustomerInfo customerInfo = bossService.getCustomerInfo( customerCode  );
            printJson( customerInfo );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testGetSellingProductTemplates()
    {
        long contractId = 17071;
        try
        {
            List<SellingProductInfo> sellingProductTemplates = bossService.getSellingProductTemplates( contractId, null, null );
            printJson( sellingProductTemplates );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testGetContractComponentProps()
    {
        long contractId = 17380;
        String uuid = "hfvhshsfg.quanshi.com";
        long sellProdId = 1437;
        
        try
        {
            List<SellingProductInfo> contractComponentProps = bossService.getContractComponentProps( contractId, uuid, null );
            printJson( contractComponentProps );
        }
        catch ( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testCombinedBatchCreateContractComponentProps()
    {
        
    }
    
    @Test
    public void testCombinedBatchModifyContractComponentProps()
    {
        
    }
    
    protected void printJson( Object o )
    {
        System.out.println( JSONHelper.toJSONString( o ) );
    }
}
