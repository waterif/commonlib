package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class BossDataObjects
{
    public static class CustomerInfo
    {
        public static class FinancialContacts
        {
            public String name;
            public String email;
            public String mobilePhone;
            public String telPhone;
        }

        public static class MainContacts
        {
            public String name;
            public String email;
            public String mobilePhone;
            public String telPhone;
        }

        public String           name;
        public String           address;
        public String           country;
        public String           city;
        public String           phone;
        public String           fax;
        public String           website;
        public List<FinancialContacts> financialContacts;
        public List<MainContacts>      mainContacts;
    }
}
