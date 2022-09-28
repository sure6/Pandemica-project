package com.csci927.pandemicabootdemo.controller;


import com.csci927.pandemicabootdemo.bean.JSONResult;
import com.csci927.pandemicabootdemo.bean.MentalHealthSupport;
import com.csci927.pandemicabootdemo.service.MentalHealthSupportService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 *
 * @author sure
 * @since 2022-09-28
 */
@Controller
//@RequestMapping("/mentalHealthSupport")
public class MentalHealthSupportController {

    @Autowired
    private MentalHealthSupportService mentalHealthSupportService;

    @GetMapping("mentalHealthSupport")
    public String mentalHealthSupport(){
        return "/mentalHealthSupport.html";
    }

    @ResponseBody
    @PostMapping("/oauth/saveMHS")
    public JSONResult saveMHS(@RequestBody MentalHealthSupport mentalHealthSupport){
        System.out.println(mentalHealthSupport);
        JSONResult jsonResult = new JSONResult();
        if (StringUtils.isEmpty(mentalHealthSupport.getReason()) ||StringUtils.isEmpty(mentalHealthSupport.getServiceType())  || StringUtils.isEmpty(mentalHealthSupport.getUserID())) {
            jsonResult.setStateValue("false");
            jsonResult.setReturnInfo("Needs reason or Mental health support option or UserID is NOT empty!");
            return jsonResult;
        }
        boolean hasMHS = mentalHealthSupportService.getMHSByUserID(mentalHealthSupport.getUserID());
        if(hasMHS){
            jsonResult.setStateValue("false");
            jsonResult.setReturnInfo("You have applied for Mental health support , please do not enter it again!");
            return jsonResult;
        }
        boolean bool = mentalHealthSupportService.saveData(mentalHealthSupport);
        if(bool){
            jsonResult.setStateValue("true");
            jsonResult.setReturnInfo("Apply mental health support successfully, Wait to reply within 3 workdays!!!");
            return jsonResult;
        }
        jsonResult.setStateValue("false");
        jsonResult.setReturnInfo("Apply mental health support failed, Please retry!");
        return jsonResult;
    }

    @ResponseBody
    @GetMapping("mhs/{userID}")
    public MentalHealthSupport getInfo(@PathVariable String userID){
        return mentalHealthSupportService.getInfoByUserID(userID);
    }

}

