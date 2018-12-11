package com.efruit.micro.youzan.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.StringUtils;

public class OrderSelfFetchInfo {
    private String address_detail;
    private String city;
    private String county;
    private String province;
    private Long id;
    private Long kdt_id;
    private Double lat;
    private Double lon;
    private String name;
    private String tel;
    private String user_name;
    private String user_tel;

    public String getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(String address_detail) {
        this.address_detail = address_detail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKdt_id() {
        return kdt_id;
    }

    public void setKdt_id(Long kdt_id) {
        this.kdt_id = kdt_id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public static OrderSelfFetchInfo fromJson(String jsonStr) {
        if (StringUtils.isEmpty(jsonStr)) {
            return null;
        }
        return JSON.parseObject(jsonStr, new TypeReference<OrderSelfFetchInfo>(){});
    }
}
