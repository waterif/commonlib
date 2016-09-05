package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class AccountActiveCallback
{
    public static final int ALL_SUCCESS = 1;
    public static final int FAILED      = -1;
    
    public static class Successed
    {
        public Long id;
        public String billingCode;
        public Long accountId;
    }
    
    public static class Failed
    {
        public Long id;
        public String billingCode;
        public Long accountId;
        public String error;
    }
    
    public String requestId;
    public Long finishedTime = System.currentTimeMillis()/1000L;
    public Long contractId;
    public String componentName = "UC";
    public Integer result;
    public String type;
    public List<Successed> successed;
    public List<Failed> failed;
}
