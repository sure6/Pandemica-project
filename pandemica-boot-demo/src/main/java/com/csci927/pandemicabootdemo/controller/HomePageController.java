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


}
