package com.efruit.micro.youzan.sdk.model;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.youzan.open.sdk.model.APIParams;
import com.youzan.open.sdk.model.ByteWrapper;
import com.youzan.open.sdk.model.FileParams;

import java.util.Map;

public class YouzanMultistoreAddressGetParams implements APIParams, FileParams {

    /**
     * 网点id
     */
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }


    public Map<String, Object> toParams() {
        Map<String, Object> params = Maps.newHashMap();
        if (id != null) {
            params.put("id", id);
        }
        return params;
    }

    public Multimap<String, ByteWrapper> toFileParams() {
        Multimap<String, ByteWrapper> params = ArrayListMultimap.create();

        return params;
    }


}