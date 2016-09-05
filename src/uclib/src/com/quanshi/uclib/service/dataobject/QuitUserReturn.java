package com.quanshi.uclib.service.dataobject;

import java.util.List;

/**
 * UMS分页查询离职离别返回对象模型
 */
public class QuitUserReturn
{
    public int retCode;

    public String retMsg;

    public RetObj retObj;

    public static class RetObj
    {

        public int totalCount;

        public int pageSize;

        public int pageNum;

        public List<DataSet> dataSet;

    }

    public static class DataSet
    {

        public int userId;

        public int siteId;

        public List<OrgDetails> orgDetails;

    }

    /**
     * 组织相关信息
     */
    public static class OrgDetails
    {

        public int organizationId;

        public String organizationName;

        public String customerCode;

        public int siteId;

    }

}
