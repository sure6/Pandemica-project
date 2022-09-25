package com.csci927.pandemicaregistration.sevice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csci927.pandemicaapi.bean.Complaint;
import com.csci927.pandemicaregistration.mapper.ComplaintMapper;
import com.csci927.pandemicaapi.service.ComplaintService;
import org.apache.dubbo.config.annotation.DubboService;

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
