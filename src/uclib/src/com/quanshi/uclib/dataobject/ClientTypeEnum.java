package com.quanshi.uclib.dataobject;

public enum ClientTypeEnum
{
    IPHONE( "iphone", 1 ), ANDROID( "android", 2 ), PC( "pc", 3 ), 
        BACKEND( "backend", 4 ), IPAD( "ipad", 5), WEB( "web", 6 );

    private String  name;
    private int     value;

    ClientTypeEnum( String name, int value )
    {
        this.name = name;
        this.value = value;
    }

}
