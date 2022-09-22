package com.csci927.pandemicabootdemo.bean;

import java.io.Serializable;

public class JSONResult implements Serializable {

    private String stateValue;

    private String returnInfo;

    public JSONResult() {
    }

    public JSONResult(String stateValue, String returnInfo) {
        this.stateValue = stateValue;
        this.returnInfo = returnInfo;
    }

    public String getStateValue() {
        return stateValue;
    }

    public void setStateValue(String stateValue) {
        this.stateValue = stateValue;
    }

    public String getReturnInfo() {
        return returnInfo;
    }

    public void setReturnInfo(String returnInfo) {
        this.returnInfo = returnInfo;
    }
}
