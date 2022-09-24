package com.cscsi927.pandemicahome.controller;



import com.csci927.pandemicaapi.bean.JSONResult;
import com.csci927.pandemicaapi.bean.User;
import com.csci927.pandemicaapi.service.UserAccountService;
import com.csci927.pandemicaapi.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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

