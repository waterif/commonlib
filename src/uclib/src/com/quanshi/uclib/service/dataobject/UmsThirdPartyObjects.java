package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class UmsThirdPartyObjects
{
    public static class UmsBindThirdPartyResult
    {

        public int        status  = 1;
        public String     details = "";
        public UmsThirdPartyData body;

    }

    public static class UmsUnBindThirdPartyResult
    {

        public int    status  = 1;
        public String details = "";
        public String body;

    }
    
    public static class UmsGetThirdPartyResult
    {
        public Integer status;
        public String  details;
        public List<UmsThirdPartyData> body;

    }
    
    public static class UmsModifyThirdPartyStatusResult
    {
        public Integer status;
        public String  details;
        public String  body;
    }
    
    public static class BindThirdPartyArgs
    {
        public long              userId         = 0;
        public int               tpType         = 0;
        public String            tpId           = "";
        public int               tpStatus       = 1;
    }
}
