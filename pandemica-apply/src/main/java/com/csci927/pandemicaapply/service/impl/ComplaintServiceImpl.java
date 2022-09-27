package com.csci927.pandemicaapply.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csci927.pandemicaapply.bean.Complaint;
import com.csci927.pandemicaapply.mapper.ComplaintMapper;
import com.csci927.pandemicaapply.service.ComplaintService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
@DubboService(interfaceClass = ComplaintService.class, version = "1.0.0",timeout = 60000)
public class ComplaintServiceImpl extends ServiceImpl<ComplaintMapper, Complaint> implements ComplaintService {

    @Autowired
    private ComplaintMapper complaintMapper;
    @Override
    public boolean saveComplaint(Complaint complaint){
        return complaintMapper.insert(complaint)>0;
    }
    @Override
   public boolean getComplaintByUserID(String userID){
       if(StringUtils.isEmpty(userID)){
           return false;
       }
       return complaintMapper.selectByUserID(userID).size()>0;
    }
}
