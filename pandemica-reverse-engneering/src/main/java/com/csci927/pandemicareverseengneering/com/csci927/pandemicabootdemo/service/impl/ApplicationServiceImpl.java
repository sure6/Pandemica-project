package com.csci927.pandemicabootdemo.service.impl;

import com.csci927.pandemicabootdemo.bean.Application;
import com.csci927.pandemicabootdemo.mapper.ApplicationMapper;
import com.csci927.pandemicabootdemo.service.ApplicationService;
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
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

}
