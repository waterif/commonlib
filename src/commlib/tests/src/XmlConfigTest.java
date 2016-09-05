import org.junit.Test;

import java.util.List;
import name.rex.commlib.config.XmlConfig;

public class XmlConfigTest
{
    @Test
    public void check1() throws Exception
    {
        XmlConfig xmlConfig = XmlConfig.createInstanceFile( "build.xml" );
        String xmlString = xmlConfig.getConfigNode( "/project/target" );
        System.out.println( "Element String: " + xmlString );
    }

    @Test
    public void check2() throws Exception
    {
        XmlConfig xmlConfig = XmlConfig.createInstanceFile( "build.xml" );
        String xmlString = xmlConfig.getConfigNode( "/project/111target" );
        System.out.println( "Element String: " + xmlString );
    }
}
