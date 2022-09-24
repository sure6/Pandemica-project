package com.csci927.pandemicaregistration.sevice.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csci927.pandemicaapi.bean.Application;
import com.csci927.pandemicaregistration.mapper.ApplicationMapper;
import com.csci927.pandemicaapi.service.ApplicationService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * <p>
 *  ApplicationService Implement class
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
@DubboService(interfaceClass = ApplicationService.class, version = "1.0.0",timeout = 6000000)
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

}
