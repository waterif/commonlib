import name.rex.commlib.database.DBConnector;

import java.util.Map;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import name.rex.commlib.format.JSONHelper;
import name.rex.commlib.database.DBConnector;
import name.rex.commlib.database.DBGeneratedKeyResult;

public class DbTest
{
    DBConnector conn = null;

    @Before
    public void Before() throws Exception
    {
        conn = new DBConnector( "com.mysql.jdbc.Driver", 
                "jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=UTF-8",
                "root", null, 20 );
    }

    @Test
    public void q0() throws Exception
    {
        String sql = "insert into t0( name, age ) values( \"abc\", 200 )";
        
        DBGeneratedKeyResult key = new DBGeneratedKeyResult();
        System.out.println( "before key: " + JSONHelper.toJSONString( key ) );
        conn.execute( sql, key );
        System.out.println( "after key: " + JSONHelper.toJSONString( key ) );
    }

    @Test
    public void q1() throws Exception
    {
        String sql = "insert into t1( name, age ) values( \"abc\", 200 )";
        
        DBGeneratedKeyResult key = new DBGeneratedKeyResult();
        System.out.println( "before key: " + JSONHelper.toJSONString( key ) );
        conn.execute( sql, key );
        System.out.println( "after key: " + JSONHelper.toJSONString( key ) );
    }

    @Test
    public void q2() throws Exception
    {
        String sql = "insert into t2( name, age ) values( \"abc\", 200 )";
        
        conn.execute( sql, null );

        DBGeneratedKeyResult key = new DBGeneratedKeyResult();
        System.out.println( "before key: " + JSONHelper.toJSONString( key ) );
        conn.execute( sql, key );
        System.out.println( "after key: " + JSONHelper.toJSONString( key ) );
    }
}
