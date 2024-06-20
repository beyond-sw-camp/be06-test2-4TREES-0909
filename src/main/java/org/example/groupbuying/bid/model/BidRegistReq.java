package org.example.groupbuying.bid.model;

public class BidRegistReq {
    private int productIdx;
    private int gpbyIdx;
    private int bidPrice;

    public int getProductIdx() {
        return productIdx;
    }

    public int getGpbyIdx() {
        return gpbyIdx;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public void setProductIdx(int productIdx) {
        this.productIdx = productIdx;
    }

    public void setGpbyIdx(int gpbyIdx) {
        this.gpbyIdx = gpbyIdx;
    }

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }
}
