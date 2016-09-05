import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import com.alibaba.fastjson.JSON;
import name.rex.commlib.format.JSONHelper;

public class FormatTest
{
    @Test
    public void jsonEncode()
    {
        String v;

        for( char n = 1; n < 255; n++ )
        {
            String j = JSON.toJSONString( String.valueOf( n ) );

            System.out.print( String.format( "%d, %c, %s\n", Integer.valueOf( n ), n, j ) );
        }
    }

    public static class User
    {
        public String name;
        public int age;

        public User( String name, int age )
        {
            this.name = name;
            this.age = age;
        }
    }

    public static class Base
    {
        public String username;
        public String token;
    }

    public static class RequestObj <T> extends Base
    {
        public T data; 
    }

    public static class A extends RequestObj<User[]> 
    {
    }

    @Test
    public void testJson1()
    {
        RequestObj<User[]> r1 = new RequestObj<User[]>();

        r1.username = "usename";
        r1.token = "token";
        r1.data = new User[3];

        r1.data[0] = new User( "n0", 0 );
        r1.data[1] = new User( "n1", 1 );
        r1.data[2] = new User( "n2", 2 );

        String j1 = JSONHelper.toJSONString( r1 );

        System.out.println( "J1: " + j1 );

        Base r2 = JSONHelper.parseObject( j1, Base.class );

        String j2 = JSONHelper.toJSONString( r2 );

        System.out.println( "J2: " + j2 );
    }
}
