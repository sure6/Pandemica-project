package com.csci927.pandemicabootdemo.service.impl;

import com.csci927.pandemicabootdemo.bean.MentalHealthSupport;
import com.csci927.pandemicabootdemo.mapper.MentalHealthSupportMapper;
import com.csci927.pandemicabootdemo.service.MentalHealthSupportService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sure
 * @since 2022-09-28
 */
@Service
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
