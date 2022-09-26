package com.csci927.pandemicaapply.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csci927.pandemicaapply.bean.Complaint;
import com.csci927.pandemicaapply.mapper.ComplaintMapper;
import com.csci927.pandemicaapply.service.ComplaintService;
import org.apache.dubbo.config.annotation.DubboService;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
@DubboService(interfaceClass = ComplaintService.class, version = "1.0.0",timeout = 60000)
public class ComplaintServiceImpl extends ServiceImpl<ComplaintMapper, Complaint> implements ComplaintService {

}
