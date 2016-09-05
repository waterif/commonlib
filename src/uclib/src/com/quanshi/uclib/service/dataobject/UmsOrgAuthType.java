package com.quanshi.uclib.service.dataobject;

public enum UmsOrgAuthType
{
	EXTENDPARENT( 0 ), LDAP( 1 ), COMMON( 2 );

	int type;

	UmsOrgAuthType( int type )
	{
		this.type = type;
	}

	public int getValue()
	{
		return this.type;
	}

}
