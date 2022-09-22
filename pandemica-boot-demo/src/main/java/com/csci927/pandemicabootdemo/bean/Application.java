package com.csci927.pandemicabootdemo.bean;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

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

    private static final long serialVersionUID=1L;

      @TableId(value = "applicationID", type = IdType.AUTO)
    private Integer applicationID;

    @TableField("applicationInfo")
    private String applicationInfo;

    @TableField("compensationAmount")
    private BigDecimal compensationAmount;

    @TableField("userID")
    private String userID;


    public Integer getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(Integer applicationID) {
        this.applicationID = applicationID;
    }

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
        "applicationID=" + applicationID +
        ", applicationInfo=" + applicationInfo +
        ", compensationAmount=" + compensationAmount +
        ", userID=" + userID +
        "}";
    }
}
