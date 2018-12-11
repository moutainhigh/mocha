package com.efruit.micro.arkmanager.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.List;

public class DispatchingAddressInfo {
    private Long id;

    private String name;

    private String address;
    @JSONField(serialize = false)
    private String city;
    @JSONField(serialize = false)
    private String area;
    @JSONField(serialize = false)
    private Long kdtId;
    @JSONField(serialize = false)
    private Long sid;

    private String lng;

    private String lat;

    private String description;
    @JSONField(serialize = false)
    private String ids;
    @JSONField(serialize = false)
    private String province;
    @JSONField(serialize = false)
    private String user_tel;

    @JSONField(serialize = false)
    private String user_name;
    private int distance;

    private Long areaId;

    private DispatchingAreaInfo areaInfo;

    private List<DispatchingOrder> orderList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public List<DispatchingOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<DispatchingOrder> orderList) {
        this.orderList = orderList;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Long getKdtId() {
        return kdtId;
    }

    public void setKdtId(Long kdtId) {
        this.kdtId = kdtId;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DispatchingAreaInfo getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(DispatchingAreaInfo areaInfo) {
        this.areaInfo = areaInfo;
    }
}