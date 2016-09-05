package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class UmsUserInfo extends UmsCreateUserInfo
{
	public String password;

	public List<UmsThirdPartyData> userTpList;

	public String getPassword()
	{
		return password;
	}

	public void setPassword( String password )
	{
		this.password = password;
	}

	public List<UmsThirdPartyData> getUserTpList()
	{
		return userTpList;
	}

	public void setUserTpList( List<UmsThirdPartyData> userTpList )
	{
		this.userTpList = userTpList;
	}

}
