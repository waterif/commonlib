package com.quanshi.uclib.service.dataobject;

public class PbxAccessAuth
{
	public class Auth
	{
		public String developerKey;

		public String token;
	}

	public PbxAccessAuth.Auth auth;

	public PbxAccessAuth()
	{
		auth = new Auth();
	}
}
