package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class UccServerGroupCreateInfo
{
	public String owner;                     //讨论组创建者
	public String group_name;                 //讨论组名称
	public int groupID;                      
	public String userName;                       //退出者账号
	public int userID;                         //退出者账号ID
	public List<UccServerGroupCreateMemberInfo> member;       //讨论组成员账号名
	
	/**
	 *   （可选）group_status将用不同位来表示不同的含义.
	 *   第一位表示组是否已经结束. 
	 *         0 - 表示组没有结束; 	
	 *         1 - 表示组已经结束.  
	 *   第二位表示组是否在呼状态中.
	 *          0 - 表示组不在呼中; 
	 *         	1 - 表示组在呼中;
	 *   目前有如下取值:
	 *         	0 – 讨论组存在但不在呼中
	 *         	1 – 讨论组退出
	 *         	2– 讨论组存在并在呼中
	 */
	//public int group_status;             
	//public String status_info;           //（可选）Group status的附加信息
	public int name_flag = 1;                //是否为正式名称: 0–否; 1–是
	public int is_display = 1;               //是否作为创建的讨论组显示(默认为1): 0–不显示; 1-讨论组; 2-群聊
	public int logo_level = 1;               //讨论组图像级别(默认为1): 0 – 低;	1 – 中; 2 - 高
	public int site_id;       
}
