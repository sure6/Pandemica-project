package com.csci927.pandemicabootdemo.controller;


import com.csci927.pandemicabootdemo.bean.JSONResult;
import com.csci927.pandemicabootdemo.bean.UserAccount;
import com.csci927.pandemicabootdemo.service.UserAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    @PutMapping("userForgot")
    public JSONResult userForgot(@RequestParam String username, @RequestParam String password, @RequestParam String passwordConfirm){
        UserAccount userInfoByAccount = userAccountService.getUserInfoByAccount(username);
        if(null == userInfoByAccount){
           return new JSONResult("false","Account does not exist!!!");
        }
        if(!password.equals(passwordConfirm)){
            return new JSONResult("false","The two entered passwords are different！！！");
        }
//        System.out.println(username+password);
        if(!userAccountService.modifyPassword(username,password)){
            return new JSONResult("false","Password modified failed, please retry");
        }
        return new JSONResult("true","Password modified successfully");
    }

    @ResponseBody
    @PostMapping("userLogin")
    public JSONResult useLogin(@RequestParam String username, @RequestParam String password, @RequestParam(required = false) String remember, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return new JSONResult("false", "username or password is not NULL");
        }
        if (StringUtils.isEmpty(remember)){
            System.out.println("not rememer");
            // The default cookie time is 30min
            return userAccountService.doLoginWithSession(username,password, 30*60,session, request, response);
        }
        return userAccountService.doLoginWithSession(username.trim(), password.trim(),3 * 24 * 60 * 60, session, request, response);

    }

    @ResponseBody
    @GetMapping("getCookiePw")
    public String getCookiePw(@RequestParam String username){
        UserAccount info = userAccountService.getUserInfoByAccount(username);
        if(null==info){
            return "";
        }
        return info.getPassword();
    }
    /**
     * logout
     */
    @GetMapping("logout")
    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        //  Delete the user information in the session
        session.removeAttribute("user_session");
        // Save the cookie for automatic login
        Cookie cookie_username = new Cookie("cookie_username", "");
        // Set the cookie persistence time to 0
        cookie_username.setMaxAge(0);
        // Set to the current project carries this cookie
        cookie_username.setPath("/");
        // Sending a cookie to the client
        response.addCookie(cookie_username);
        return "/index";
    }



}

