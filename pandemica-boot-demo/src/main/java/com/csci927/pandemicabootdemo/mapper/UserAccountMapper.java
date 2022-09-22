package com.csci927.pandemicabootdemo.mapper;

import com.csci927.pandemicabootdemo.bean.UserAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper interface
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
public interface UserAccountMapper extends BaseMapper<UserAccount> {
    int insertUserAccount(UserAccount userAccount);

    List<UserAccount> selectByUsernameAndPassword(String username, String password);

    UserAccount selectUserInfoByAccount(String username);

    int updatePassword(String username, String password);
}
