package com.csci927.pandemicabootdemo.bean;

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
@TableName("UserAccount")
public class UserAccount implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "username")
    private String username;

    private String password;

    @TableField("userID")
    private String userID;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
        "username=" + username +
        ", password=" + password +
        ", userID=" + userID +
        "}";
    }
}
