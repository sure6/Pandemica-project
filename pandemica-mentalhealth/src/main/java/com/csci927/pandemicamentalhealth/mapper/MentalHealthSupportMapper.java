package com.csci927.pandemicamentalhealth.mapper;

import com.csci927.pandemicamentalhealth.bean.MentalHealthSupport;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  Mapper
 * </p>
 *
 * @author sure
 * @since 2022-09-28
 */
public interface MentalHealthSupportMapper {
    List<MentalHealthSupport> selectByUserID(String userID);

    int insertMHS (MentalHealthSupport mentalHealthSupport);

    List<MentalHealthSupport> selectByUserIDAndServiceType(String userID, String serviceType);
}
