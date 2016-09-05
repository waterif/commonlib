package name.rex.commlib.util;

import java.util.Set;
import java.util.HashSet;
import org.apache.commons.lang.StringUtils;
import name.rex.commlib.dataobj.HostAndPort;

public class NetUtils
{
    public static HostAndPort string2HostAndPort( String server, int defaultPort ) 
    {
        try
        {
            String v[] = server.split( ":" );

            if ( null == v || v.length < 1 )
            {
                return null;
            }

            HostAndPort res = new HostAndPort();

            res.host = v[0].trim();
            if ( v.length > 1 )
            {
                res.port = Integer.valueOf( v[ 1 ].trim() );
            }
            else
            {
                res.port = defaultPort;
            }

            if ( StringUtils.isBlank( res.host )
                    || res.port < 0 || res.port >= 2 << 16  )
            {
                return null;
            }

            return res;
        }
        catch( Exception e )
        {
            return null;
        }
        finally { }
    }

    public static Set<HostAndPort> string2HostAndPortSet( String server, int defaultPort )
    {
        try
        {
            Set<HostAndPort> res = new HashSet<HostAndPort>();
            String[] items = server.split( ";" );

            for( String item: items )
            {
                if ( StringUtils.isBlank( item.trim() ) )
                {
                    continue;
                }

                HostAndPort hp = string2HostAndPort( item.trim(), defaultPort );

                if ( null != hp )
                {
                    res.add( hp );
                }
            }

            return res;
        }
        catch( Exception e )
        {
            return null;
        }
        finally { }
    }
}
