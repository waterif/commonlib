package com.quanshi.uclib.service.dataobject;

public class YunPanEntInfoRes
{
    /**
     * 企业ID
     */
    public Integer id;

    /**
     * 是否试用, 1表示试用, 0表示正式开通
     */
    public Integer trial;

    /**
     * 企业名称
     */
    public String name;

    /**
     * 到期时间, unix时间戳
     */
    public Long end_dateline;

    /**
     * 空间上限, 单位字节
     */
    public Long space;

    /**
     * 已使用空间, 单位字节
     */
    public Long size;

    /**
     * 成员数量上限
     */
    public Integer member_limit;

    /**
     * 成员数量
     */
    public Integer member_count;
}
