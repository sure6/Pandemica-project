package com.csci927.pandemicaregistration.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csci927.pandemicaregistration.bean.User;


import java.util.List;

/**
 * <p>
 *  Mapper interface
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> selectAll();

    int insertUser(User user);

    List<User> selectPhone(String phoneNumber);

    List<User> selectEmail(String email);

    User selectUser(String userID);
}
