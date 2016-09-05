package com.quanshi.uclib.service.dataobject;

public class PbxServiceReturn
{
    public static class ReturnBase
    {
        public Integer code;
        public String  status;
    }

    public static class PbxGetDomainInfoReturn extends ReturnBase
    {
        public static class DomainInfo
        {
            public String name;
            public String web;
            public String restapi;
        }

        public DomainInfo domains;
    }
}
