package com.csci927.pandemicaregistration.sevice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.csci927.pandemicaregistration.bean.JSONResult;
import com.csci927.pandemicaregistration.bean.UserAccount;

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

    JSONResult doLogin(String username, String password);
}
