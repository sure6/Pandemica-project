package com.csci927.pandemicavaccinebooking.service.impl;

import com.csci927.pandemicavaccinebooking.bean.VaccineBooking;
import com.csci927.pandemicavaccinebooking.mapper.VaccineBookingMapper;
import com.csci927.pandemicavaccinebooking.service.VaccineBookingService;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * @author sure
 * @since 2022-10-09
 */
@DubboService(interfaceClass = VaccineBookingService.class, version = "1.0.3", timeout = 60000)
public class VaccineBookingServiceImpl implements VaccineBookingService {

    @Autowired
    private VaccineBookingMapper vaccineBookingMapper;
    @Override
    public boolean getVaccineBookingByUserID(String userID) {
        if(StringUtils.isEmpty(userID)){
            return false;
        }
        return vaccineBookingMapper.selectByUserID(userID).size()>0;
    }

    @Override
    public boolean save(VaccineBooking vaccineBooking) {
        return vaccineBookingMapper.insert(vaccineBooking)>0;
    }

    @Override
    public VaccineBooking getInfoByUserID(String userID){
        if(StringUtils.isEmpty(userID)){
            return null;
        }
        List<VaccineBooking> vaccineBookingList = vaccineBookingMapper.selectByUserID(userID);
        if (vaccineBookingList.size()>0){
            return vaccineBookingMapper.selectByUserID(userID).get(0);
        }
        return null;
    }
}
