package com.cscsi927.pandemicahome.controller;



import com.csci927.pandemicaapi.bean.JSONResult;
import com.csci927.pandemicaapi.bean.UserAccount;
import com.csci927.pandemicaapi.service.UserAccountService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
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

    @DubboReference(interfaceClass = UserAccountService.class,version = "1.0.1",check = true)
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
        JSONResult jsonResult = userAccountService.doLogin(username, password);
        UserAccount account = userAccountService.getUserInfoByAccount(username);
        if (StringUtils.isEmpty(remember) ){
            System.out.println("not rememer");
            // The default cookie time is 30min
            if(jsonResult.getStateValue().equals("true")){
                this.setCookieAndSession(account,30 * 60,session,response);
                return jsonResult;
            }

        }
        if(jsonResult.getStateValue().equals("true")){
            this.setCookieAndSession(account,3 * 24 * 60 * 60,session,response);
            return jsonResult;
        }

        return jsonResult;

    }

    private void setCookieAndSession(UserAccount userAccount, int cookieTime, HttpSession session, HttpServletResponse response){
        // The login user information is saved to the session
        session.setAttribute("user_session", userAccount);
        // Save the cookie for automatic login
        Cookie cookie_username = new Cookie("cookie_username", userAccount.getUsername());
        // Set the cookie persistence period to cookie Time
        cookie_username.setMaxAge(cookieTime);
        // Set this cookie to be carried by all current projects
        cookie_username.setPath("/");
        // Sending a cookie to the client
        response.addCookie(cookie_username);
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

