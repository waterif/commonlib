package com.quanshi.uclib.service;

import java.util.List;

import com.quanshi.uclib.service.dataobject.AccountActiveCallback;
import com.quanshi.uclib.service.dataobject.BossActiveAccountArg;
import com.quanshi.uclib.service.dataobject.BossActiveAccountSellingProductsArg;
import com.quanshi.uclib.service.dataobject.CreateAndUpdateSellingProductArg;
import com.quanshi.uclib.service.dataobject.ProductInfo;
import com.quanshi.uclib.service.dataobject.SellingProductInfo;
import com.quanshi.uclib.service.dataobject.BossDataObjects.CustomerInfo;

public class BossService extends JsonService
{
	/**
	 * uc 产品id
	 */
	public static final int UC_PRODUCT_ID = 20;
	
	public static final String ALLOW_USER_VOICE_STATUS_VOIP = "2";
	
	public static final String ALLOW_USER_VOICE_STATUS_PHONE_VOIP = "0";
	
	private final String URI_CUSTOMER_INFO = "/core-service/api/customers/getCustomerInfo?customerCode=%s";
	
    private final String URI_ACTIVE_ACCOUNT = "/core-service/api/actives/combinedActive";
    
	private final String URI_SELLING_PRODUCT_TEMPLATES_INFO = "/core-service/api/contractComponentProps/getContractTemplateProps/%d?uuid=%s&sellProdId=%s";
	private final String URI_GET_CONTRACT_COMPONENT_PROPS = "/core-service/api/contractComponentProps/getByContractIdAndUuid?contractId=%d&uuid=%s&sellProdId=%s";
	private final String URI_CREATE_CONTRACT_COMPONENT_PROPS = "/core-service/api/contractComponentProps/combinedBatchCreateContractComponentProps";
	private final String URI_MODIFY_CONTRACT_COMPONENT_PROPS = "/core-service/api/contractComponentProps/combinedBatchModifyContractComponentProps";

	private String bossServer = "";

	public BossService( String serverUrl )
	{
		super();
		bossServer = serverUrl;
	}

	/**
	 * 获取企业信息
	 * 
	 * @param customerCode
	 * @return
	 * @throws ServiceException
	 */
	public CustomerInfo getCustomerInfo( String customerCode ) throws ServiceException
	{
		String url = bossServer + String.format( URI_CUSTOMER_INFO, customerCode );

		return getObject( url, CustomerInfo.class );
	}

	// 不支持
	public void setCustomerInfo()
	{

	}
    
    public String  activeAccount( BossActiveAccountArg arg ) throws ServiceException
    {
        String url = bossServer + URI_ACTIVE_ACCOUNT;
        
        return this.postJsonContent( url, arg );
    }
    
	public List<ProductInfo> getSellingProductTemplates( long contractId ) throws ServiceException
	{
		String url = bossServer + String.format( URI_SELLING_PRODUCT_TEMPLATES_INFO, contractId, "", "" );

		return getArray( url, ProductInfo.class );
	}
    
    public List<SellingProductInfo> getSellingProductTemplates( Long contractId, String uuid, Long sellProdId ) throws ServiceException
    {
        String url = bossServer + String.format( 
                URI_SELLING_PRODUCT_TEMPLATES_INFO, 
                contractId,
                uuid == null ? "" : uuid, 
                sellProdId == null ? "" : sellProdId );

        return getArray( url, SellingProductInfo.class );
    }
    
    public List<SellingProductInfo> getContractComponentProps( Long contractId, String uuid, Long sellProdId ) throws ServiceException
    {
        String url = bossServer + String.format( URI_GET_CONTRACT_COMPONENT_PROPS, contractId, uuid == null ? "" : uuid, sellProdId == null ? "" : sellProdId );
		try
		{
			return getArray( url, SellingProductInfo.class );
		}
		catch ( ServiceException e )
		{
			if ( e.getStatusCode() == 404 )
			{
				return null;
			}

			throw e;
		}
    }
    
    public String combinedBatchCreateContractComponentProps( CreateAndUpdateSellingProductArg arg ) throws ServiceException
    {
        String url = bossServer + URI_CREATE_CONTRACT_COMPONENT_PROPS;
        
        return postJsonContent( url, arg );
    }
    
    public String combinedBatchModifyContractComponentProps( CreateAndUpdateSellingProductArg arg ) throws ServiceException
    {
        String url = bossServer + URI_MODIFY_CONTRACT_COMPONENT_PROPS;

        return putJsonContent( url, arg );
    }
    
    public String accountActiveCallback( String url, AccountActiveCallback data ) throws ServiceException
    {
        return postJsonContent( url, data );
    }
    
    public String activeAccountSellingProduct( BossActiveAccountSellingProductsArg arg ) throws ServiceException
    {
        String url = bossServer + URI_ACTIVE_ACCOUNT;

        return this.postJsonContent( url, arg );
    }
}
