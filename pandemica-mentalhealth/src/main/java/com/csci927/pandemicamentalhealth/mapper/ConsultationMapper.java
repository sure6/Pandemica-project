package com.csci927.pandemicamentalhealth.mapper;

import com.csci927.pandemicamentalhealth.bean.Consultation;

import java.util.List;

/**
 * <p>
 *  Mapper
 * </p>
 *
 * @author sure
 * @since 2022-09-28
 */
public interface ConsultationMapper {

    List<Consultation> selectByUserID(String userID);

    int insertInfo(Consultation consultation);
}
