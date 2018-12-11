package com.efruit.micro.arkmanager.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.efruit.micro.arkmanager.service.model.Code;
import org.springframework.util.StringUtils;

//通用的controller返回格式
public class ControllerResult {
    private static final JSONValueFilter defaultDateFilter  = new JSONValueFilter();

    public static String buildResultData(Code code, String desc, Object info){
        JSONObject result = new JSONObject();
        result.put("code", code.getCode());
        if(!StringUtils.isEmpty(desc)){
            result.put("msg",desc);
        }else{
            result.put("msg",code.getMsg());
        }
        if(info != null){
            result.put("data",info);
        }else{
            result.put("data","");
        }
        return JSONObject.toJSONString(result,
                defaultDateFilter,
                SerializerFeature.QuoteFieldNames,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.SkipTransientField);
    }
    public static String buildResult(Code code,String desc){
        if(!StringUtils.isEmpty(desc)){
            return buildResultData(code,desc,null);
        }
        return buildResultData(code,code.getMsg(),null);
    }
    public static String buildResult(Code code){
        return buildResultData(code,code.getMsg(),null);
    }
    public static String buildResultData(Code code,Object info){
        if(info != null){
            return buildResultData(code,code.getMsg(),info);
        }
        return buildResultData(code,code.getMsg(),null);
    }
}
