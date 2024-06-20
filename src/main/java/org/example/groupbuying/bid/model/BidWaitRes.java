package org.example.groupbuying.bid.model;

public class BidWaitRes {

    private int gpbyIdx;
    private String gpbyTitle;
    private int gpbyQuantity;

    public BidWaitRes(int gpbyIdx, String gpbyTitle, int gpbyQuantity) {
        this.gpbyIdx = gpbyIdx;
        this.gpbyTitle = gpbyTitle;
        this.gpbyQuantity = gpbyQuantity;
    }

    public int getGpbyIdx() {
        return gpbyIdx;
    }

    public String getGpbyTitle() {
        return gpbyTitle;
    }

    public int getGpbyQuantity() {
        return gpbyQuantity;
    }
}
