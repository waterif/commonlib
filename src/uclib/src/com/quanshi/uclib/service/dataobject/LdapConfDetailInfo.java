package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class LdapConfDetailInfo 
{
	public int id;
	public String protocol;
	public String confName;
	public String serverType;
	public String customerCode;
	public String hostname;
	public int port;
	public String basedn;
	public String username;
	public String password;
	public long createTime;
	public long updateTime;
	public long lastSyncTime;
	public LdapConfUserMaping ldapUserMapping;
	public LdapConfSite siteLdapConfig;
	public LdapConfOrgMaping ldapOrgMapping;
	public LdapConfUserOrgMaping ldapOrgUserMapping;
	public List<LdapConfSearch> ldapSearch;
}
