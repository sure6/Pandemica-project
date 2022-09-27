package com.csci927.pandemicaapply.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csci927.pandemicaapply.bean.Application;
import com.csci927.pandemicaapply.mapper.ApplicationMapper;
import com.csci927.pandemicaapply.service.ApplicationService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  ApplicationService Implement class
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
@DubboService(interfaceClass = ApplicationService.class, version = "1.0.0",timeout = 60000)
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Override
    public boolean saveOrUpdate(Application application) {
        return applicationMapper.insert(application)>0;
    }

    @Override
    public  boolean getApplicationByUserID(String userID){
        if(StringUtils.isEmpty(userID)){
            return false;
        }
        return applicationMapper.selectByUserID(userID).size()>0;
    }

}
