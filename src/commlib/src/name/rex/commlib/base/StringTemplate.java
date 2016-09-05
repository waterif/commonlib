package name.rex.commlib.base;

import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.lang.StringUtils;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

public class StringTemplate
{
    private static final Logger log = LoggerFactory.getLogger( StringTemplate.class );
    private String content;
    private Map<String, String> mapValues;

    public StringTemplate()
    {
        this.mapValues = new TreeMap<String, String>();
    }

    public StringTemplate( String content )
    {
        this.content = content;
        this.mapValues = new TreeMap<String, String>();
    }

    public StringTemplate( String content, Map<String, String> mapValues )
    {
        this.content = content;
        this.mapValues = new TreeMap<String, String>();

        setValues( mapValues );
    }

    public void setContent( String content )
    {
        this.content = content;
    }

    public void setValues( Map<String, String> mapValues )
    {
        if ( null != mapValues )
        {
            for( String k: mapValues.keySet() )
            {
                addValue( k, mapValues.get( k ) );
            }
        }
    }

    public void addValue( String k, String v )
    {
        if ( ! StringUtils.isBlank( k ) )
        {
            this.mapValues.put( k, ( null != v ) ? v : "" );
        }
    }

    public String render()
    {
        if ( StringUtils.isBlank( content ) 
                || null == mapValues 
                || 0 == mapValues.size() )
        {
            return content;
        }

        String result = content;

        for( String k: mapValues.keySet() )
        {
            result = StringUtils.replace( result, k, mapValues.get( k ) );
        }

        return result;
    }

    public static String render( String content, String k, String v )
    {
        return StringUtils.replace( content, k , v );
    }

    public static String render( String content , Map<String, String> values )
    {
        StringTemplate st = new StringTemplate( content, values );

        return st.render();
    }
}
