package name.rex.commlib.net;

import java.net.FileNameMap;    
import java.net.URLConnection;  

public class MimeHelper
{
    public static boolean isText( String mimeType )
    {
        if ( null == mimeType || mimeType.isEmpty() )
        {
            return true;
        }

        if ( mimeType.toLowerCase().startsWith( "text/" ) 
                || mimeType.toLowerCase().equals( "application/json" )
                || mimeType.toLowerCase().equals( "application/xml" ) )
        {
            return true;
        }

        return false;
    }

    public static String getMimeType( String fileName )
    {
        try
        {
            FileNameMap fileNameMap = URLConnection.getFileNameMap();    
        
            return fileNameMap.getContentTypeFor( fileName );
        }
        catch( Exception e )
        {
            return null;
        }
    }
}
