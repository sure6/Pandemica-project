package com.csci927.pandemicabootdemo.service.impl;

import com.csci927.pandemicabootdemo.bean.User;
import com.csci927.pandemicabootdemo.mapper.UserMapper;
import com.csci927.pandemicabootdemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sure
 * @since 2022-09-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
