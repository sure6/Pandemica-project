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
 * @since 2022-09-26
 */
@TableName("Complaint")
public class Complaint implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "complaintID", type = IdType.AUTO)
    private Integer complaintID;

    @TableField("complaintInfo")
    private String complaintInfo;

    @TableField("complaintAmount")
    private BigDecimal complaintAmount;

    @TableField("userID")
    private String userID;


    public Integer getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(Integer complaintID) {
        this.complaintID = complaintID;
    }

    public String getComplaintInfo() {
        return complaintInfo;
    }

    public void setComplaintInfo(String complaintInfo) {
        this.complaintInfo = complaintInfo;
    }

    public BigDecimal getComplaintAmount() {
        return complaintAmount;
    }

    public void setComplaintAmount(BigDecimal complaintAmount) {
        this.complaintAmount = complaintAmount;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Complaint{" +
        "complaintID=" + complaintID +
        ", complaintInfo=" + complaintInfo +
        ", complaintAmount=" + complaintAmount +
        ", userID=" + userID +
        "}";
    }
}
