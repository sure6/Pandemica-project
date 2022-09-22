package com.csci927.pandemicabootdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
public class HomePageController {

    /**
     * home page
     */
    @GetMapping("index")
    public String index() {
        return "/index.html";
    }

    @ResponseBody
    @RequestMapping(value = "/setSession")
    public Map<String, Object> setSession (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("message", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/getSession")
    public Object getSession (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("message"));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public String login (HttpServletRequest request,String userName,String password){
        System.out.println(request.getSession().getId());
        String msg="logon failure!";

        if (userName!=null && "admin".equals(userName) && "123".equals(password)){
            request.getSession().setAttribute("user",userName);
            msg="login successful!";
        }
        return msg;
    }
}
