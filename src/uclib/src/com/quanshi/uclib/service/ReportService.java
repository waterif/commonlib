package com.quanshi.uclib.service;

import java.util.Map;
import java.util.Map.Entry;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;

import com.quanshi.uclib.service.dataobject.MonthlistResult;

public class ReportService extends JsonService
{
	public static Logger log = LoggerFactory.getLogger( ReportService.class );
	
	private static final String URI_REPORT_MONTHLIST  = "/statistic/api/account/monthlist?siteId=%d&customerCode=%s&monthcount=12";


	private String serverUrl = null;

	public ReportService( String serverUrl )
	{
		super();
		this.serverUrl = serverUrl;
	}
	


    public Object sendRedirect( String url, Map<String, String[]> params ) throws ServiceException
    {

        String serverUrl = this.serverUrl + url;

        if ( null != params && !params.isEmpty() )
        {
            serverUrl += "?";
            for ( Entry<String, String[]> entry : params.entrySet() )
            {
                if ( null != entry.getValue() && 0 < entry.getValue().length)
                {
                    serverUrl += entry.getKey() + "=" + entry.getValue()[0] + "&";
                }
            }
            serverUrl = serverUrl.substring( 0, serverUrl.length() - 1 );
        }

        log.info( String.format( "sendRedirect:%s", serverUrl ) );

        return getContent( serverUrl );
    }
	
    /**
     * 查询蜜蜂用户每月活跃用户数
     * @param siteId 站点id
     * @param customerCode 客户编码
     * @return 每月用户活跃数
     * @throws ServiceException
     */
    public MonthlistResult monthlist( Integer siteId, String customerCode ) throws ServiceException
    {

        String url = serverUrl + String.format( URI_REPORT_MONTHLIST, siteId, customerCode );

        log.info( "monthlist request:" + url );

        return getObject( url, MonthlistResult.class );

    }

}