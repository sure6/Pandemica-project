package com.cscsi927.pandemicahome.config;



import com.csci927.pandemicaregistration.bean.UserAccount;
import com.csci927.pandemicaregistration.sevice.UserAccountService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Component
public class LoginInterceptor implements HandlerInterceptor {


    @DubboReference(interfaceClass = UserAccountService.class,version = "1.0.1",check = true)
    private UserAccountService userAccountService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // get cookie
        Cookie[] cookies = request.getCookies();
        // If no cookie information is displayed, the user is redirected to the login page
        if (null == cookies) {
            response.sendRedirect(request.getContextPath() + "/userAccount/login");
            return false;
        }
        // Define COOKIE_USERNAME, some login information of the user, such as username, password, etc
        String cookie_username = null;
        // Get some user information in the cookie
        for (Cookie item : cookies) {
            if ("cookie_username".equals(item.getName())) {
                System.out.println(item.getName());
                cookie_username = item.getValue();
                break;
            }
        }
        // If the cookie does not contain some login information for the user, the user is redirected to the login screen
        if (StringUtils.isEmpty(cookie_username)) {
            response.sendRedirect(request.getContextPath() + "/userAccount/login");
            return false;
        }
        // Retrieve the HttpSession object
        HttpSession session = request.getSession();
        // Obtain the user information in the session after we log in. If the value is empty, the session has expired
        Object obj = session.getAttribute("user_session");
        if (null == obj) {
            // Obtain the user information in the database based on the user login account
            UserAccount userAccount = userAccountService.getUserInfoByAccount(cookie_username);
            // Save the user to the session
            session.setAttribute("user_session", userAccount);
        }
        // Logined
        return true;
    }

}