package com.csci927.pandemicaregistration.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author sure
 * @since 2022-09-21
 */
@TableName("User")
public class User implements Serializable {

    private static final long serialVersionUID = -6465494470754667710L;

      @TableId(value = "userID")
    private String userID;

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

    private UserAccount userAccount;

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

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

    @Override
    public String toString() {
        return "User{" +
        "userID=" + userID +
        ", firstName=" + firstName +
        ", lastName=" + lastName +
        ", age=" + age +
        ", gender=" + gender +
        ", phoneNumber=" + phoneNumber +
        ", email=" + email +
        ", position=" + position +
                ", username=" + userAccount.getUsername() +
                ", password=" + userAccount.getPassword() +
        "}";
    }
}
