package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class MonthlistResult
{
    public static class UserNumber
    {
        public List<Integer> userNumber;
    }

    public int errorCode = 0;

    public UserNumber data;

    public String errorMessage;

    public String requestId;
}
