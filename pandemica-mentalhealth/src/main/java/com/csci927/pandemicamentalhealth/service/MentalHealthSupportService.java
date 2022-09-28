package com.csci927.pandemicamentalhealth.service;

import com.csci927.pandemicamentalhealth.bean.MentalHealthSupport;

/**
 * @author sure
 * @since 2022-09-28
 */
public interface MentalHealthSupportService {

    boolean getMHSByUserID(String userID);

    boolean saveData(MentalHealthSupport mentalHealthSupport);

    boolean getMHSByUserIDAndServiceType(String userID, String serviceType);

    MentalHealthSupport getInfoByUserID(String userID);
}
