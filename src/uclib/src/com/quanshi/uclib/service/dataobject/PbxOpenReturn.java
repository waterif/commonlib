package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class PbxOpenReturn
{
    public static class userinfo
    {
        public String easiio_username;
        public String create_username; //app传入的参数
        public String easiio_id;
        public String user_flag;
        public int    is_active;
        public int    outside_org_id;
        public int    outside_ext;	//外部分机号
        public String errors;
        public int    error_code;
    }

    public static class datafields
    {
        public List<userinfo> new_users;
        public List<userinfo> exist_users;
        public List<userinfo> create_failed_users;     // 这是什么鬼
        public List<userinfo> open_failed_exist_users; // 这是什么鬼
    }

    public datafields datas;
    public int        code;
    public String     status;
}
