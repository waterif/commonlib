package com.quanshi.uclib.service.dataobject;

public enum UmsOrgAuthScope
{
	SELF( "self" ), ALL( "all" );

	String value;

	UmsOrgAuthScope( String value )
	{
		this.value = value;
	}

	public String getValue()
	{
		return this.value;
	}
}
