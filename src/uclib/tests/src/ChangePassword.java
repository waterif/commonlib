
import org.junit.Before;
import org.junit.Test;

import com.quanshi.uclib.service.UmsService;

public class ChangePassword
{
    private UmsService umsService = new UmsService( "http://192.168.28.173:8081/umsapi", "http://192.168.39.20:8091/" );
   
    @Before
    public void Before()
    {

    }

    @Test
    public void changePass() throws Exception
    {
        umsService.changePass( 62078169, "111111", "111111" );
    }
}
