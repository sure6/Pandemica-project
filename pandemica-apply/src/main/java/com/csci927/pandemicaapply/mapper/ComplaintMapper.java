package com.csci927.pandemicaapply.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csci927.pandemicaapply.bean.Complaint;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  Mapper interface
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
public interface ComplaintMapper extends BaseMapper<Complaint> {

    List<Complaint> selectByUserID(String userID);
}
