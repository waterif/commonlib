package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class UmsPbxBindResultObjects
{
    public static class UmsPbxBindResult
    {

        public int        status  = 1;
        public String     details = "bind success";
        public UmsPbxData body;

    }

    public static class UmsPbxunBindResult
    {

        public int    status  = 1;
        public String details = "bind success";
        public String body;

    }
    
    public static class bindPbxObject
    {
        private static final int UMS_tpType_PBX = 1;

        public long              userId         = 0;
        public int               tpType         = UMS_tpType_PBX;
        public String            tpId           = "";
        public int               tpStatus       = 1;

    }

    public static class unbindPbxObject
    {
        private static final int UMS_tpType_PBX = 1;

        public long              userId         = 0;
        public int               tpType         = UMS_tpType_PBX;
        public String            tpId           = "";

    }

    public static class getUms3rdStatusReturn

    {
        public Integer status;
        public String  details;

        public static class statusBody
        {
            public long   id;
            public long   userId;
            public int    tpType;
            public String tpId;
            public int    tpStatus;
            // "tpExtend1": null,
            // "tpExtend2": null,
            // "tpExtend3": null,
            // "tpExtend4": null,
            // "tpExtend5": null,
            // "createTime": null,
            // "updateTime": null
        }

        public List<statusBody> body;

    }

    public static class switchStatusReturn
    {
        public Integer status;
        public String  details;
        public String  body;

    }
}
