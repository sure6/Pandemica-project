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
 * @since 2022-09-26
 */
@TableName("User")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("firstName")
    private String firstName;

    @TableField("lastName")
    private String lastName;

    private Integer age;

    private String gender;

    @TableField("phoneNumber")
    private String phoneNumber;

    private String email;

    private String position;

      @TableId(value = "userID", type = IdType.AUTO)
    private String userID;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "User{" +
        "firstName=" + firstName +
        ", lastName=" + lastName +
        ", age=" + age +
        ", gender=" + gender +
        ", phoneNumber=" + phoneNumber +
        ", email=" + email +
        ", position=" + position +
        ", userID=" + userID +
        "}";
    }
}
