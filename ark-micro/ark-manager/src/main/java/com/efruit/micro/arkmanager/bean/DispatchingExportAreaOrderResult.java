package com.efruit.micro.arkmanager.bean;

import java.util.List;
import java.util.Map;

//配送地址列表
public class DispatchingExportAreaOrderResult {

    //片区名称
    private String areaName;
    private Long areaId;
    private Map<Integer,FetchUser> userMap;
    private Map<String,FetchUser> telUserMap;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Map<Integer, FetchUser> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<Integer, FetchUser> userMap) {
        this.userMap = userMap;
    }

    public Map<String, FetchUser> getTelUserMap() {
        return telUserMap;
    }

    public void setTelUserMap(Map<String, FetchUser> telUserMap) {
        this.telUserMap = telUserMap;
    }

    /**
     * 收货人
     */
    public class FetchUser {

        //序号，也是取货码
        private String fetchCode;

        //提货人
        private String userName;

        //联系电话
        private String userTel;
        //人所属大厦
        private String addressName;
        private Long  addressId;

        private List<Books> booksList;

        public String getFetchCode() {
            return fetchCode;
        }

        public void setFetchCode(String fetchCode) {
            this.fetchCode = fetchCode;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserTel() {
            return userTel;
        }

        public void setUserTel(String userTel) {
            this.userTel = userTel;
        }

        public List<Books> getBooksList() {
            return booksList;
        }

        public void setBooksList(List<Books> booksList) {
            this.booksList = booksList;
        }

        public String getAddressName() {
            return addressName;
        }

        public void setAddressName(String addressName) {
            this.addressName = addressName;
        }

        public Long getAddressId() {
            return addressId;
        }

        public void setAddressId(Long addressId) {
            this.addressId = addressId;
        }
    }

    /**
     * 商品
     */
    public class Books {

        //商品名称
        private String title;

        //商品规格
        private String specification;

        //数量
        private int num;

        private Long skuId;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSpecification() {
            return specification;
        }

        public void setSpecification(String specification) {
            this.specification = specification;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public Long getSkuId() {
            return skuId;
        }

        public void setSkuId(Long skuId) {
            this.skuId = skuId;
        }
    }

}





