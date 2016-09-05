package com.quanshi.uclib.service.dataobject;

public class LdapConfBriefInfo 
{
	public int id;
	public String confName;
	public long createTime;
	public long lastSyncTime;
	public LdapConfBriefSiteInfo siteLdapConfig;
	public LdapConfOrgMaping ldapOrgMapping;
}
