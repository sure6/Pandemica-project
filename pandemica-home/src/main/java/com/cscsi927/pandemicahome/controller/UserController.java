package com.cscsi927.pandemicahome.controller;



import com.csci927.pandemicaregistration.bean.JSONResult;
import com.csci927.pandemicaregistration.bean.User;
import com.csci927.pandemicaregistration.sevice.UserAccountService;
import com.csci927.pandemicaregistration.sevice.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DubboReference(interfaceClass = UserService.class,version = "1.0.1",check = true)
    private UserService userService;
    @DubboReference(interfaceClass = UserAccountService.class,version = "1.0.1",check = true)
    private UserAccountService userAccountService;

    @GetMapping({"/index","/"})
    public String index(){
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

    @ResponseBody
    @GetMapping("/oauth/getUserInfo/{username}")
    public User getUseinfo(@PathVariable String username){
        String userID = userAccountService.getUserID(username);
        User user = null;
        if(!StringUtils.isEmpty(userID)){
            user = userService.getUserByUserId(userID);
        }
        return user;
    }
}

