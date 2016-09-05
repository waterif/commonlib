package name.rex.commlib.util;

import name.rex.commlib.format.JSONHelper;

public class PropertyUtils
{
    public static <T> T newObjectProperties( Object src, Class<T> clazz )
    {
        return JSONHelper.parseObject( JSONHelper.toJSONString( src ), 
                clazz );
    }
}
