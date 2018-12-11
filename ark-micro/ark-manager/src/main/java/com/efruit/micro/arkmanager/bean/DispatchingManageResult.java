package com.efruit.micro.arkmanager.bean;

import java.util.Date;
import java.util.List;

//配送地址列表
public class DispatchingManageResult {
    private String tid;
    private String buyerName;
    private String buyerTel;
    private String addressName;
    private Long addressId;
    private int status;
    private String fetchCode;
    private Date sendDate;
    private boolean isReissue;
    private String areaName;
    private List<ManageOrderDetails> orderDetailsList;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerTel() {
        return buyerTel;
    }

    public void setBuyerTel(String buyerTel) {
        this.buyerTel = buyerTel;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFetchCode() {
        return fetchCode;
    }

    public void setFetchCode(String fetchCode) {
        this.fetchCode = fetchCode;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public boolean isReissue() {
        return isReissue;
    }

    public void setReissue(boolean reissue) {
        isReissue = reissue;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public List<ManageOrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public void setOrderDetailsList(List<ManageOrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    public class ManageOrderDetails{
        private String title;
        private Long cid;
        private int num;
        private String skuTitle;
        private String img;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getSkuTitle() {
            return skuTitle;
        }

        public void setSkuTitle(String skuTitle) {
            this.skuTitle = skuTitle;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public Long getCid() {
            return cid;
        }

        public void setCid(Long cid) {
            this.cid = cid;
        }
    }

}



