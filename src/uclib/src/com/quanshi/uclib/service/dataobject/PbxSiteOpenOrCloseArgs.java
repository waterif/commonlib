package com.quanshi.uclib.service.dataobject;

public class PbxSiteOpenOrCloseArgs extends PbxAccessAuth
{
	public String outsideOrgId; // 站点id

	public String name; // 站点名称

	public int action; // 1 开启 0 关闭
}
