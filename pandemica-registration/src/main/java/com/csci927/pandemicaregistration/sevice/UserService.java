package com.csci927.pandemicaregistration.sevice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.csci927.pandemicaregistration.bean.User;

import java.util.List;

/**
 * <p>
 *  UserService class
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
public interface UserService extends IService<User> {

    List<User> queryAllUser();

    Integer addUser(User user) throws Exception;

    Boolean verifyPhone(String phone);
    Boolean verifyEmail(String email);

    User getUserByUserId(String userID);
}
