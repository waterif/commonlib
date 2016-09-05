package com.quanshi.uclib.service.dataobject;


public class AdvertisementResult
{
    public static class AdvertisementUserInfo
    {
        public String serverUrl;
        
        public Integer readTimes;
        
        public Integer activities;
        
        public String adLogo;
        
        public String adTitle;
    }
    
    public Integer code;
    
    public String msg;
    
    public String requestId;
    
    public AdvertisementUserInfo data;
    
}
