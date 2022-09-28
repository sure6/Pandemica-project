package com.cscsi927.pandemicahome.controller;


import com.csci927.pandemicamentalhealth.bean.Consultation;
import com.csci927.pandemicamentalhealth.service.ConsultationService;
import com.csci927.pandemicamentalhealth.service.MentalHealthSupportService;
import com.csci927.pandemicaregistration.bean.JSONResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sure
 * @since 2022-09-28
 */
@Controller
public class ConsultationController {
    @DubboReference(interfaceClass = ConsultationService.class, version = "1.0.2", check = true)
    private ConsultationService consultationService;

    @DubboReference(interfaceClass = MentalHealthSupportService.class, version = "1.0.2", check = true)
    private MentalHealthSupportService mentalHealthSupportService;

    @GetMapping("/oauth/consultation")
    public String mentalHealthSupport() {
        return "/consultation.html";
    }

    @ResponseBody
    @PostMapping("/oauth/saveConsultation")
    public JSONResult saveConsultation(@RequestBody Consultation consultation) {
        JSONResult jsonResult = new JSONResult();
        if (StringUtils.isEmpty(consultation.getSymptoms()) || consultation.getConsultationFee() == null || StringUtils.isEmpty(consultation.getUserID()) || StringUtils.isEmpty(consultation.getGpName())) {
            jsonResult.setStateValue("false");
            jsonResult.setReturnInfo("Symptoms or General Practitioner or ConsultationFee or UseID is NOT empty!");
            return jsonResult;
        }
        boolean hasComplaint = consultationService.getConsultationByUserID(consultation.getUserID());
        if (hasComplaint) {
            jsonResult.setStateValue("false");
            jsonResult.setReturnInfo("You have applied for consultation, Please do not enter it again!");
            return jsonResult;
        }
        boolean hasUserChooseGC = mentalHealthSupportService.getMHSByUserIDAndServiceType(consultation.getUserID(),"2");
        if (!hasUserChooseGC) {
            jsonResult.setStateValue("false");
            jsonResult.setReturnInfo("You haven't even applied for contacting GC, Please do not enter it again!");
            return jsonResult;
        }
        boolean bool = consultationService.saveConsultationInfo(consultation);
        if (bool) {
            jsonResult.setStateValue("true");
            jsonResult.setReturnInfo("Apply consultation successfully, Please wait to reply within 3 workdays!!!");
            return jsonResult;
        }
        jsonResult.setStateValue("false");
        jsonResult.setReturnInfo("Apply for consultation failed, Please retry!");
        return jsonResult;
    }
}

