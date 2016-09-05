package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class UmsOrgAndUserArg
{
    /*
    public static class Users
    {
        public Long   id;
        public String loginName;
        public String displayName;
        public String firstName;
        public String lastName;
        public String namepinyin;
        public String email;
        public String mobileNumber;
        public String position;
        public String officePhone;
    }
    */
    
    public String name;
    public String customercode;
    public Integer type;
    public Long parentId;
    public List<UmsCreateUserInfo> users;
}
