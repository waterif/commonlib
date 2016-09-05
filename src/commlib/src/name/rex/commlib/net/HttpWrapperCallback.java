package name.rex.commlib.net;

import java.io.InputStream;

public interface HttpWrapperCallback
{
    public void processData( HttpWrapperRes result, InputStream inputStream );
}
