package com.csci927.pandemicamentalhealth.service;


import com.csci927.pandemicamentalhealth.bean.Consultation;

/**
 *
 * @author sure
 * @since 2022-09-28
 */
public interface ConsultationService {

    boolean getConsultationByUserID(String userID);

    boolean saveConsultationInfo(Consultation consultation);
}
