package com.quanshi.uclib.service.dataobject;

import java.util.List;
import java.util.Map;

public class SellingProductInfo
{
    public static class Components
    {
        public Long id;
        public String name;
        public String activationUrl;
        public Integer status;
        public Map<String, String> property;
    }
    
    public Long id;
    public List<Components> components;
    public Long productId;
}
