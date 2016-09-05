package com.quanshi.uclib.service.dataobject;

import java.util.ArrayList;
import java.util.List;

import com.quanshi.uclib.service.UmsService;

public class UserValidateCheckObjects
{
    public static class UserUniqueInfo
    {
        public String loginName;
        public String email;
        public Phones phone = new Phones();

        public static class Phones
        {
            public String phoneNumber;
            public String countryCode;
            public String cityCode;
            public String subCode;
        }

    }

    public static class ValidateUserReturn
    {

        public String              result;
        public List<UserfindInfo> users = new ArrayList<UserfindInfo>();

        public static class UserfindInfo
        {
            public String                     validateType;
            public Long                       userId;
            public String                     firstName;
            public String                     middleName;
            public String                     lastName;
            public List<UserfindInfoProducts> products = new ArrayList<UserfindInfoProducts>();;

            public static class UserfindInfoProducts
            {
                public Integer productId;
                public Integer userStatus;
                public Integer sitesId;
            }
            
            public boolean hasBeeProduct()
            {
                for ( UserfindInfoProducts p : products )
                {
                    if ( p.productId == UmsService.UC_PRODUCT_ID )
                    {
                        return true;
                    }
                }
                
                return false;
            }
        }
    }
}
