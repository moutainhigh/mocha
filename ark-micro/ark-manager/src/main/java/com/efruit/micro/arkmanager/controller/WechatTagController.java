package com.efruit.micro.arkmanager.controller;

import com.efruit.micro.arkcommon.ArkCommonResult;
import com.efruit.micro.arkmanager.bean.OrderCondition;
import com.efruit.micro.arkmanager.bean.QueryResult;
import com.efruit.micro.arkmanager.pojo.AOrder;
import com.efruit.micro.arkmanager.service.NewOrderService;
import com.efruit.micro.arkmanager.utils.BatchTagCondition;
import com.efruit.micro.wechat.service.WechatMpService;
import com.efruit.micro.wechat.service.WechatMpUserService;
import com.efruit.micro.wechat.service.WechatTagUserService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpUserTagService;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/wechat/tags")
public class WechatTagController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatTagController.class);

    @Autowired
    WechatMpService wechatMpService;

    @Autowired
    WechatMpUserService wechatMpUserService;

    @Autowired
    NewOrderService newOrderService;

    @Autowired
    WechatTagUserService wechatTagUserService;

    @RequestMapping(value = "/tagInverse", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public ArkCommonResult tagInverse(@RequestParam Map<String, String> params) {

        final String tagName = params.get("tagName");
        final String inverseTagName = params.get("inverseTagName");

        if (StringUtils.isAnyBlank(tagName, inverseTagName)) {
            return ArkCommonResult.fail("params error, please check.");
        }

        WxUserTag wxUserTag = null;
        try {
            wxUserTag = getWxUserTag(tagName);
        } catch (WxErrorException e) {
            LOGGER.info("getWxUserTag error.", e);
            return ArkCommonResult.fail("getWxUserTag error.");
        }

        final List<String> tagUserList = wechatTagUserService.getTagUserList(wxUserTag);
        if (CollectionUtils.isEmpty(tagUserList)) {
            return ArkCommonResult.fail("tagUserList is empty.");
        }

        List<String> allUserList = null;
        try {
            allUserList = wechatMpUserService.getAllUserList();
        } catch (WxErrorException e) {
            LOGGER.info("getAllUserList error.", e);
        }

        if (CollectionUtils.isEmpty(allUserList)) {
            return ArkCommonResult.fail("allUserList is empty.");
        }

        LOGGER.info("allUserList count : {}", allUserList.size());

        // 从所有用户列表减去当前标签用户列表
        List<String> validList = (List<String>) CollectionUtils.subtract(allUserList, tagUserList);
        if (CollectionUtils.isEmpty(validList)) {
            return ArkCommonResult.fail("validList is empty.");
        }

        WxUserTag inverseUserTag = null;
        try {
            inverseUserTag = getWxUserTag(inverseTagName);
        } catch (WxErrorException e) {
            LOGGER.info("customTag() getWxUserTag error", e);
        }

        if (inverseUserTag != null) {
            return ArkCommonResult.fail("inverseUserTag exist，please check.");
        } else {
            try {
                inverseUserTag = createUserTag(inverseTagName);
            } catch (WxErrorException e) {
                LOGGER.info("createUserTag error", e);
            }
        }

        if (inverseUserTag == null) {
            return ArkCommonResult.fail("inverseUserTag create failed, please check.");
        }

        wechatTagUserService.batchTaggingAll(inverseUserTag, validList);

        return ArkCommonResult.ok();
    }

    @RequestMapping(value = "/customtag", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public ArkCommonResult customTag(@RequestBody BatchTagCondition condition) {
        LOGGER.info("customTag() start....");
        final String wxTagName = condition.getWxTagName();
        if (StringUtils.isEmpty(wxTagName)) {
            return ArkCommonResult.fail("WxTagName can not be null. please check!");
        }

        condition.setSelectFrom(OrderCondition.SELECT_FROM_CUSTOM_BATCH_TAGGING);

        final ArkCommonResult orderListResult = newOrderService.getOrderList(condition);
        if (!orderListResult.statusOK()) {
            return orderListResult;
        }

        final QueryResult<AOrder> queryResult = (QueryResult<AOrder>) orderListResult.getData();
        final int queryResultCount = queryResult.getCount();
        if (queryResultCount <= 0) {
            return ArkCommonResult.fail("orderList is empty.");
        }

        WxUserTag wxUserTag = null;
        try {
            wxUserTag = getWxUserTag(wxTagName);
        } catch (WxErrorException e) {
           LOGGER.info("customTag() getWxUserTag error", e);
        }

        if (wxUserTag == null) {
            try {
                wxUserTag = createUserTag(wxTagName);
            } catch (WxErrorException e) {
                LOGGER.info("createUserTag() error", e);
                return ArkCommonResult.fail("createUserTag error.");
            }
        }

        if (wxUserTag == null) {
            return ArkCommonResult.fail("wxUserTag info error.");
        }

        final List<AOrder> orderList = queryResult.getList();
        List<String> validOpenIdList = getValidOpenIdList(orderList);
        LOGGER.info("customTag(), validOpenIdList : {}", StringUtils.join(validOpenIdList, ","));
        if (CollectionUtils.isEmpty(validOpenIdList)) {
            return ArkCommonResult.fail("validOpenIdList is empty.");
        }

        wechatTagUserService.batchTaggingAll(wxUserTag, validOpenIdList);

        return ArkCommonResult.ok();
    }

    private WxUserTag createUserTag(String tag) throws WxErrorException {
        final WxMpUserTagService userTagService = wechatMpService.getUserTagService();
        return userTagService.tagCreate(tag);
    }

    @RequestMapping(value = "/batchtagging", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public ArkCommonResult batchTagUser(@RequestBody TagUserEntity tagUserEntity) {
        LOGGER.info("batchTagUser(), tagUserEntity : {}", tagUserEntity);
        final List<String> datas = tagUserEntity.getDatas();
        if (CollectionUtils.isEmpty(datas)) {
            return ArkCommonResult.fail("datas is empty. please check.");
        }

        WxUserTag wxUserTag = null;
        try {
            wxUserTag = getWxUserTag(tagUserEntity.getTagName());
        } catch (WxErrorException e) {
            LOGGER.info("getWxUserTag error", e);
        }
        if (wxUserTag == null) {
            return ArkCommonResult.fail("can not find vaild tag info, tagName : " + tagUserEntity.tagName);
        }

        List<AOrder> orderList = new ArrayList<>();
        final int type = tagUserEntity.getType();
        if (type == TagUserEntity.TYPE_MOBILE) {
            orderList = newOrderService.getOrderListByMobile(datas);
        } else {
            orderList = newOrderService.getOrderListByTids(datas);
        }
        if (CollectionUtils.isEmpty(orderList)) {
            return ArkCommonResult.fail("can not find order list by datas.");
        }

        List<String> validOpenIdList = getValidOpenIdList(orderList);
        LOGGER.info("batchTagUser(), validOpenIdList : {}", StringUtils.join(validOpenIdList, ","));
        if (CollectionUtils.isEmpty(validOpenIdList)) {
            return ArkCommonResult.fail("validOpenIdList is empty.");
        }

        wechatTagUserService.batchTaggingAll(wxUserTag, validOpenIdList);

        return ArkCommonResult.ok();
    }

    private List<String> getValidOpenIdList(List<AOrder> orderListByTids) {
        final List<String> orderOpenIdList = toOpenIdList(orderListByTids);
        List<String> allUserList = new ArrayList<>();
        try {
            allUserList = wechatMpUserService.getAllUserList();
        } catch (WxErrorException e) {
            LOGGER.info("getAllUserList error", e);
        }

        return (List<String>) CollectionUtils.intersection(orderOpenIdList, allUserList);
    }

    private List<String> toOpenIdList(List<AOrder> orderList) {
        List<String> result = new ArrayList<>();
        for (AOrder order : orderList) {
            final String userId = order.getUserId();
            if (!StringUtils.isEmpty(userId)) {
                result.add(userId);
            }
        }

        return result;
    }


    private WxUserTag getWxUserTag(String tagName) throws WxErrorException {
        if (StringUtils.isEmpty(tagName)) {
            return null;
        }

        final WxMpUserTagService userTagService = wechatMpService.getUserTagService();
        final List<WxUserTag> wxUserTags = userTagService.tagGet();

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (WxUserTag userTag : wxUserTags) {
            sb.append("{" + userTag.getId() + " : " + userTag.getName() + "}");
            sb.append(",");
        }
        sb.append("]");
        LOGGER.info("getWxUserTag() ,wxUserTags : " + sb.toString());
        for (WxUserTag wxUserTag : wxUserTags) {
            if (StringUtils.equalsIgnoreCase(wxUserTag.getName(), tagName)) {
                return wxUserTag;
            }
        }

        return null;
    }


    public static class TagUserEntity {
        public static final int TYPE_TID = 1;
        public static final int TYPE_MOBILE = 2;

        private int type = TYPE_TID;
        private String tagName;
        private List<String> datas = new ArrayList<>();

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }

        public List<String> getDatas() {
            return datas;
        }

        public void setDatas(List<String> datas) {
            this.datas = datas;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }


    }

}
