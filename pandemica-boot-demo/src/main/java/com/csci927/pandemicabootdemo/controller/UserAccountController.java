package com.csci927.pandemicabootdemo.controller;


import com.csci927.pandemicabootdemo.bean.JSONResult;
import com.csci927.pandemicabootdemo.service.UserAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * UserAccountController
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
@Controller
@RequestMapping("/userAccount")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("login")
    public String login() {
        return "/login.html";
    }

    @GetMapping("forgot")
    public String forgot() {
        return "/forgot.html";
    }

    @ResponseBody
    @PostMapping("userLogin")
    public JSONResult useLogin(@RequestParam String username, @RequestParam String password) {
        if (StringUtils.isEmpty(username) && StringUtils.isEmpty(password)) {
            return new JSONResult("false", "username and password is not NULL");
        }
        System.out.println(username + password);
        return userAccountService.selectUserAccount(username, password) ?
                new JSONResult("true", "user and password is correct") :
                new JSONResult("false", "user and password is incorrect");
    }


}

