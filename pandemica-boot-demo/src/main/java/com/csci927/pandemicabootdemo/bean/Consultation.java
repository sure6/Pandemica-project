package com.csci927.pandemicabootdemo.bean;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author sure
 * @since 2022-09-28
 */
public class Consultation implements Serializable {

    private static final long serialVersionUID=1L;

    private String userID;

    private String symptoms;

    private BigDecimal consultationFee;

    private String gpName;


    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public BigDecimal getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(BigDecimal consultationFee) {
        this.consultationFee = consultationFee;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    @Override
    public String toString() {
        return "Consultation{" +
        "userID=" + userID +
        ", consultationType=" + symptoms +
        ", consultationFee=" + consultationFee +
        ", gpName=" + gpName +
        "}";
    }
}
