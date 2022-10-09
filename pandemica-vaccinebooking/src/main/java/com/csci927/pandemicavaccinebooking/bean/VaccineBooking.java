package com.csci927.pandemicavaccinebooking.bean;

import java.io.Serializable;

/**
 *
 * @author sure
 * @since 2022-10-09
 */
public class VaccineBooking implements Serializable {

    private static final long serialVersionUID=1L;

    private String userID;

    private String vaccineType;

    private Integer vaccineNum;

    private String comments;


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public Integer getVaccineNum() {
        return vaccineNum;
    }

    public void setVaccineNum(Integer vaccineNum) {
        this.vaccineNum = vaccineNum;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "VaccineBooking{" +
        "userID=" + userID +
        ", vaccineType=" + vaccineType +
        ", vaccineNum=" + vaccineNum +
        ", comments=" + comments +
        "}";
    }
}
