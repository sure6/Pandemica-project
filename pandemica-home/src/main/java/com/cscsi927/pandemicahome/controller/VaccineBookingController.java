package com.cscsi927.pandemicahome.controller;


import com.csci927.pandemicaapply.bean.Application;
import com.csci927.pandemicaregistration.bean.JSONResult;
import com.csci927.pandemicavaccinebooking.bean.VaccineBooking;
import com.csci927.pandemicavaccinebooking.service.VaccineBookingService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author sure
 * @since 2022-10-09
 */
@Controller
@RequestMapping("/oauth")
public class VaccineBookingController {


    @DubboReference(interfaceClass = VaccineBookingService.class, version = "1.0.3", check = true)
    private VaccineBookingService vaccineBookingService;

    @GetMapping("vaccineBooking")
    public String vaccineBooking(){
        return "/vaccinebooking.html";
    }

    @GetMapping("comfirmation")
    public String vaccineComfirmation(){
        return "/confirmation.html";
    }


    @ResponseBody
    @PostMapping("/saveVaccineBooking")
    public JSONResult saveApplicationInfo(@RequestBody VaccineBooking vaccineBooking) {
        JSONResult jsonResult = new JSONResult();
        if (StringUtils.isEmpty(vaccineBooking.getComments()) || vaccineBooking.getVaccineNum() == null || StringUtils.isEmpty(vaccineBooking.getVaccineType())) {
            jsonResult.setStateValue("false");
            jsonResult.setReturnInfo("Comments or Vaccination Number or Vaccination Type is NOT empty!");
            return jsonResult;
        }
        boolean hasApplicaiton = vaccineBookingService.getVaccineBookingByUserID(vaccineBooking.getUserID());
        if(hasApplicaiton){
            jsonResult.setStateValue("false");
            jsonResult.setReturnInfo("You have booked for vaccination, please do not book again!");
            return jsonResult;
        }
        boolean bool = vaccineBookingService.save(vaccineBooking);
        if(bool){
            jsonResult.setStateValue("true");
            jsonResult.setReturnInfo("book vaccination successfully!!!");
            return jsonResult;
        }
        jsonResult.setStateValue("false");
        jsonResult.setReturnInfo("book vaccination failed, Please retry!");
        return jsonResult;
    }

    @ResponseBody
    @GetMapping("vaccineBooking/{userID}")
    public VaccineBooking getInfo(@PathVariable String userID){
        return vaccineBookingService.getInfoByUserID(userID);
    }
}

