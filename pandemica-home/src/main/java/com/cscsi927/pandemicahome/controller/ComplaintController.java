package com.cscsi927.pandemicahome.controller;


import com.csci927.pandemicaapply.bean.Application;
import com.csci927.pandemicaapply.bean.Complaint;
import com.csci927.pandemicaapply.service.ApplicationService;
import com.csci927.pandemicaapply.service.ComplaintService;
import com.csci927.pandemicaregistration.bean.JSONResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  ComplaintController
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
@Controller
@RequestMapping("/oauth")
public class ComplaintController {

    @DubboReference(interfaceClass = ComplaintService.class, version = "1.0.0", check = true)
    private ComplaintService complaintService;
    @DubboReference(interfaceClass = ApplicationService.class, version = "1.0.0", check = true)
    private ApplicationService applicationService;


    @GetMapping("/complaint")
    public String complaint(String userID){
        return "/complaint.html";
    }
    @ResponseBody
    @PostMapping("/saveComplaint")
    public JSONResult saveComplaint(@RequestBody Complaint complaint){
        JSONResult jsonResult = new JSONResult();
        if (StringUtils.isEmpty(complaint.getComplaintInfo()) || complaint.getComplaintAmount() == null || StringUtils.isEmpty(complaint.getUserID())) {
            jsonResult.setStateValue("false");
            jsonResult.setReturnInfo("Complaint Comments or Complaint Amount or UserID is NOT empty!");
            return jsonResult;
        }
        boolean hasComplaint = complaintService.getComplaintByUserID(complaint.getUserID());
        if(hasComplaint){
            jsonResult.setStateValue("false");
            jsonResult.setReturnInfo("You have applied for complaint, Please do not enter it again!");
            return jsonResult;
        }
        boolean hasApplicaiton = applicationService.getApplicationByUserID(complaint.getUserID());
        if(!hasApplicaiton){
            jsonResult.setStateValue("false");
            jsonResult.setReturnInfo("You haven't even applied for compensation, Please do not enter it again!");
            return jsonResult;
        }
        boolean bool = complaintService.save(complaint);
        if(bool){
            jsonResult.setStateValue("true");
            jsonResult.setReturnInfo("Apply complaint successfully, Please wait to reply within 3 workdays!!!");
            return jsonResult;
        }
        jsonResult.setStateValue("false");
        jsonResult.setReturnInfo("Apply for complaint failed, Please retry!");
        return jsonResult;
    }
}

