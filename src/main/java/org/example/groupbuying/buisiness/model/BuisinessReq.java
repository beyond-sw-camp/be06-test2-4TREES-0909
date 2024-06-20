package org.example.groupbuying.buisiness.model;

public class BuisinessReq {
    String comInfoName;
    String comInfoAddress;
    String comInfoType;
    String comInfoIntro;
    Integer comInfoIdx;

    public BuisinessReq(String comInfoName, String comInfoAddress, String comInfoType, String comInfoIntro, Integer comInfoIdx) {
        this.comInfoName = comInfoName;
        this.comInfoAddress = comInfoAddress;
        this.comInfoType = comInfoType;
        this.comInfoIntro = comInfoIntro;
        this.comInfoIdx = comInfoIdx;
    }

    public String getComInfoName() {
        return comInfoName;
    }

    public void setComInfoName(String comInfoName) {
        this.comInfoName = comInfoName;
    }

    public String getComInfoAddress() {
        return comInfoAddress;
    }

    public void setComInfoAddress(String comInfoAddress) {
        this.comInfoAddress = comInfoAddress;
    }

    public String getComInfoType() {
        return comInfoType;
    }

    public void setComInfoType(String comInfoType) {
        this.comInfoType = comInfoType;
    }

    public String getComInfoIntro() {
        return comInfoIntro;
    }

    public void setComInfoIntro(String comInfoIntro) {
        this.comInfoIntro = comInfoIntro;
    }

    public Integer getComInfoIdx() {
        return comInfoIdx;
    }

    public void setComInfoIdx(Integer comInfoIdx) {
        this.comInfoIdx = comInfoIdx;
    }
}