package com.quanshi.uclib.service.dataobject;

import java.util.Date;

public class YunPanInfo
{
	/**
	 * domain
	 */
	public String siteUrl;

	/**
	 * 企业在合作方系统中的唯一ID
	 */
	public String outId;

	/**
	 * 企业名称
	 */
	public String entName = " ";

	/**
	 * 企业联系人姓名
	 */
	public String contactName = " ";

	/**
	 * 企业联系电话
	 */
	public String contacMobile="";

	/**
	 * 企业联系邮箱
	 */
	public String contactEmail="";

	/**
	 * 企业联系地址
	 */
	public String contactAddress="";

	/**
	 * unix当前时间戳
	 */
	public Long dateline = new Date().getTime();

	/**
	 * 签名
	 */
	public String sign;

	/**
	 * 购买"subscribe";续费"renew";升级"upgrade";退订"unsubscribe"
	 */
	public String type;

	/**
	 * 人数（不限是-1）
	 */
	public Integer memberCount;

	/**
	 * 空间(G)
	 */
	public Integer space;

	/**
	 * 购买的月数 or 续费月数
	 */
	public Integer month;

}
