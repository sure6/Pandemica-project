package com.csci927.pandemicabootdemo.mapper;

import com.csci927.pandemicabootdemo.bean.User;
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
public interface UserMapper extends BaseMapper<User> {
    List<User> selectAll();

    int insertUser(User user);
}
