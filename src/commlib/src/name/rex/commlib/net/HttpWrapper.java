package name.rex.commlib.net;

import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.NameValuePair;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.util.EntityUtils;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;

import java.security.cert.Certificate;  
import java.security.cert.CertificateException;  
import java.security.cert.CertificateFactory;  
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;  
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.HostnameVerifier;  
import javax.net.ssl.SSLSession;

import name.rex.commlib.format.JSONHelper;
import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

class MyX509TrustManager implements X509TrustManager 
{  
  
    public void checkClientTrusted( X509Certificate[] chain, String authType )  
            throws CertificateException 
    {  

    }  
  
    public void checkServerTrusted( X509Certificate[] chain, String authType )  
            throws CertificateException 
    {  

    }  
  
    public X509Certificate[] getAcceptedIssuers()
    {
        return null;
    }  
}

class MyVerifyHostname implements HostnameVerifier 
{  
    public boolean verify( String arg0, SSLSession arg1 ) 
    {  
        return true;  
    }  
} 

class HttpWrapperProxy
{
    public String hostname;
    public int    port;
    public String scheme;

    public HttpWrapperProxy( String hostname, int port, String scheme )
    {
        this.hostname = hostname;
        this.port = port;
        this.scheme = scheme;
    }

    public HttpHost getHttpHost()
    {
        return new HttpHost( hostname, port, scheme );
    }
}

public class HttpWrapper
{
    public static ThreadLocal<String>   localError = new ThreadLocal<String>();
    public static ThreadLocal<HttpWrapperProxy> localProxy = new ThreadLocal<HttpWrapperProxy>();
    public static Logger log = LoggerFactory.getLogger( HttpWrapper.class );

    public static String buildQuery( Map<String, ? extends Object> params )
    {
        try
        {
            StringBuilder res = new StringBuilder();

            if ( null != params && params.size() > 0 )
            {
                int begin = 1;
                Set<String> keys = params.keySet();
                
                for( String k: keys )
                {
                    if ( begin == 1 )
                    {
                        begin = 0;
                    }
                    else
                    {
                        res.append( "&" );
                    }
    
                    res.append( k ).append( "=" ).
                        append( URLEncoder.encode( String.valueOf( params.get( k ) ), "UTF-8" ) );
                }
            }

            return res.toString();
        }
        catch( Exception e )
        {
            log.error( e.getMessage(), e );
            return null;
        }
    }

    public static String buildURL( String url, Map<String, ? extends Object> params )
    {
        String res = url;

        if ( null != params && 0 < params.size() )
        {
            String query = buildQuery( params );
            
            if ( null == query )
            {
                return  null;
            }

            if ( null != res && ! res.isEmpty() )
            {
                int pos = res.indexOf( '?' );

                if ( -1 == pos )
                {
                    res += "?";
                }
                else if ( res.length() - 1 == pos )
                {
                    ;
                }
                else
                {
                    if ( '&' != res.charAt( res.length() - 1 ) )
                    {
                        res += "&";
                    }
                }
            }

            res += query;
        }

        return res;
    }


    public static void setError( String errMsg )
    {
        localError.set( errMsg );
    }

    public static String getError()
    {
        return localError.get();
    }

    public static void clearError()
    {
        localError.remove();
    }

    public static void setProxy( String hostname, int port, String scheme )
    {
        localProxy.set( new HttpWrapperProxy( hostname, port, scheme ) );
    }

    public static void clearProxy()
    {
        log.debug( "clear proxy" );
        localProxy.remove();
    }

    public static HttpWrapperRes request( String methodName, 
            String url,
            HttpEntity entity, 
            List<HttpWrapperHeader> requestHeader, 
            int flags, HttpWrapperCallback callback ) 
    {
        HttpWrapperRes res = null;
        CloseableHttpResponse response = null;
        HttpClientBuilder clientBuilder = null;
        CloseableHttpClient client = null;
        
        try
        {
            HttpUriRequest reqInstance = null;

            if( 0 == methodName.compareToIgnoreCase( "GET" ) )
            {
                log.debug( "HTTP request GET url: " + url );
                HttpGet httpget = new HttpGet( url );
                reqInstance = httpget;
            }
            else if ( 0 == methodName.compareToIgnoreCase( "DELETE" ) )
            {
            	 log.debug( "HTTP request DELETE url: " + url );
            	 HttpDelete httpdelete = new HttpDelete( url );
                 reqInstance = httpdelete;
            }
            else if ( 0 == methodName.compareToIgnoreCase( "PUT" )
                    || 0 == methodName.compareToIgnoreCase( "POST" ) )
            {
                HttpEntityEnclosingRequestBase entityRequest = null;

                if ( 0 == methodName.compareToIgnoreCase( "PUT" ) )
                {
            	    log.debug( "HTTP request PUT url: " + url );
                    HttpPut httpput = new HttpPut( url );
            	    entityRequest = new HttpPut( url );
                }
                else if ( 0 == methodName.compareToIgnoreCase( "POST" ) )
                {
                    log.debug( "HTTP request POST url: " + url );
                    HttpPost httppost = new HttpPost( url );
                    entityRequest = httppost;
                }

                if ( null != entity && null != entity.getContentType() )
                {
                    if ( log.isDebugEnabled() )
                    {
                        String debugLog = "Request BODY DATA:";
                        String contentTypeValue = entity.getContentType().getValue();
                        debugLog  += "; Content-Type: " + contentTypeValue;

                        if ( -1 != contentTypeValue.indexOf( "application/x-www-form-urlencoded" ) 
                                || -1 != contentTypeValue.indexOf( "application/json" )
                                || -1 != contentTypeValue.indexOf( "text/" ))
                        {
                            String entityString = EntityUtils.toString( entity );
                            if ( null != entityString )
                            {
                                if ( entityString.length() > 500 )
                                {
                                    debugLog += "; Length: " + entityString.length() + "; Data: " 
                                        + entityString.substring( 0, 500 );
                                }
                                else
                                {
                                    debugLog += "; Length: " + entityString.length() + "; Data: " 
                                        + entityString;
                                }
                            }
                        }

                        log.debug( debugLog );
                    }
                    
                    entityRequest.setEntity( entity );
                }

                reqInstance = entityRequest;
            }
            else
            {
                String errMsg = "HTTP request failed, not support method: " + methodName;
                
                log.error( errMsg );
                setError( errMsg );

                return null;
            }

            if ( null != requestHeader )
            {
                for( HttpWrapperHeader h: requestHeader )
                {
                    if ( null != h.name && ! h.name.isEmpty() )
                    {
                        reqInstance.addHeader( h.name, h.value );
                    }
                }
            }

            // 创建Client Builder
            clientBuilder = HttpClients.custom();
            if ( null == clientBuilder )
            {
                String errMsg = "create http client builder failed.";

                log.error( errMsg );
                setError( errMsg );

                return null;
            }

            if ( url.toLowerCase().startsWith( "https" ) )
            {
                log.debug( "create ssl client builder" );

                X509TrustManager tm = new MyX509TrustManager();
                SSLContext sslContext = SSLContext.getInstance("TLS");  

                sslContext.init( null, 
                            new TrustManager[] { tm },  
                            new java.security.SecureRandom() );

                clientBuilder = clientBuilder
                        .setSSLHostnameVerifier( new MyVerifyHostname() )   
                        .setSSLContext( sslContext ); 

                if ( null == clientBuilder )
                {
                    String errMsg = "create http ssl client builder failed.";

                    log.error( errMsg );
                    setError( errMsg );

                    return null;
                }
            }

            if ( null != localProxy.get() )
            {
                log.debug( "create proxy client builder: " + JSONHelper.toJSONString( localProxy.get() ) );

                clientBuilder = clientBuilder.setProxy( localProxy.get().getHttpHost() );

                if ( null == clientBuilder )
                {
                    String errMsg = "create http proxy client builder failed.";

                    log.error( errMsg );
                    setError( errMsg );

                    return null;
                }
            }

            // 创建 Http Client
            client = clientBuilder.build();
            if ( null == client )
            {
                String errMsg = "create http client failed";

                log.error( errMsg );
                setError( errMsg );
                
                return null;
            }
           
            response = client.execute( reqInstance );

            // 清理代理
            if ( null != localProxy.get() )
            {
                clearProxy();
            }

            /* 处理结果 */
            res = HttpWrapperRes.processResponse( response, flags, callback );

            /* 输出日志 */
            if ( res.isValidStatus() )
            {
                log.debug( String.format( "Http Response(%d, type: %s;%s) content:", 
                            res.status, res.type, res.charset ) + res.content );
            }
            else
            {
                log.warn( String.format( "Http Response(%d, type: %s;%s) content:", 
                            res.status, res.type, res.charset ) + res.content );
            }

            // 关闭连接
            client.close();

            return res;
        }
        catch( Exception e )
        {
            String errMsg = "HTTP request failed, " + methodName + " url: " + url + ", exception:" + e.getMessage();

            log.error( errMsg );
            setError( errMsg );

            return null;
        }
        finally
        {
            // 清理代理
            if ( null != localProxy.get() )
            {
                clearProxy();
            }

            if ( null != client )
            {
                try
                {
                    client.close();
                }
                catch( Exception e )
                {
                }
            }
        }
    }

    public static HttpWrapperRes request( String methodName, 
            String url,
            HttpEntity entity, 
            List<HttpWrapperHeader> requestHeader,
            Boolean returnHead ) 
    {
        int flags = HttpWrapperRes.FLAG_PROCESS_DATA;

        flags |= ( returnHead ) ? HttpWrapperRes.FLAG_RETURN_HEADER : 0;

        return request( methodName, url, entity, requestHeader, flags, null );
    }

    public static HttpWrapperRes requestBinary( String methodName, String url, 
            byte[] body, String contentType,
            List<HttpWrapperHeader> requestHeader, 
            int flags, HttpWrapperCallback callback  )
    {
        ByteArrayEntity entity = null;

        try
        {
            if ( 0 == methodName.compareToIgnoreCase( "POST" ) )
            {
                if ( null != body )
                {
                    entity = new ByteArrayEntity( body );
                    entity.setContentType( contentType );
                }
            }
        }
        catch( Exception e )
        {
            log.error( "HTTP request failed, " + methodName + " url: " + url + ", " + e.getMessage() );
            return null;
        }
        
        return request( methodName, url, entity, requestHeader, flags, callback );
    }

    public static HttpWrapperRes requestBinary( String methodName, String url, 
            byte[] body, String contentType,
            List<HttpWrapperHeader> requestHeader,
            Boolean returnHead )
    {
        int flags = HttpWrapperRes.FLAG_PROCESS_DATA;

        flags |= ( returnHead ) ? HttpWrapperRes.FLAG_RETURN_HEADER : 0;

        return requestBinary( methodName, url, body, contentType, requestHeader, flags, null );
    }

    public static HttpWrapperRes requestText( String methodName, String url, 
            String body, String contentType,
            List<HttpWrapperHeader> requestHeader, 
            int flags, HttpWrapperCallback callback )
    {
        StringEntity entity = null;

        try
        {
            if ( ( "PUT".equalsIgnoreCase( methodName ) ) || ( "POST".equalsIgnoreCase( methodName ) ) )
            {
                if ( null != body )
                {
                    entity = new StringEntity( body, "utf-8" );
                    entity.setContentEncoding( "UTF-8" );

                    if ( contentType != null )
                    {
                        if ( contentType.toLowerCase().contains( "charset" ) )
                        {
                            entity.setContentType( contentType );
                        }
                        else
                        {
                            Header header = new BasicHeader( "Content-Type", contentType + ";charset=UTF-8" );
                            entity.setContentType( header );
                        }
                    }
                }
            }
        }
        catch( Exception e )
        {
            log.error( "HTTP request failed, " + methodName + " url: " + url + ", " + e.getMessage() );
            return null;
        }
        
        return request( methodName, url, entity, requestHeader, flags, callback );
    }

    public static HttpWrapperRes requestText( String methodName, String url, 
            String body, String contentType,
            List<HttpWrapperHeader> requestHeader,
            Boolean returnHead )
    {
        int flags = HttpWrapperRes.FLAG_PROCESS_DATA;

        flags |= ( returnHead ) ? HttpWrapperRes.FLAG_RETURN_HEADER : 0;

        return requestText( methodName, url, body, contentType, requestHeader, flags, null );
    }

    //GET
    public static HttpWrapperRes get( String url,
            List<HttpWrapperHeader> requestHeader, 
            int flags, HttpWrapperCallback callback )
    {
        return requestText( "GET", url, null, null, requestHeader, flags, callback );
    }

    public static HttpWrapperRes get( String url,
            List<HttpWrapperHeader> requestHeader,
            Boolean returnHead )
    {
        int flags = HttpWrapperRes.FLAG_PROCESS_DATA;

        flags |= ( returnHead ) ? HttpWrapperRes.FLAG_RETURN_HEADER : 0;

        return get( url, requestHeader, flags, null );
    }

    // POST
    public static HttpWrapperRes postText( String url, 
            String body, String contentType,
            List<HttpWrapperHeader> requestHeader, 
            int flags, HttpWrapperCallback callback )
    {
        return requestText( "POST", url, body, contentType, requestHeader, flags, callback );
    }

    public static HttpWrapperRes postText( String url, 
            String body, String contentType,
            List<HttpWrapperHeader> requestHeader,
            Boolean returnHead )
    {
        int flags = HttpWrapperRes.FLAG_PROCESS_DATA;

        flags |= ( returnHead ) ? HttpWrapperRes.FLAG_RETURN_HEADER : 0;

        return postText( url, body, contentType, requestHeader, flags, null );
    }

    public static HttpWrapperRes postData( String url, byte[] arrData, 
            String strContentType,
            List<HttpWrapperHeader> requestHeader, 
            int flags, HttpWrapperCallback callback )
    {
        ByteArrayEntity entity = null;

        try
        {
            entity = new ByteArrayEntity( arrData );
            entity.setContentType( strContentType );
        }
        catch( Exception e )
        {
            log.error( "HTTP Encode failed, POST url: " + url + ", " + e.getMessage() );
            return null;
        }

        return request( "POST", url, entity, requestHeader, flags, callback );
    }

     public static HttpWrapperRes postData( String url, byte[] arrData, 
            String strContentType,
            List<HttpWrapperHeader> requestHeader,
            Boolean returnHead )
    {
        int flags = HttpWrapperRes.FLAG_PROCESS_DATA;

        flags |= ( returnHead ) ? HttpWrapperRes.FLAG_RETURN_HEADER : 0;

        return postData( url, arrData, strContentType, requestHeader, flags, null );
    }

    public static HttpWrapperRes postJson( String url, Object object,
            List<HttpWrapperHeader> requestHeader, 
            int flags, HttpWrapperCallback callback )
    {
        String strBody = null;

        if ( null != object )
        {
            strBody = JSONHelper.toJSONString( object );
            if ( null == strBody )
            {
                return null;
            }
        }
        
        return requestText( "POST", url, strBody, "application/json; charset=utf-8", 
                requestHeader, flags, callback );
    }

    public static HttpWrapperRes postJson( String url, Object object,
            List<HttpWrapperHeader> requestHeader,
            Boolean returnHead )
    {
        int flags = HttpWrapperRes.FLAG_PROCESS_DATA;

        flags |= ( returnHead ) ? HttpWrapperRes.FLAG_RETURN_HEADER : 0;

        return postJson( url, object, requestHeader, flags, null );
    }

    public static HttpWrapperRes postParam( String url, Map<String, ? extends Object> params,
            List<HttpWrapperHeader> requestHeader, 
            int flags, HttpWrapperCallback callback )
    {
        StringEntity entity = null;
          
        try 
        {  
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
            Set<String> keySet = params.keySet();

            for( String key : keySet ) 
            {  
                nvps.add( new BasicNameValuePair( key, String.valueOf( params.get(key) ) ) );
            }
            
            entity = new UrlEncodedFormEntity( nvps, "UTF-8" );
        } 
        catch( UnsupportedEncodingException e ) 
        {  
            log.error( "HTTP Encode failed, POST url: " + url + ", " + e.getMessage() );
            return null;
        } 

        return request( "POST", url, entity, requestHeader, flags, callback );
    }

    public static HttpWrapperRes postParam( String url, Map<String, ? extends Object> params,
            List<HttpWrapperHeader> requestHeader,
            Boolean returnHead )
    {
        int flags = HttpWrapperRes.FLAG_PROCESS_DATA;

        flags |= ( returnHead ) ? HttpWrapperRes.FLAG_RETURN_HEADER : 0;

        return postParam( url, params, requestHeader, flags, null );
    }

    // PUT
    public static HttpWrapperRes putText( String url, 
            String body, String contentType,
            List<HttpWrapperHeader> requestHeader,
            Boolean returnHead )
    {
        return requestText( "put", url, body, contentType, requestHeader, returnHead );
    }

    public static HttpWrapperRes putData( String url, byte[] arrData, 
            String strContentType,
            List<HttpWrapperHeader> requestHeader,
            Boolean returnHead )
    {
        ByteArrayEntity entity = null;

        try
        {
            entity = new ByteArrayEntity( arrData );
            entity.setContentType( strContentType );
        }
        catch( Exception e )
        {
            log.error( "HTTP Encode failed, PUT url: " + url + ", " + e.getMessage() );
            return null;
        }

        return request( "PUT", url, entity, requestHeader, returnHead );
    }

    public static HttpWrapperRes putJson( String url, Object object, 
            List<HttpWrapperHeader> requestHeader, Boolean returnHead )
    {
        String strBody = null;

        if ( null != object )
        {
            strBody = JSONHelper.toJSONString( object );
            if ( null == strBody )
            {
                return null;
            }
        }
        
        return requestText( "PUT", url, strBody, "application/json", requestHeader, returnHead );
    }
    
    public static HttpWrapperRes putParam( String url, Map<String, ? extends Object> params, 
            List<HttpWrapperHeader> requestHeader, Boolean returnHead )
    {
        StringEntity entity = null;
          
        try 
        {  
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
            Set<String> keySet = params.keySet();  
            for( String key : keySet ) 
            {  
                nvps.add( new BasicNameValuePair( key, String.valueOf( params.get(key) ) ) );
            }
            
            entity = new UrlEncodedFormEntity( nvps, "UTF-8" );
        } 
        catch( UnsupportedEncodingException e ) 
        {  
            log.error( "HTTP Encode failed, POST url: " + url + ", " + e.getMessage() );
            return null;
        } 

        return request( "PUT", url, entity, requestHeader, returnHead );
    }
    
    public static HttpWrapperRes delete( String url,
            List<HttpWrapperHeader> requestHeader,
            Boolean returnHead )
    {      
        return request( "DELETE", url, null, requestHeader, returnHead );
    }
}
