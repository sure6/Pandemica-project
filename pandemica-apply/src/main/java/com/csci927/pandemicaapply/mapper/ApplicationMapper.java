package com.csci927.pandemicaapply.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csci927.pandemicaapply.bean.Application;

import java.util.List;

/**
 * <p>
 *  Mapper interface
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
public interface ApplicationMapper extends BaseMapper<Application> {
    List<Application> selectAll();

    List<Application> selectByUserID(String userID);
}
