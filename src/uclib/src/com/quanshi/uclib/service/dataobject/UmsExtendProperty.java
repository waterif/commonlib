package com.quanshi.uclib.service.dataobject;

/**
 * "otherProperty" : [ { 
	"id" : 237859, 
	"userId" : 106979, 
	"attrName" : "pbx_extension", 
	"attrValue" : "3466" 
} ],
 *
 */

public class UmsExtendProperty
{
	public String attrName;

	public String attrValue;

	public String userId;

	public String id;

	public String getAttrName()
	{
		return attrName;
	}

	public void setAttrName( String attrName )
	{
		this.attrName = attrName;
	}

	public String getAttrValue()
	{
		return attrValue;
	}

	public void setAttrValue( String attrValue )
	{
		this.attrValue = attrValue;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId( String userId )
	{
		this.userId = userId;
	}

	public String getId()
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	}

}
