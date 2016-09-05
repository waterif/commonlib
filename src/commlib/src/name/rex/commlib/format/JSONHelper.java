package name.rex.commlib.format;

import java.io.File;
import java.lang.Exception;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

public class JSONHelper
{
    public static Logger log = LoggerFactory.getLogger( JSONHelper.class );

    public static String toJSONString( Object object )
    {
        String jsonString = null;
        
        try
        {
            jsonString = JSON.toJSONString( object );
        }
        catch( Exception e ) 
        {
            log.error( e.getMessage(), e );
            return null;
        }

        return jsonString;
    }

    public static String toJSONString( JSONObject jsonObject )
    {
        String jsonString = null;

        try
        {
            jsonString = jsonObject.toJSONString();
        }
        catch( Exception e ) 
        {
            log.error( e.getMessage(), e );
            return null;
        }

        return jsonString;
    }

    public static JSONObject parseObject( String jsonString )
    {
        JSONObject rObject = null;

        try
        {
            rObject = JSON.parseObject( jsonString );
        }
        catch( Exception e ) 
        {
            log.error( e.getMessage(), e );
            return null;
        }

        return rObject;
    }

    public static <T> T parseObject( String jsonString, Class<T> valueType )
    {
        T rObject = null;

        try
        {
        	rObject = JSON.parseObject( jsonString, valueType );
        }
        catch( Exception e ) 
        {
            log.error( e.getMessage(), e );
            return null;
        }

        return rObject;
    }
    
    public static <T> T getObject( JSONObject jsonObject, String key, Class<T> valueType )
    {
        T rObject = null;

        try
        {
            rObject = jsonObject.getObject( key, valueType );
        }
        catch( Exception e ) 
        {
            log.error( e.getMessage(), e );
            return null;
        }

        return rObject;
    }

    public static JSONArray parseArray( String jsonString )
    {
        JSONArray array = null;

        try
        {
            array = JSON.parseArray( jsonString );
        }
        catch( Exception e ) 
        {
            log.error( e.getMessage(), e );
            return null;
        }

        return array;
    }

    public static <T> List<T> parseArray( String jsonString, Class<T> valueType )
    {
        List<T> rList = null;

        try
        {
            rList = JSON.parseArray( jsonString, valueType );
        }
        catch( Exception e ) 
        {
            log.error( e.getMessage(), e );
            return null;
        }

        return rList;
    }

    public static <T> T getObject( JSONArray jsonArray, int index, Class<T> valueType )
    {
        T rObject = null;

        try
        {
            rObject = jsonArray.getObject( index, valueType );
        }
        catch( Exception e ) 
        {
            log.error( e.getMessage(), e );
            return null;
        }

        return rObject;
    }

    public static <T> List<T> getObjectList( JSONArray jsonArray, Class<T> valueType )
    {
        List<T> res = null;

        try
        {
            if ( jsonArray.size() <= 0 )
            {
                return null;
            }

            res = new ArrayList<T>();

            for( int n = 0; n < jsonArray.size(); n++ )
            {
                T rObject = jsonArray.getObject( n, valueType );
                res.add( rObject );
            }

            return res;
        }
        catch( Exception e )
        {
            return null;
        }
    }

    public static <T> List<T> getObjectList( JSONObject jsonObject, String key,  Class<T> valueType )
    {
        List<T> res = null;

        try
        {
            JSONArray jsonArray = jsonObject.getJSONArray( key );
            if ( jsonArray.size() <= 0 )
            {
                return null;
            }

            res = new ArrayList<T>();
            for( int n = 0; n < jsonArray.size(); n++ )
            {
                T rObject = jsonArray.getObject( n, valueType );
                res.add( rObject );
            }

            return res;
        }
        catch( Exception e )
        {
            return null;
        }
    }
    
    
	/**
	 * xml文档转换为json字符串
	 * @param path xml文档绝对路径
	 * @return json字符串
	 */
	public static JSONObject xml2JSON( String path )
	{
		File file = new File( path );
		if ( !file.exists() )
		{
			return null;
		}

		JSONObject obj = new JSONObject();
		try
		{
			SAXReader reader = new SAXReader();
			Document doc = reader.read( file );
			Element root = doc.getRootElement();
			obj.put( root.getName(), iterateElement( root ) );
			return obj;
		}
		catch ( Exception e )
		{
			log.error( e.getMessage(), e );
			return null;
		}
	}

	@SuppressWarnings( { "unchecked", "rawtypes" } )
	private static Map iterateElement( Element element )
	{
		List nodes = element.elements();
		Element et = null;
		Map obj = new HashMap();
		List list = null;
		for ( int i = 0; i < nodes.size(); i++ )
		{
			list = new ArrayList();
			et = ( Element ) nodes.get( i );
			if ( et.getTextTrim().equals( "" ) )
			{
				if ( et.elements().size() == 0 )
					continue;
				if ( obj.containsKey( et.getName() ) )
				{
					list = ( List ) obj.get( et.getName() );
				}
				list.add( iterateElement( et ) );
				obj.put( et.getName(), list );
			}
			else
			{
				if ( obj.containsKey( et.getName() ) )
				{
					list = ( List ) obj.get( et.getName() );
				}
				list.add( et.getTextTrim() );
				obj.put( et.getName(), list );
			}
		}
		return obj;
	}
}
