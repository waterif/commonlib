package com.quanshi.uclib.service;

import java.util.List;

import name.rex.commlib.format.JSONHelper;

public class ServiceException extends Exception
{
    public static final int ERROR_NETWORK = 1;  // 网络通讯错误
    public static final int ERROR_STATUS = 2;   // HTTP答复不是2xx
    public static final int ERROR_FORMAT = 3;   // 答复数据格式错误
    public static final int ERROR_RESULT = 5;   // 答复结果码不正确
    public static final int ERROR_INVAL  = 6;   // 无效参数
    public static final int ERROR_DATA   = 7;   // 处理数据失败

    private int errorType = 0;
    private int statusCode = -1;
    private int resultCode = -1;
    private String content = null;

    public ServiceException( int errorType, 
            String errorMessage )
    {
        super( errorMessage );
        this.errorType = errorType;
    }

    public ServiceException( int errorType, 
            String errorMessage, Throwable cause )
    {
        super( errorMessage, cause );
        this.errorType = errorType;
    }

    public int getErrorType()
    {
        return errorType;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public void setStatusCode( int statusCode )
    {
        this.statusCode = statusCode;
    }

    public int getResultCode()
    {
        return resultCode;
    }

    public void setResultCode( int resultCode )
    {
        this.resultCode = resultCode;
    }
    
    public void setContent( String content )
	{
		this.content = content;
	}

	public String getContent()
	{
		return this.content;
	}

	public <T> T getContentObject( Class<T> valueType )
	{
		return JSONHelper.parseObject( this.content, valueType );
	}

	public <T> List<T> getContentList( Class<T> valueType )
	{
		return JSONHelper.parseArray( this.content, valueType );
	}
}
