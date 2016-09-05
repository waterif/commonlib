package name.rex.confgen;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import javax.xml.bind.annotation.XmlRootElement;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import name.rex.commlib.io.FileHelper;
import name.rex.commlib.format.JSONHelper;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import name.rex.commlib.net.HttpWrapper;
import name.rex.commlib.net.HttpWrapperRes;
import name.rex.commlib.util.StringHelper;

public class Main
{
    @XmlRootElement
    public static class Config
    {
        public String sourceUrl;
    }

    public static class Options
    {
        public String show;
        public String configFile;
        public String toFormat;
        public String defaultFile;
        public String localFile;
        public String inputFile;
        public String outputFile;

        public Options()
        {
        }
    }

    public static class ConfigValue
    {
        public String value;
    }

    private static Logger log = LoggerFactory.getLogger( Main.class );
    private static Main _mainInstance = new Main();
    private static Set<String> setFormat = null;
    private static Set<String> setShow = null;
    private static String homePath = null;

    static 
    {
        setFormat = new HashSet<String>();
        setFormat.add( "xml" );
        setFormat.add( "json" );
        setFormat.add( "text" );

        setShow = new HashSet<String>();
        setShow.add( "default" );
        setShow.add( "remote" );
        setShow.add( "local" );
        setShow.add( "all" );

        try
        {
            homePath = System.getenv( "CONFGEN_HOME" );
            if ( StringUtils.isBlank( homePath ) )
            {
                throw new Exception( "CONFGEN_HOME is null." );
            }
        }
        catch( Exception e )
        {
            homePath = "/usr/local/confgen";
        }
    }

    public Options options = new Options();
    public Config  config = null;
    public Map<String, ConfigValue> defaultValues = null;
    public Map<String, ConfigValue> remoteValues = null;
    public Map<String, ConfigValue> localValues = null;
    public Map<String, ConfigValue> mapValues = new TreeMap<String, ConfigValue>();

    public Main()
    {

    }

    public static Main getInstance()
    {
        return _mainInstance;
    }

    private void printUsage()
    {
        System.out.println( "Usage: java name.rex.confgen.Main [options] <input file> <output file>" );
        System.out.println( "   Option: " );
        System.out.println( "      -d <default db file>, set deafult database json file." );
        System.out.println( "      -f <config file>,     set configure file, " );
        System.out.println( String.format( "             default: %s/etc/confgen.xml.", homePath ) );
        System.out.println( "      -l <local db file>,   set local database json file." );
        System.out.println( String.format( "             default: %s/etc/local.json.", homePath ) );
        System.out.println( "      -s <dbname>,          show config datbase, dbname: default, remote, local, all." );
        System.out.println( String.format( "             default: all." ) );
        System.out.println( "      -t <format>,          set default output format, " );
        System.out.println( "                               format: xml, json, text, default: text." );
        System.out.println( "      -h, show this message." );
        System.out.println( "" );
    }
    
    private boolean getOption( String args[] )
    {
        int n = 0; 
        List<String> listArgs = new ArrayList<String>();

        while ( n < args.length )
        {
            String v = args[ n ].trim();
            
            if ( v.startsWith( "-" ) )
            {
                if ( "-d".equals( v ) )
                {
                    if( n == args.length - 1 )
                    {
                        System.out.println( "Error: default db file option has no argument." );
                        return false;
                    }

                    n++;
                    options.defaultFile = args[ n ];
                }
                else if ( "-f".equals( v ) )
                {
                    if( n == args.length - 1 )
                    {
                        System.out.println( "Error: configure file option has no argument." );
                        return false;
                    }

                    n++;
                    options.configFile = args[ n ];
                }
                else if ( "-l".equals( v ) )
                {
                    if( n == args.length - 1 )
                    {
                        System.out.println( "Error: local db file option has no argument" );
                        return false;
                    }

                    n++;
                    options.localFile = args[ n ];
                }
                else if ( "-s".equals( v ) )
                {
                    if( n == args.length - 1 )
                    {
                        System.out.println( "Error: show option has no argument." );
                        return false;
                    }

                    n++;
                    options.show = args[ n ];
                }
                else if ( "-t".equals( v ) )
                {
                    if( n == args.length - 1 )
                    {
                        System.out.println( "Error: ouput format option has no argument." );
                        return false;
                    }

                    n++;
                    options.toFormat = args[ n ];
                }
                else if ( "-h".equals( v ) )
                {
                    printUsage();
                    return false;
                }
                else
                {
                    System.out.println( "Error: invalid option " + v );
                    printUsage();
                    return false;
                }
            }
            else
            {
                listArgs.add( v );
            }

            n++;
        }

        // 处理默认值, 参数检查
        if ( StringUtils.isBlank( options.configFile ) )
        {
            options.configFile = homePath + "/etc/confgen.xml";
        }

        if ( StringUtils.isBlank( options.toFormat ) )
        {
            options.toFormat = "text";
        }
        else
        {
            if ( ! setFormat.contains( options.toFormat ) )
            {
                System.out.println( "Error: invalid output format" );
                return false;
            }
        }

        if ( ! StringUtils.isBlank( options.defaultFile )
                            && ! FileHelper.isFile( options.defaultFile ) )
        {
            System.out.println( String.format( "Error: default db file %s is not exist.", 
                        options.defaultFile ) );
            return false;
        }

        if ( ! StringUtils.isBlank( options.localFile ) )
        {
            if ( ! FileHelper.isFile( options.localFile ) )
            {
                System.out.println( String.format( "Error: local db file %s is not exist.", 
                            options.localFile ) );
                return false;
            }
        }
        else
        {
            if ( FileHelper.isFile( homePath + "/etc/local.json" ) )
            {
                options.localFile = homePath + "/etc/local.json";
            }
        }

        

        //
        if ( ! StringUtils.isBlank( options.show ) )
        {
            if ( ! setShow.contains( options.show ) )
            {
                System.out.println( "Error: invalid show option" );
                return false;
            }
        }
        else
        {

            if ( listArgs.size() != 2 )
            {
                System.out.println( "Error: invalid input file or output file arguments." );
                printUsage();
                return false;
            }

            options.inputFile = listArgs.get( 0 ).trim();
            options.outputFile = listArgs.get( 1 ).trim();

            if ( StringUtils.isBlank( options.inputFile ) 
                || ! FileHelper.isFile( options.inputFile ) )
            {
                System.out.println( String.format( "Error: input file %s is not exist.", 
                        options.inputFile ) );
                return false;
            }
        }

        return true;
    }

    private boolean loadConfig()
    {
        String configFile = options.configFile;

        if ( ! FileHelper.isFile( configFile ) )
        {
            System.out.println( String.format( "Error: config file %s is not exist.",
                        options.configFile ) );
            return false;
        }

        config = FileHelper.loadXmlFromFile( configFile, Config.class );
        
        if ( null == config )
        {
            System.out.println( "Error: load config file failed." );
            return false;
        }

        return true;
    }

    private Map<String, ConfigValue> loadValuesFromContent( String content ) throws Exception
    {
        Map<String, ConfigValue> mapValues = new TreeMap<String, ConfigValue>();
        JSONObject jsonObj = JSONHelper.parseObject( content );

        if( null == jsonObj )
        {
            throw new Exception( "content is not invalid json format." );
        }

        Set<String> keys = jsonObj.keySet();

        if ( null == keys )
        {
            throw new Exception( "not found valid key in json object" );
        }

        for( String k: keys )
        {
            if ( StringUtils.isBlank( k ) )
            {
                continue;
            }

            ConfigValue confVal = null;

            try
            {
                confVal = jsonObj.getObject( k, ConfigValue.class );
            }
            catch( Exception e )
            {
                String v = jsonObj.getString( k );

                if ( StringUtils.isBlank( v ) )
                {
                    confVal = new ConfigValue();

                    confVal.value = v;
                }
            }
            
            if ( null != confVal )
            {
                mapValues.put( k, confVal );
            }
        }

        return mapValues;
    }

    private void mergeValues( Map<String, ConfigValue> dstValues, Map<String, ConfigValue> srcValues )
    {
        Set<String> keys = srcValues.keySet();

        if ( null != keys )
        {
            for( String k: keys )
            {
                if ( StringUtils.isBlank( k ) )
                {
                    continue;
                }
        
                dstValues.put( k, srcValues.get( k ) );
            }
        }
    }

    private void showValues( String name, Map<String, ConfigValue> showValues )
    {
        if ( null == showValues || 0 >= showValues.size() )
        {
            System.out.println( String.format( "%s config database is empty.", name ) );
            return;
        }

        System.out.println( String.format( "%s confige database entry( %d ): ", name, showValues.size() ) );

        Set<String> keys = showValues.keySet();

        if ( null != keys )
        {
            int n = 1;
            for( String k: keys )
            {
                if ( StringUtils.isBlank( k ) )
                {
                    continue;
                }

                ConfigValue val = showValues.get( k );
                String v = ( null == val || null == val.value ) ? "null" : val.value;

                System.out.println( String.format( "%d %s => %s", n++, k, v ) );
            }
        }
    }

    private boolean loadDefaultValues()
    {
        String content = FileHelper.readTextFile( options.defaultFile );

        if ( null == content )
        {
            System.out.println( "Warning: read default db file failed." );
            return false;
        }

        try
        {
            defaultValues = loadValuesFromContent( content );

            if ( null != defaultValues )
            {
                mergeValues( mapValues, defaultValues );
            }

            return true;
        }
        catch( Exception e )
        {
            System.out.println( "Warnning: load default db failed: " + e.getMessage() );
            return false;
        }
    }

    private boolean loadRemoteValues()
    {
        HttpWrapperRes res = HttpWrapper.get( config.sourceUrl, null, false );
        
        if ( null == res )
        {
            System.out.println( "Warn: request url " + config.sourceUrl + " failed." );
            return false;
        }

        if ( ! res.isText )
        {
            System.out.println( "Error: response is not text format." );
            return false;
        }

        try
        {
            remoteValues = loadValuesFromContent( res.content );

            if ( null != remoteValues )
            {
                mergeValues( mapValues, remoteValues );
            }

            return true;
        }
        catch( Exception e )
        {
            System.out.println( "Warn: load remote db failed: " + e.getMessage() );
            return false;
        }
    }

    private boolean loadLocalValues()
    {
        String content = FileHelper.readTextFile( options.localFile );

        if ( null == content )
        {
            System.out.println( "Warning: read local db file failed." );
            return false;
        }

        try
        {
            localValues = loadValuesFromContent( content );

            if ( null != localValues )
            {
                mergeValues( mapValues, localValues );
            }

            return true;
        }
        catch( Exception e )
        {
            System.out.println( "Warnning: load local db failed: " + e.getMessage() );
            return false;
        }
    }

    private boolean loadValues()
    {
        if ( ! StringUtils.isBlank( options.defaultFile ) )
        {
            if ( ! loadDefaultValues() )
            {
                return false;
            }
        }

        if ( ! StringUtils.isBlank( config.sourceUrl ) )
        {
            if ( ! loadRemoteValues() )
            {
                return false;
            }
        }

        if ( FileHelper.isFile( options.localFile ) )
        {
            if ( ! loadLocalValues() )
            {
                return false;
            }
        }

        return true;
    }

    private String formatValue( ConfigValue v )
    {
        String res = "";

        if ( null != v && ! StringUtils.isBlank( v.value ) )
        {
            if( "xml".equals( options.toFormat ) )
            {
                res = StringEscapeUtils.escapeXml( v.value );
            }
            else if ( "json".equals( options.toFormat ) )
            {
                res = StringHelper.escapeJson( v.value );
            }
            else
            {
                res = v.value;
            }
        }

        return res;
    }

    private boolean genConfigFile( String inputFile, String outputFile )
    {
        String content = FileHelper.readTextFile( inputFile );

        if ( StringUtils.isBlank( content ) )
        {
            System.out.println( "Error: read input file failed." );
            return false;
        }

        Set<String> keys = mapValues.keySet();

        if ( null == keys )
        {
            return true;
        }

        for( String k: keys )
        {
            if ( StringUtils.isBlank( k ) )
            {
                continue;
            }

            String v = formatValue( mapValues.get( k ) );
            String s = Pattern.quote( "#%" + k + "%#" );

            content = content.replaceAll( s, v );
        }

        if ( ! FileHelper.writeTextFile( outputFile, content ) )
        {
            System.out.println( "Error: write file failed." );
            return false;
        }

        return true;
    }

    private void _main( String args[] ) throws Exception
    {
        if ( ! getOption( args ) )
        {
            System.exit( 1 );
            return;
        }

        //log.debug( "options: " + JSONHelper.toJSONString( options ) );
        //System.out.println( "options: " + JSONHelper.toJSONString( options ) );

        if ( ! loadConfig() )
        {
            System.exit( 2 );
            return;
        }

        log.debug( "config: " + JSONHelper.toJSONString( config ) );

        if ( ! loadValues() )
        {
            System.exit( 3 );
            return;
        }

        if ( ! StringUtils.isBlank( options.show ) )
        {
            if ( "default".equals( options.show ) )
            {
                showValues( "default", defaultValues );
            }
            else if ( "remote".equals( options.show ) )
            {
                showValues( "remote", remoteValues );
            }
            else if ( "local".equals( options.show ) )
            {
                showValues( "local", localValues );
            }
            else
            {
                showValues( "all", mapValues );
            }
            
            return; 
        }

        if ( ! genConfigFile( options.inputFile, options.outputFile ) )
        {
            System.exit( 4 );
            return;
        }
    }

    public static void main( String args[] ) throws Exception
    {
        Main.getInstance()._main( args );
    }
}
