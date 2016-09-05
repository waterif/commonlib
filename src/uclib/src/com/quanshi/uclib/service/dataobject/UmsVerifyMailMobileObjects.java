package com.quanshi.uclib.service.dataobject;

public class UmsVerifyMailMobileObjects
{
    public static class UmsVerifyPhoneAndMailArgs
    {
        public Long         id;
        public String       email;               // 邮箱
        public UserPhoneDTO mobile;
        public boolean      isForceUpdate = true;

        public static class UserPhoneDTO
        {
            public Long    id;
            public String  phoneNumber;
            public boolean verified      = true;
            public String  countryCode   = "";
            public String  cityCode      = "";
            public String  subCode       = "";
            public int     phoneTypeName = 3;
        }

        public UmsVerifyPhoneAndMailArgs()
        {
            mobile = new UserPhoneDTO();
        }

    }

    public static class UmsVerifyMailMobileReturn
    {
        public Integer flag;
        public String  message;
        public String  email;
        public String  mobile;

    }
}
