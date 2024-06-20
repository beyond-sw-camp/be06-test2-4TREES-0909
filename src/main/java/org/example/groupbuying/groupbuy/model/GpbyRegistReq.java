package org.example.groupbuying.groupbuy.model;

public class GpbyRegistReq {
    private Integer categoryIdx;
    private String gpbyTitle;
    private String gpbyContent;
    private Integer gpbyQuantity;
    private Integer gpbyEnddate;

    public GpbyRegistReq(Integer categoryIdx, String gpbyTitle, String gpbyContent, Integer gpbyQuantity, Integer gpbyEnddate) {
        this.categoryIdx = categoryIdx;
        this.gpbyTitle = gpbyTitle;
        this.gpbyContent = gpbyContent;
        this.gpbyQuantity = gpbyQuantity;
        this.gpbyEnddate = gpbyEnddate;
    }

    public Integer getCategoryIdx() {
        return categoryIdx;
    }

    public void setCategoryIdx(Integer categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    public String getGpbyTitle() {
        return gpbyTitle;
    }

    public void setGpbyTitle(String gpbyTitle) {
        this.gpbyTitle = gpbyTitle;
    }

    public String getGpbyContent() {
        return gpbyContent;
    }

    public void setGpbyContent(String gpbyContent) {
        this.gpbyContent = gpbyContent;
    }

    public Integer getGpbyQuantity() {
        return gpbyQuantity;
    }

    public void setGpbyQuantity(Integer gpbyQuantity) {
        this.gpbyQuantity = gpbyQuantity;
    }

    public Integer getGpbyEnddate() {
        return gpbyEnddate;
    }

    public void setGpbyEnddate(Integer gpbyEnddate) {
        this.gpbyEnddate = gpbyEnddate;
    }
}
