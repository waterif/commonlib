package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class BossActiveAccountSellingProductsArg
{
    public static class Customer
    {
        public static class Contract
        {
            public Long id;
        }
        
        public static class User
        {
            public Integer id;
            public String accountId;
            public List<SellingProductInfo> sellingProducts;
        }
        
        public String customerCode;
        public Contract contract;
        public List<User> users;
    }
    
    public Long requestId;
    public String templateUUID;
    public String callback;
    public int    createdTime;
    public String creator;
    public String type;
    public Customer customer;
}
