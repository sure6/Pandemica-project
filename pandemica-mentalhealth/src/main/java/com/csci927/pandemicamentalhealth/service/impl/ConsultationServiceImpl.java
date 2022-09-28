package com.csci927.pandemicamentalhealth.service.impl;



import com.csci927.pandemicamentalhealth.bean.Consultation;
import com.csci927.pandemicamentalhealth.mapper.ConsultationMapper;
import com.csci927.pandemicamentalhealth.service.ConsultationService;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author sure
 * @since 2022-09-28
 */
@DubboService(interfaceClass = ConsultationService.class, version = "1.0.2", timeout = 60000)
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
