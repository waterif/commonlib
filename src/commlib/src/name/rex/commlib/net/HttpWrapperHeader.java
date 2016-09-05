package name.rex.commlib.net;

import java.util.List;
import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;

public class HttpWrapperHeader
{
    public static class Parameter
    {
        public String name;
        public String value;

        public Parameter()
        {
        }

        public Parameter( String name, String value )
        {
            this.name = name;
            this.value = value;
        }
    }

    public String name;
    public String value;
    private boolean parsed = false;
    public  List<Parameter> parameters;

    public HttpWrapperHeader()
    {
    }

    public HttpWrapperHeader( String name, String value )
    {
        this.name = name;
        this.value = value;
    }

    private void parseParameter()
    {   
        if ( null != parameters 
                || null == value 
                || StringUtils.trimToEmpty( value ).isEmpty() )
        {
            return;
        }

        String items[] = StringUtils.split( 
                StringUtils.trimToEmpty( StringUtils.substringBefore( value, "," ) ), 
                ";" );

        parameters = new ArrayList<Parameter>();

        for( int n = 0; n < items.length; n++ )
        {
            String item = StringUtils.trimToEmpty( items[ n ] );

            if ( StringUtils.isBlank( item ) )
            {
                continue;
            }

            String arr[] = StringUtils.split( item,  "=" );
            String k = StringUtils.trimToEmpty( arr[ 0 ] );
            String v = ( arr.length > 1 ) ? StringUtils.trimToEmpty( arr[ 1 ] ): null;

            if ( null == v )
            {
                if ( 0 == n )
                {
                    v = k;
                    k = null;
                }
            }

            parameters.add( new Parameter( k, v ) );
        }
    }

    private String getParameter( String name, boolean ignoreCase )
    {
        parseParameter();

        if ( null != parameters )
        {
            for( Parameter p : parameters )
            {
                if ( ignoreCase )
                {
                    if ( StringUtils.equalsIgnoreCase( p.name, name ) )
                    {
                        return p.value;
                    }
                }
                else
                {
                    if ( StringUtils.equals( p.name, name ) )
                    {
                        return p.value;
                    }
                }
            }
        }

        return null;
    }

    public String getParameterIgnoreCase( String name )
    {
        return getParameter( name, true );
    }

    public String getParameter( String name )
    {
        return getParameter( name, false );
    }

    private String[] getParameters( String name, boolean ignoreCase )
    {
        List<String> res = null;

        parseParameter();

        if ( null != parameters )
        {
            for( Parameter p : parameters )
            {
                boolean bequal;

                if ( ignoreCase )
                {
                    bequal = StringUtils.equalsIgnoreCase( p.name, name );
                }
                else
                {
                    bequal = StringUtils.equals( p.name, name );
                }

                if ( bequal )
                {
                    if ( null == res )
                    {
                        res = new ArrayList<String>();
                    }

                    res.add ( p.value );
                }
            }
        }

        return res.toArray( new String[0] );
    }

    public String[] getParameters( String name )
    {
        return getParameters( name, false );
    }

    public String[] getParametersIgnoreCase( String name )
    {
        return getParameters( name, true );
    }

    public Parameter[] getParameters()
    {
        parseParameter();

        return ( null != parameters ) ? parameters.toArray( new Parameter[0] ) : null;
    }
}
