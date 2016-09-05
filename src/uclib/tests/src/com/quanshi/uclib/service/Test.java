package com.quanshi.uclib.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test
{

	public static void main( String[] args )
	{
		// TODO Auto-generated method stub
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		try
//		{
//			System.out.println(sf.parse( "2016-07-07 23:00:00" ).getTime());
//		}
//		catch ( ParseException e )
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		System.out.println(new Date().getTime());
//	    Map<String, String> map = new HashMap<String, String>();
//	    map.put( "key1", "test1" );
//	    map.put( "key2", "test2" );
//	    map.put( "key3", "test3" );
//	    
//	    String[] strArray = map.values().toArray( new String[]{} );
//	    System.out.println(strArray[0]);
	    
	    System.out.println(sf.format( new Date(1469791685000L) ));
	    
	    
	    List<Integer> list = new ArrayList<Integer>();
	    list.add( 10 );
	    list.add( 12 );
	    list.add( 15 );
	    System.out.println(list.toString().replaceAll( " ", "" ));
	    
	    Map<String, Object> map = new HashMap<String, Object>();
	    test(map);
	    
	    Map<String, String> map2 = new HashMap<String, String>();
	    test(map2);
	    
	}
	
	public static void test(Map<String, ? extends Object> map)
	{
	    
	}

}
