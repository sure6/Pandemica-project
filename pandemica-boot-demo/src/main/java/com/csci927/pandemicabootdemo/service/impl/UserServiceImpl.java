package com.csci927.pandemicabootdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csci927.pandemicabootdemo.bean.User;
import com.csci927.pandemicabootdemo.mapper.UserMapper;
import com.csci927.pandemicabootdemo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * UserService Implement class
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public Integer addUser(User user) throws Exception {
        if (StringUtils.isEmpty(user.getEmail()) ||
                StringUtils.isEmpty(user.getFirstName()) ||
                StringUtils.isEmpty(user.getLastName()) ||
                StringUtils.isEmpty(user.getPhoneNumber()) ||
                StringUtils.isEmpty(user.getPosition())) {
            throw new Exception("first name and last name and email and phone number and position is not null");
        }
        return userMapper.insertUser(user);
    }

}
