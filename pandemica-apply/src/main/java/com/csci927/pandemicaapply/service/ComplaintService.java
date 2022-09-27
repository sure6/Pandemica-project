package com.csci927.pandemicaapply.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.csci927.pandemicaapply.bean.Complaint;

/**
 * <p>
 *  ComplaintService
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
public interface ComplaintService extends IService<Complaint> {

    boolean saveComplaint(Complaint complaint);

    boolean getComplaintByUserID(String userID);
}
