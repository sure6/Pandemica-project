package com.csci927.pandemicamentalhealth.service.impl;


import com.csci927.pandemicamentalhealth.bean.MentalHealthSupport;
import com.csci927.pandemicamentalhealth.mapper.MentalHealthSupportMapper;
import com.csci927.pandemicamentalhealth.service.MentalHealthSupportService;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author sure
 * @since 2022-09-28
 */
@DubboService(interfaceClass = MentalHealthSupportService.class, version = "1.0.2", timeout = 60000)
public class MentalHealthSupportServiceImpl implements MentalHealthSupportService {

    @Autowired
    private MentalHealthSupportMapper mentalHealthSupportMapper;
    @Override
    public  boolean getMHSByUserID(String userID){
        if(StringUtils.isEmpty(userID)){
            return false;
        }
        return mentalHealthSupportMapper.selectByUserID(userID).size()>0;
    }

    @Override
    public boolean saveData(MentalHealthSupport mentalHealthSupport) {
        return mentalHealthSupportMapper.insertMHS(mentalHealthSupport)>0;
    }

    @Override
    public boolean getMHSByUserIDAndServiceType(String userID,String serviceType){
        if(StringUtils.isEmpty(userID) || StringUtils.isEmpty(serviceType)){
            return false;
        }
        return mentalHealthSupportMapper.selectByUserIDAndServiceType(userID, serviceType).size()>0;
    }

    @Override
    public MentalHealthSupport getInfoByUserID(String userID) {
        if(StringUtils.isEmpty(userID)){
            return null;
        }
        List<MentalHealthSupport> mhsList = mentalHealthSupportMapper.selectByUserID(userID);
        if (mhsList.size()>0){
            return mentalHealthSupportMapper.selectByUserID(userID).get(0);
        }
        return null;
    }
}
