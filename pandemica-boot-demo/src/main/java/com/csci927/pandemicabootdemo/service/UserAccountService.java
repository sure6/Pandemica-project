package com.csci927.pandemicabootdemo.service;

import com.csci927.pandemicabootdemo.bean.UserAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  UserAccountService
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
public interface UserAccountService extends IService<UserAccount> {

    Integer addUserAccount(UserAccount userAccount) throws Exception;

    Boolean selectUserAccount(String username, String password);
}
