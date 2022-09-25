package com.csci927.pandemicaregistration.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csci927.pandemicaregistration.bean.UserAccount;

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
