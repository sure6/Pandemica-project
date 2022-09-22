package com.csci927.pandemicabootdemo.service;

import com.csci927.pandemicabootdemo.bean.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
