package com.csci927.pandemicabootdemo.service.impl;

import com.csci927.pandemicabootdemo.bean.UserAccount;
import com.csci927.pandemicabootdemo.mapper.UserAccountMapper;
import com.csci927.pandemicabootdemo.service.UserAccountService;
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
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {

}
