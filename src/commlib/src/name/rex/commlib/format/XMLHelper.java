package name.rex.commlib.format;

import java.io.StringWriter;
import java.io.StringReader;
import java.lang.annotation.Annotation;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Marshaller;  
import javax.xml.bind.Unmarshaller;
import org.dom4j.Element;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import name.rex.commlib.util.StringHelper;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

public class XMLHelper
{
    public static Logger log = LoggerFactory.getLogger( XMLHelper.class );

    public static String modifyRootElementName( String xmlStr, String rootElementName )
    {
        if ( null == rootElementName || rootElementName.isEmpty() )
        {
            return xmlStr;
        }

        try
        {
            Document xmlDoc = DocumentHelper.parseText( xmlStr );
            Element oldElement = xmlDoc.getRootElement();

            if( oldElement.getQName().getName().equals( rootElementName ) )
            {
                return xmlStr;
            }

            Element newElement = oldElement.createCopy( rootElementName );

            return newElement.asXML();
        }
        catch( Exception e )
        {
            log.error( "modifyRootElementName Error: " + e.getMessage() );
            return null;
        }
    }

    public static <T> String getClassRootElementName( Class<T> valueType )
    {
        Annotation ann = valueType.getAnnotation( XmlRootElement.class );
        if ( null == ann )
        {
            log.warn( String.format( "not found XmlRootElement annotation on class %s", valueType.getName() ) );
            return null;
        }

        XmlRootElement xre_ann = ( XmlRootElement ) ann;
        String name = xre_ann.name();
        if ( "##default".equals( name ) )
        {
            name = valueType.getName();

            int pos = name.lastIndexOf( '.' );

            if ( -1 != pos )
            {
                name = StringHelper.firstLower( name.substring( pos + 1 ) );
            }

            pos = name.lastIndexOf( '$' );
            if ( -1 != pos )
            {
                name = StringHelper.firstLower( name.substring( pos + 1 ) );
            }
        }

        return name;
    }

    public static <T> String toXMLString( T t, String newRootElementName )
    {
        try 
        {  
            JAXBContext context = JAXBContext.newInstance( t.getClass() );  
            Marshaller marshaller = context.createMarshaller();
            StringWriter writer = new StringWriter();
            
            marshaller.marshal( t, writer );
            
            String xmlStr = writer.toString();

            if ( null != newRootElementName && ! newRootElementName.trim().isEmpty() )
            {
                String origRootName = getClassRootElementName( t.getClass() );
            
                if ( ! origRootName.equals( newRootElementName.trim() ) )
                {
                    xmlStr = modifyRootElementName( xmlStr, newRootElementName.trim() );
                }
            }

            return xmlStr;
        } 
        catch ( JAXBException e ) 
        {  
            log.error( "toXMLString Error: " + e.getMessage(), e );
            return null;
        } 
    }

    public static <T> String toXMLString( T t )
    {
        return toXMLString( t, null );
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromXMLString( String xmlStr, Class<T> valueType )
    {
        String rootElementName = getClassRootElementName( valueType );

        if ( null != rootElementName )
        {
            xmlStr = modifyRootElementName( xmlStr, rootElementName );
        }

        try 
        {  
            JAXBContext context = JAXBContext.newInstance( valueType );  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            T t = (T)unmarshaller.unmarshal( new StringReader( xmlStr ) );
            return t;
        } 
        catch ( JAXBException e ) 
        {  
            log.error( "fromXMLString Error: " + e.getMessage() );
            return null;
        } 
    }
}
