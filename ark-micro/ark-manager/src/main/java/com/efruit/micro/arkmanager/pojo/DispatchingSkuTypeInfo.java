package com.efruit.micro.arkmanager.pojo;

public class DispatchingSkuTypeInfo {
    private Long id;

    private String title;

    private String skupropertiesname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSkupropertiesname() {
        return skupropertiesname;
    }

    public void setSkupropertiesname(String skupropertiesname) {
        this.skupropertiesname = skupropertiesname == null ? null : skupropertiesname.trim();
    }
}