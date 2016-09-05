package com.quanshi.uclib.service.dataobject;

import java.util.ArrayList;
import java.util.List;

public class ResponseBodyArray<T> {
    public Integer status = 1;
    public String details = "";
    public List<T> body = new ArrayList<T>();
}
