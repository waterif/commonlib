import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import java.lang.annotation.Annotation;
import org.junit.Test;
import org.dom4j.Element;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import name.rex.commlib.format.JSONHelper;
import name.rex.commlib.format.XMLHelper;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
class Student
{
    public String name;
    public Integer id;
}

@XmlRootElement
class Teacher
{
    public String name;
    public Integer age;
}

@XmlRootElement( name="sdfsdf" )
class Class
{
    public String name;
    public Teacher teacher;
    public List<Student> students;
}

@XmlRootElement
class MapConfig
{
    public String name;
    public Map<String, String> handler;
}

@XmlRootElement
class MapConfig2
{
    public String name;
    public String handler;
}

@XmlRootElement
class LangConfig
{
    String default_lang;
    Map<String, Object> langDefine;
}

public class XMLTest
{
    String xmlText = "<myclass><name>初一</name><teacher><name>语文老师</name><age>20</age></teacher><students><name>AAA</name><id>100</id></students><students><name>AAA</name><id>100</id></students></myclass>";
    @Test
    public void toXMLStringTest()
    {
        Student s = new Student();
        s.name = "AAA";
        s.id = 100;

        String xmlContent;
        //String xmlContent = XMLHelper.toXMLString( s );
        //System.out.println( xmlContent );

        Class c = new Class();
        c.name = "初一";
        c.teacher = new Teacher();
        c.teacher.name = "语文老师";
        c.teacher.age = 20;
        c.students = new ArrayList<Student>();

        c.students.add( s );
        c.students.add( s );

        xmlContent = XMLHelper.toXMLString( c );
        System.out.println( "XML1: " + xmlContent );

        Class c1 = XMLHelper.fromXMLString( xmlContent, Class.class );
        System.out.println( "JSON1: " + JSONHelper.toJSONString( c1 ) );

        xmlContent = XMLHelper.toXMLString( c, "key2" );
        System.out.println( "XML2: " + xmlContent );

        c1 = XMLHelper.fromXMLString( xmlContent, Class.class );
        System.out.println( "JSON2: " + JSONHelper.toJSONString( c1 ) );
    }

    @Test
    public void readXML() throws Exception
    {
        String xmlText = "<class><name>初一</name><teacher><name>语文老师</name><age>20</age></teacher><students><name>AAA</name><id>100</id></students><students><name>AAA</name><id>100</id></students></class>";
        Document doc = DocumentHelper.parseText( xmlText );
        Element rootElm = doc.getRootElement();
        String v = rootElm.getStringValue();

        System.out.println( "XML: " + xmlText );
        System.out.println( "StringValue: " + v );
        v = rootElm.elementText( "teacher" );
        System.out.println( "elmentText: " + v );

        Element e1 = rootElm.createCopy( "sdfsdfsdf" );
        System.out.println( "e1: " + e1.asXML() );
    }

    @Test 
    public void parseXML()
    {
        Class c1 = XMLHelper.fromXMLString( this.xmlText, Class.class );
        System.out.println( "c1-1:" + JSONHelper.toJSONString( c1 ) );
        c1 = XMLHelper.fromXMLString( this.xmlText, Class.class );
        System.out.println( "c1-2:" + JSONHelper.toJSONString( c1 ) );
    }

    @Test
    public void testAnnotation()
    {
        Annotation an = Class.class.getAnnotation( XmlRootElement.class );
        if ( null == an )
        {
            System.out.println( "get Annotation return null" );
        }

        XmlRootElement r = ( XmlRootElement )an;
        System.out.println( "name: " + r.name() );
    }

    @Test
    public void testAnnotation2()
    {
        Annotation an = Student.class.getAnnotation( XmlRootElement.class );
        if ( null == an )
        {
            System.out.println( "get Annotation return null" );
        }
    }

    @Test
    public void testAnnotation3()
    {
        System.out.println( "name: " + XMLHelper.getClassRootElementName( Class.class ) );
        System.out.println( "name: " + XMLHelper.getClassRootElementName( Teacher.class ) );
        System.out.println( "name: " + XMLHelper.getClassRootElementName( Student.class ) );
    }

    @Test 
    public void testMap()
    {
        MapConfig cfg = new MapConfig();
        
        cfg.name = "test";
        cfg.handler = new HashMap<String, String>();
        cfg.handler.put( "xml", "skdfsdfsdfs" );
        cfg.handler.put( "xlsx", "11111111111111111111" );
        cfg.handler.put( "xls", "222222222222222222222" );

        String xmlContent = XMLHelper.toXMLString( cfg );
        System.out.println( "XML1: " + xmlContent );

        MapConfig2 cfg2 = XMLHelper.fromXMLString( xmlContent, MapConfig2.class );  
        System.out.println( "cfg2: " + JSONHelper.toJSONString( cfg2 ) ); 
    }

    @Test
    public void testLang()
    {
        Map<String, String> lang = new HashMap<String, String>();
        lang.put( "tag_u_code", "123123123" );
        lang.put( "tag_u_name", "sdfsdfss" );

        LangConfig langConfig = new LangConfig();

        String xmlContent = XMLHelper.toXMLString( langConfig );
        System.out.println( "langConfig: " + xmlContent );
    }
}
