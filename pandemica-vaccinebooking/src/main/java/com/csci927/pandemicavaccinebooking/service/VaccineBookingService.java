package com.csci927.pandemicavaccinebooking.service;

import com.csci927.pandemicavaccinebooking.bean.VaccineBooking;

/**
 *
 * @author sure
 * @since 2022-10-09
 */
public interface VaccineBookingService {

    boolean getVaccineBookingByUserID(String userID);

    boolean save(VaccineBooking vaccineBooking);

    VaccineBooking getInfoByUserID(String userID);
}
