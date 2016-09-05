import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import org.apache.commons.lang.StringUtils;
import name.rex.commlib.base.StringTemplate;
import name.rex.commlib.dataobj.PhoneNumber;
import name.rex.commlib.util.StringHelper;
import name.rex.commlib.format.JSONHelper;

public class StringTest
{
    @Test
    public void testPhoneNumber()
    {
        String number;
        PhoneNumber res;

        number = "62886861";
        res = StringHelper.parsePhoneNumber( number );
        System.out.println( String.format( "Number: %s, PhoneNumber: %s", number, JSONHelper.toJSONString( res ) ) );
        
        number = "0512-62886861";
        res = StringHelper.parsePhoneNumber( number );
        System.out.println( String.format( "Number: %s, PhoneNumber: %s", number, JSONHelper.toJSONString( res ) ) );

        number = "0512-62886861-6016";
        res = StringHelper.parsePhoneNumber( number );
        System.out.println( String.format( "Number: %s, PhoneNumber: %s", number, JSONHelper.toJSONString( res ) ) );

        number = "62886861-6016";
        res = StringHelper.parsePhoneNumber( number );
        System.out.println( String.format( "Number: %s, PhoneNumber: %s", number, JSONHelper.toJSONString( res ) ) );

        number = "0086-0512-62886861-6016";
        res = StringHelper.parsePhoneNumber( number );
        System.out.println( String.format( "Number: %s, PhoneNumber: %s", number, JSONHelper.toJSONString( res ) ) );

        number = "0086-62886861-6016";
        res = StringHelper.parsePhoneNumber( number );
        System.out.println( String.format( "Number: %s, PhoneNumber: %s", number, JSONHelper.toJSONString( res ) ) );

        number = "0086-0512-62886861";
        res = StringHelper.parsePhoneNumber( number );
        System.out.println( String.format( "Number: %s, PhoneNumber: %s", number, JSONHelper.toJSONString( res ) ) );

        number = "+86-0512-62886861-6016";
        res = StringHelper.parsePhoneNumber( number );
        System.out.println( String.format( "Number: %s, PhoneNumber: %s", number, JSONHelper.toJSONString( res ) ) );

        number = "+86-0512-62886861";
        res = StringHelper.parsePhoneNumber( number );
        System.out.println( String.format( "Number: %s, PhoneNumber: %s", number, JSONHelper.toJSONString( res ) ) );

        number = "+86--62886861";
        res = StringHelper.parsePhoneNumber( number );
        System.out.println( String.format( "Number: %s, PhoneNumber: %s", number, JSONHelper.toJSONString( res ) ) );

        number = "62886861-016";
        res = StringHelper.parsePhoneNumber( number );
        System.out.println( String.format( "Number: %s, PhoneNumber: %s", number, JSONHelper.toJSONString( res ) ) );
    }

    @Test
    public void testTemplate()
    {
        String content = "sdfsdf#sdfdfs#^sdfsdfsdf";

        System.out.println( StringTemplate.render( content, "sdf#sdf", "aaaa" ) );

        Map<String, String> mapValues = new TreeMap<String, String>();

        mapValues.put( "sdf#sdf", "bbbb" );

        System.out.println( StringTemplate.render( content, mapValues ) );
    }

    @Test
    public void testSplit()
    {
        String []s = null;

        s = "".split( ";" );
        if( null == s )
        {
            System.out.println( "split is null" );
        }
        else
        {
            System.out.println( "size: " + s.length );
        }

        String v1 = "  \t\nsdfsdf \t\n\r ";
        
        System.out.println( "====================" );
        System.out.println( "orgi:" + v1 );
        System.out.println( "StringTrim: " + v1.trim() );
        System.out.println( "StringUtilsTrim: " + StringUtils.trim( v1 ) );
        System.out.println( "====================" );

        v1 = " \t\r\n";
        System.out.println( "====================" );
        System.out.println( "orgi:" + v1 );
        System.out.println( "StringTrim: " + v1.trim() );
        System.out.println( "StringUtilsTrim: " + StringUtils.trim( v1 ) );
        System.out.println( "====================" );
    }

    public class CA
    {
        public String a;
        public String b;
    }

    public class CB extends CA
    {
        public byte[] data;
    }

    @Test
    public void testJSON()
    {
        CA a = new CA();

        a.a = "sdfsdf";
        a.b = "sdfdsf222";

        CB b = new CB();

        b.a = "213123";
        b.b = "1231231231231231";
        b.data = new byte[ 12 ];

        System.out.println( "JSON A: " + JSONHelper.toJSONString( a ) );
        System.out.println( "JSON A from B: " + JSONHelper.toJSONString( (CA)b ) );

        CA ca = null;
        CB cb = null;

        System.out.println( "JSON A: " + JSONHelper.toJSONString( ca ) );
        System.out.println( "JSON B: " + JSONHelper.toJSONString( cb ) );
    }
}
