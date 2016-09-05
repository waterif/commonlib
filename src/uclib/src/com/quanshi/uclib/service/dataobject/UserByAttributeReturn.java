package com.quanshi.uclib.service.dataobject;

public class UserByAttributeReturn
{
    public Integer retCode; // 0:操作成功 -1：操作失败 -2 : 没有查询到信息

    public String retMsg;

    public RetObj retObj;

    public static class RetObj
    {
        public String id;
    }

}
