package org.junit.runner.single;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.Failure;

import java.util.Arrays;
import java.util.Map;
import java.util.LinkedHashMap;

class SingleListener extends RunListener
{
    public void testFailure( Failure failure )
    {
        String s = failure.getMessage();

        System.out.println( "" );
        System.out.println( String.format( "Description: %s", s ) );
       
        Throwable e = failure.getException();

        if ( null != e )
        {
            e.printStackTrace();
        }

        System.out.println( "" );
    }
}

public class SingleJUnitTestRunner 
{
    public static Map<String, String> caseArgs = new LinkedHashMap<String, String>();
   
    public static void processCaseArgs( String [] args )
    {
        for( String arg : args )
        {
            String[] items = arg.split( "=" );

            if ( null == items || items.length <= 0  )
            {
                continue;
            }

            if ( null == items[ 0 ] || items[ 0 ].trim().isEmpty() )
            {
                continue;
            }

            caseArgs.put( items[0].trim(), ( items.length > 1 && null != items[ 1 ] ) ? items[ 1 ].trim() : null );
        }
    }

    public static void main( String[] args ) throws ClassNotFoundException 
    {
        String[] classAndMethod = args[0].split("#");

        try
        {
            String[] caseArgs = Arrays.copyOfRange( args, 1, args.length );

            if ( null != caseArgs )
            {
                processCaseArgs( caseArgs );
            }
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

        Request request = Request.method( 
                Class.forName( classAndMethod[0] ),
                classAndMethod[1] );

        /////
        Result    result;
        JUnitCore core = new JUnitCore();

        core.addListener( new SingleListener() );
        result = core.run( request );
       
        System.out.println( "" );
        System.out.println( String.format( "total: %d, fail: %d, ignore: %d", 
                    result.getRunCount(), 
                    result.getFailureCount(), 
                    result.getIgnoreCount() ) );
        System.out.println( "" );

        System.exit( result.wasSuccessful() ? 0 : 1);
    }
}
