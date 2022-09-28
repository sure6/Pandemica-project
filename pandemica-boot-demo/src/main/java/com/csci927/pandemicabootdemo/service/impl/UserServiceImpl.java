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

        if(this.verifyPhone(user.getPhoneNumber())){
            throw new Exception("The Phone Number you Entered already exists!!!");
        }
        if(this.verifyEmail(user.getEmail())){
            throw new Exception("The Email you Entered already exists!!!");
        }
        return userMapper.insertUser(user);
    }

    @Override
    public Boolean verifyPhone(String phone) {
        return userMapper.selectPhone(phone).size()>0;
    }

    @Override
    public Boolean verifyEmail(String email) {
        return userMapper.selectEmail(email).size()>0;
    }

    @Override
    public User getUserByUserId(String userID){
        return userMapper.selectUser(userID);
    }
}
