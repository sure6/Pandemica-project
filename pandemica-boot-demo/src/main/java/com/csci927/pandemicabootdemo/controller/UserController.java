package com.csci927.pandemicabootdemo.controller;


import com.csci927.pandemicabootdemo.bean.JSONResult;
import com.csci927.pandemicabootdemo.bean.User;
import com.csci927.pandemicabootdemo.service.UserAccountService;
import com.csci927.pandemicabootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * UserController
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("/")
    public String index(){
        return "/index.html";
    }
    @GetMapping("/index")
    public String index2(){
        return "/index.html";
    }

    @ResponseBody
    @GetMapping("/users")
    public List<User> findAllUser() {
        return userService.queryAllUser();
    }

    @GetMapping(value = "register")
    public String registration() {
        return "/register.html";
    }

    @GetMapping(value = "registerSuccessfull")
    public String registerSuccessfull() {
        return "/registerSuccessfull.html";
    }

    @ResponseBody
    @PostMapping("/userRegistration")
    public JSONResult userRegistration(@RequestBody User user) {
//        System.out.println(user);
        try {
            userService.addUser(user);
            userAccountService.addUserAccount(user.getUserAccount());
        } catch (Exception e) {
            return new JSONResult("false",e.toString());
        }
        return new JSONResult("true", "Registration successful!!!");
    }
}

