package name.rex.commlib.dataobj;

public class HostAndPort
{
    public String  host;
    public Integer port;

    public HostAndPort()
    {

    }

    public HostAndPort( String host, int port )
    {
        this.host = host;
        this.port = port;
    }
}
