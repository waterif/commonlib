package name.rex.commlib.database;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  工具类，将sql查询结果转换成java对象
 */
public class DBHelper 
{
	public static <T> List<T> resultToObject( ResultSet result, Class<T> classType) 
			throws SQLException, InstantiationException, IllegalAccessException
	{
		List<T> list = new ArrayList<T>();
		
		Map<String, Field> fields = new HashMap<String, Field>();
		getAllPublicField( classType, fields );
			
		ResultSetMetaData metaData = result.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		Map<String, Map<String, Field>> classFields = new HashMap<String, Map<String, Field>>();
		
		while( result.next())
		{
			T object  = (T)classType.newInstance();			
			for( int i=1; i<=columnCount; i++)
			{
				String lable = metaData.getColumnLabel(i);
				String className = metaData.getColumnClassName(i);				
				
				Object fieldValue = result.getObject( lable ); 			
				
				Field field = fields.get(lable);
				if ( field != null) 
				{
					setFieldValue( object, field, lable, className, fieldValue );					
				}
				else
				{										
					String tableAlias = metaData.getTableName(i);
					field = fields.get(tableAlias);
					if( null != field )     //类属性
					{
						String tableName = metaData.getTableName(i);
						
						Map<String, Field> memberFields = classFields.get(tableName);
						if( memberFields == null || memberFields.size() == 0 )
						{
							memberFields = new HashMap<String, Field>();
							classFields.put(tableName, memberFields);
							
							getAllPublicField( field.getType(), memberFields );
						}
						
						Object fieldOjbect = field.get(object); 								
						if( null == fieldOjbect)
						{
							Class clazz = field.getType();
							fieldOjbect = clazz.newInstance();
							field.set(object, fieldOjbect);
						}	
						
						field = memberFields.get(lable);
						setFieldValue( fieldOjbect, field, lable, className, fieldValue );			
					}
				}
			}
			
			list.add(object);
		}
		
		return list;
	}	
	
	private static void setFieldValue( Object object, Field field, String lable, String className, Object fieldValue) 
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException
	{
		if ( null == field || null == fieldValue )
		{
			return;
		}
		
		if ( "java.lang.Long".equals(className) )
		{
			field.set(object, Long.parseLong(fieldValue+""));
		}
		else if ( "java.lang.Integer".equals(className) )
		{
			field.set(object, Integer.parseInt(fieldValue+""));
		}
		else if ( "java.lang.String".equals(className) )
		{
			field.set(object, fieldValue+"");
		}
		else if ( "java.lang.Short".equals(className) )
		{
			field.set(object, Short.parseShort(fieldValue+""));
		}
		else if ( "java.lang.Float".equals(className) )
		{
			field.set(object, Float.parseFloat(fieldValue+""));
		}
		else if ( "java.lang.Double".equals(className) )
		{
			field.set(object, Double.parseDouble(fieldValue+""));
		}
		else if ( "java.lang.Byte".equals(className) )
		{
			field.set(object, Byte.parseByte(fieldValue+""));
		}
		else if ( "java.sql.Timestamp".equals(className) )
		{
			field.set( object, fieldValue );
		}
	}
	
	private static void getAllPublicField( Class classType, Map<String, Field> fields )
	{
		List<Field> allFields = new ArrayList<Field>();
		for( Class clazz = classType; clazz != Object.class; clazz = clazz.getSuperclass() )
		{
			Field[] arr = clazz.getDeclaredFields();
			if( null != arr || arr.length > 0 )
			{
				allFields.addAll( Arrays.asList(arr) );
			}
		}
		
		/* 只保留public修改的对象属性 */
		for( int i=0; i<allFields.size(); i++)
		{
			Field field = allFields.get(i);
			if( Modifier.PUBLIC != field.getModifiers() )
			{
				allFields.remove(i);
				i--;
				continue;
			}
			
			fields.put(field.getName(), field);
		}
	}
}
