package com.csci927.pandemicavaccinebooking.mapper;

import com.csci927.pandemicavaccinebooking.bean.VaccineBooking;

import java.util.List;

/**
 *
 * @author sure
 * @since 2022-10-09
 */
public interface VaccineBookingMapper {

    List<VaccineBooking> selectByUserID(String userID);

    int insert(VaccineBooking vaccineBooking);
}
