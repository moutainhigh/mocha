package com.efruit.micro.arkmanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.arkmanager.pojo.DispatchingCourierInfo;
import com.efruit.micro.arkmanager.service.*;
import com.efruit.micro.arkmanager.service.model.Code;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 配送 取货
 */
@RestController
@RequestMapping("/courier")
public class DispatchingCourierController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatchingCourierController.class);
    @Autowired
    private DispatchingCourierInfoService courierInfoService;

    //列表
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult list() {
        List<DispatchingCourierInfo> data = courierInfoService.selectAll();
        return ArkCommonResult.build(Code.success.getCode(), Code.success.getMsg(), data);
    }

    //添加
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult add(@RequestBody DispatchingCourierInfo courierInfo) {
        LOGGER.info("DispatchingCourierController.add  param:{}", JSONObject.toJSONString(courierInfo));
        if (courierInfo == null || StringUtils.isEmpty(courierInfo.getMobile()) || StringUtils.isEmpty(courierInfo.getName())) {
            return ArkCommonResult.build(Code.parameter_error.getCode(), Code.parameter_error.getMsg());
        }
        int saveRow = courierInfoService.save(courierInfo);
        if (saveRow == 1) {
            return ArkCommonResult.build(Code.success.getCode(), "添加成功！");
        }
        return ArkCommonResult.build(Code.success.getCode(), "已添加！不能重复添加");
    }

    //更新
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult update(@RequestBody DispatchingCourierInfo courierInfo) {
        LOGGER.info("DispatchingCourierController.update  param:{}", JSONObject.toJSONString(courierInfo));
        if (courierInfo == null) {
            return ArkCommonResult.build(Code.parameter_error.getCode(), Code.parameter_error.getMsg(), courierInfo);
        }
        courierInfoService.update(courierInfo);
        return ArkCommonResult.build(Code.success.getCode(), "更新成功", courierInfo);
    }

    //删除
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ArkCommonResult delete(@RequestBody DispatchingCourierInfo courierInfo) {
        LOGGER.info("DispatchingCourierController.delete  param:{}", JSONObject.toJSONString(courierInfo));
        if (courierInfo == null && courierInfo.getId() == null) {
            return ArkCommonResult.build(Code.parameter_error.getCode(), Code.parameter_error.getMsg());
        }
        final Long id = courierInfo.getId();
        courierInfoService.delete(id);
        return ArkCommonResult.build(Code.success.getCode(), "删除成功！");
    }

}
