package com.csci927.pandemicaapi.bean;

import java.io.Serializable;

public class Cervaluation implements Serializable {
    private Integer cNumber;
    private String eText;
    private Integer erank;
    private Integer pNumber;

    public Integer getcNumber() {
        return cNumber;
    }

    public void setcNumber(Integer cNumber) {
        this.cNumber = cNumber;
    }

    public String geteText() {
        return eText;
    }

    public void seteText(String eText) {
        this.eText = eText;
    }

    public Integer getErank() {
        return erank;
    }

    public void setErank(Integer erank) {
        this.erank = erank;
    }

    public Integer getpNumber() {
        return pNumber;
    }

    public void setpNumber(Integer pNumber) {
        this.pNumber = pNumber;
    }


}
