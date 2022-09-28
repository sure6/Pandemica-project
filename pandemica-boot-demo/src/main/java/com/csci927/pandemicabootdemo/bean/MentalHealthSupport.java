package com.csci927.pandemicabootdemo.bean;


import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author sure
 * @since 2022-09-28
 */
public class MentalHealthSupport implements Serializable {

    private static final long serialVersionUID=1L;

    private String userID;

    private String serviceType;

    private String reason;


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "MentalHealthSupport{" +
        "userID=" + userID +
        ", serviceType=" + serviceType +
        ", reason=" + reason +
        "}";
    }
}
