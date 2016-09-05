package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class PbxCloseReturn
{
    public static class userinfo
    {
        public String easiio_username;
        public String create_username; //app传入的参数
        public String easiio_id;
        public String user_flag;
        public int    is_active;
    }

    public static class datafields
    {
        public List<userinfo> close_success_users;
        public List<userinfo> close_failed_users;
        public List<userinfo> not_exist_users;
    }

    public datafields datas;
    public int        code;
    public String     status;
}
