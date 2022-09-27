package com.csci927.pandemicaapply.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.csci927.pandemicaapply.bean.Application;

/**
 * <p>
 *  ApplicationService
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
public interface ApplicationService extends IService<Application> {

    boolean getApplicationByUserID(String userID);

    Application getInfoByUserID(String userID);
}
