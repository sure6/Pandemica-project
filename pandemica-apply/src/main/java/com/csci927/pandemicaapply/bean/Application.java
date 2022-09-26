package com.csci927.pandemicaapply.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
@TableName("Application")
public class Application implements Serializable {

    private static final long serialVersionUID = -5435794470754667710L;

    @TableField("applicationInfo")
    private String applicationInfo;

    @TableField("compensationAmount")
    private BigDecimal compensationAmount;

    @TableField("userID")
    private String userID;


    public String getApplicationInfo() {
        return applicationInfo;
    }

    public void setApplicationInfo(String applicationInfo) {
        this.applicationInfo = applicationInfo;
    }

    public BigDecimal getCompensationAmount() {
        return compensationAmount;
    }

    public void setCompensationAmount(BigDecimal compensationAmount) {
        this.compensationAmount = compensationAmount;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Application{" +
        "applicationInfo=" + applicationInfo +
        ", compensationAmount=" + compensationAmount +
        ", userID=" + userID +
        "}";
    }
}
