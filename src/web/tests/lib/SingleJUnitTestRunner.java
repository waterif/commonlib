import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.Failure;

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
    public static void main( String... args ) throws ClassNotFoundException 
    {
        String[] classAndMethod = args[0].split("#");

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
