package com.cscsi927.pandemicahome.controller;


import com.csci927.pandemicaapply.bean.Application;
import com.csci927.pandemicaapply.service.ApplicationService;
import com.csci927.pandemicaregistration.bean.JSONResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * ApplicationController
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
@Controller
@RequestMapping("/oauth/")
public class ApplicationController {

    @DubboReference(interfaceClass = ApplicationService.class, version = "1.0.0", check = true)
    private ApplicationService applicationService;

    @GetMapping("application/apply")
    public String apply() {
        return "/apply.html";
    }

    @ResponseBody
    @PostMapping("application/saveApplication")
    public JSONResult saveApplicationInfo(@RequestBody Application application) {
        JSONResult jsonResult = new JSONResult();
        System.out.println(application);
        if (StringUtils.isEmpty(application.getApplicationInfo()) || application.getCompensationAmount() == null || StringUtils.isEmpty(application.getUserID())) {
            jsonResult.setStateValue("false");
            jsonResult.setReturnInfo("Application Comments or Compensation Amount or UserID is NOT empty!");
            return jsonResult;
        }
        boolean bool = applicationService.save(application);
        if(bool){
            jsonResult.setStateValue("true");
            jsonResult.setReturnInfo("Apply  compensation successfully, Wait to reply within 3 workdays!!!");
            return jsonResult;
        }
        jsonResult.setStateValue("false");
        jsonResult.setReturnInfo("Apply  compensation failed, Please retry!");
        return jsonResult;
    }
}

