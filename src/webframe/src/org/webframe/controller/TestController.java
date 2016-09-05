package org.webframe.controller;

import java.io.OutputStream;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import name.rex.commlib.log.Logger;
import name.rex.commlib.log.LoggerFactory;
import org.webframe.context.Context;

class User
{
    public String name;
    public int    age;

    public String getName()
    {
        return name;
    }

    public void setName( String val )
    {
        name = val;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge( int v )
    {
        age = v;
    }
}

@Controller
@RequestMapping( "/test" )
public class TestController 
{
    private static Logger log = LoggerFactory.getLogger( "TestController" );

    @RequestMapping( value = "/hello",
            produces = "application/json" )
    public String HelloWorld()
    {
        return "Hello, world!";
    }

    @RequestMapping( value="/hello2", 
            produces = "application/json" )
    @ResponseBody
    public Map<String, Object> Hello2()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        User u = new User();

        u.name = "a";
        u.age = 100;

        map.put( "Code", 0 );
        map.put( "user", u );

        return map;
    }
}
