package name.rex.commlib.net;

import java.util.List;
import java.util.ArrayList;

public class HttpWrapperHeaderBuilder
{
    List<HttpWrapperHeader> listHeader;

    public HttpWrapperHeaderBuilder()
    {
        listHeader = new ArrayList<HttpWrapperHeader>();
    }

    public void addHeader( String name, String value )
    {
        HttpWrapperHeader h = new HttpWrapperHeader( name, value );

        listHeader.add( h );
    }

    public List<HttpWrapperHeader> getHeaderList()
    {
        if ( listHeader.size() > 0 )
        {
            return listHeader;
        }

        return null;
    }
}
