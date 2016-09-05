package name.rex.commlib.config;

import java.util.ArrayList;
import java.util.List;
import org.dom4j.Element;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import name.rex.commlib.io.FileHelper;
import name.rex.commlib.format.XMLHelper;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

public class XmlConfig
{
    private static Logger log = LoggerFactory.getLogger( XmlConfig.class );
    private Document xmlDoc = null;

    private XmlConfig()
    {

    }

    static public XmlConfig createInstanceFile( String fileName ) throws Exception
    {
        XmlConfig xmlConfig = new XmlConfig();
        if ( ! xmlConfig.initFile( fileName ) )
        {
            throw new Exception( "init xmlconfig failed from file: " + fileName );
        }

        return xmlConfig;
    }

    static public XmlConfig createInstanceString( String content ) throws Exception
    {
        XmlConfig xmlConfig = new XmlConfig();
        if ( ! xmlConfig.initString( content ) )
        {
            throw new Exception( "init xmlconfig failed from string: " + content );
        }

        return xmlConfig;
    }

    public boolean initString( String content )
    {
        try
        {
            xmlDoc = DocumentHelper.parseText( content );
            return true;
        }
        catch( Exception e )
        {
            log.error( String.format( "read xml config content %s error %s.", content, e.getMessage() ) );
            return false;
        }
    }

    public boolean initFile( String fileName )
    {
        String content = FileHelper.readTextFile( fileName );
        if ( null == content )
        {
            log.error( String.format( "read xml config file %s error.", fileName ) );
            return false;
        }

        return initString( content );
    }
    
    public String getConfigNodeValue( String nodeXPath )
    {
    	String elementValue = null;

        if ( null == xmlDoc )
        {
            return null;
        }

        try
        {
            List nodeList = xmlDoc.selectNodes( nodeXPath );
            
            if ( null != nodeList )
            {
                for( Object obj: nodeList )
                {
                    Element elm = (Element)obj;
                    elementValue = elm.getText();
                    log.debug( "selectNode Element Text: " + elementValue );
                    break;
                }
            }
            
            return elementValue;
        }
        catch( Exception e )
        {
            log.error( String.format( "selectNodes %s error: %s.", nodeXPath, e.getMessage() ) );
            return null;
        }
    }
    
    public String getConfigNode( String nodeXPath )
    {
        String elementXmlString = null;

        if ( null == xmlDoc )
        {
            return null;
        }

        try
        {
            List nodeList = xmlDoc.selectNodes( nodeXPath );
            
            if ( null != nodeList )
            {
                for( Object obj: nodeList )
                {
                    Element elm = (Element)obj;
                    elementXmlString = elm.asXML();
                    log.debug( "selectNode Element Text: " + elementXmlString );
                    break;
                }
            }
            
            return elementXmlString;
        }
        catch( Exception e )
        {
            log.error( String.format( "selectNodes %s error: %s.", nodeXPath, e.getMessage() ) );
            return null;
        }
    }
    
	public List<String> getConfigNodes( String nodeXPath )
	{
		String elementXmlString = null;

		if ( null == xmlDoc )
		{
			return null;
		}

		List<String> elementXmlStrings = null;
		try
		{
			List nodeList = xmlDoc.selectNodes( nodeXPath );

			if ( null != nodeList )
			{
				elementXmlStrings = new ArrayList<String>();

				for ( Object obj : nodeList )
				{
					Element elm = ( Element ) obj;
					elementXmlString = elm.asXML();

					elementXmlStrings.add( elementXmlString );
					log.debug( "selectNode Element Text: " + elementXmlString );
				}
			}

			return elementXmlStrings;
		}
		catch ( Exception e )
		{
			log.error( String.format( "selectNodes %s error: %s.", nodeXPath, e.getMessage() ) );
			return null;
		}
	}

    public <T> T getConfigNode( String nodeXPath, Class<T> valueType )
    {
        String xmlString = getConfigNode( nodeXPath );
        if ( null == xmlString )
        {
            return null;
        }

        return XMLHelper.fromXMLString( xmlString, valueType );
    }
}
