package com.csci927.pandemicabootdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.csci927.pandemicabootdemo.bean.JSONResult;
import com.csci927.pandemicabootdemo.bean.UserAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * UserAccountService
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
public interface UserAccountService extends IService<UserAccount> {

    Boolean modifyPassword(String username, String password);

    Integer addUserAccount(UserAccount userAccount) throws Exception;

    Boolean selectUserAccount(String username, String password);

    UserAccount getUserInfoByAccount(String username);

    String getUserID(String username);

    JSONResult doLoginWithSession(String username, String password, Integer cookieTime, HttpSession session, HttpServletRequest request, HttpServletResponse response);
}
