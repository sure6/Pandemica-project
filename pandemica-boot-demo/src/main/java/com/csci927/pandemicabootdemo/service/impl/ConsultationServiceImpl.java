package com.csci927.pandemicabootdemo.service.impl;

import com.csci927.pandemicabootdemo.bean.Consultation;
import com.csci927.pandemicabootdemo.mapper.ConsultationMapper;
import com.csci927.pandemicabootdemo.service.ConsultationService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sure
 * @since 2022-09-28
 */
@Service
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    private ConsultationMapper consultationMapper;

    @Override
    public boolean getConsultationByUserID(String userID){
        if(StringUtils.isEmpty(userID)){
            return false;
        }
        return consultationMapper.selectByUserID(userID).size()>0;
    }

    @Override
    public boolean saveConsultationInfo(Consultation consultation) {
        return consultationMapper.insertInfo(consultation)>0;
    }
}
