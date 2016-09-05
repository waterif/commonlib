package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class UccServerMessageBroadcastItemResult
{
    public static class OAMsgId
    {
        public int user_id;
        public String oa_msg_id;
    }

    public long index;
    public String uuid;
    public long code;
    public String msg;
    public List<OAMsgId> oa_msg_id_list;
}
