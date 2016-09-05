package com.quanshi.uclib.service.dataobject;

import java.util.List;

public class UccServerGroupCreateResult
{
    public Integer  group_id;
    public String   group_name;
    public Long     site_id;
    public Long     created;
    public List<Long> member_list;
    public Long     external_type;
}
