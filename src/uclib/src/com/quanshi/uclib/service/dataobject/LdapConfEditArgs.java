package com.quanshi.uclib.service.dataobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LdapConfEditArgs 
{
	public Integer id;
	public String protocol;
	public String confName;
	public String serverType;
	public String customerCode;
	public String hostname;
	public String authenticationMethod;
	public String port;
	public String basedn;
	public String username;
	public String password;
	
	public Map<String, String> ldapOrgUserMapping;
	public Map<String, String> ldapOrgMapping;
	public Map<String, String> ldapUserMapping;
	public Map<String, String> siteLdapConfig;
	public List<Map<String, String>> ldapSearch;

	public LdapConfEditArgs()
	{
		this.ldapOrgUserMapping = new HashMap<String, String>();
		this.ldapOrgMapping 	= new HashMap<String, String>();
		this.ldapUserMapping 	= new HashMap<String, String>();
		this.siteLdapConfig 	= new HashMap<String, String>();
		this.ldapSearch = new ArrayList<Map<String, String>>();
	}
}
