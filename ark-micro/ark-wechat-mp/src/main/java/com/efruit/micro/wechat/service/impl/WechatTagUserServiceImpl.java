package com.efruit.micro.wechat.service.impl;

import com.efruit.micro.wechat.service.WechatMpService;
import com.efruit.micro.wechat.service.WechatTagUserService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpUserTagService;
import me.chanjar.weixin.mp.bean.tag.WxTagListUser;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WechatTagUserServiceImpl implements WechatTagUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatTagUserServiceImpl.class);

    // batchTagging接口 每次传入的openid列表个数不能超过50个
    private static final int MAX_BATCH_TAGGING_SIZE = 50;

    @Autowired
    WechatMpService wechatMpService;

    @Async
    @Override
    public void batchTaggingAll(WxUserTag wxUserTag, List<String> validOpenIdList) {
        final int totalCount = validOpenIdList.size();
        int requestTimes = totalCount / MAX_BATCH_TAGGING_SIZE;
        int sucTimes = 0;
        LOGGER.info("batchTaggingAll start, requestTimes : {}", requestTimes);
        for (int i = 0; i <= requestTimes; i++) {
            int fromIndex = i * MAX_BATCH_TAGGING_SIZE;
            int toIndex = Math.min(totalCount, (i + 1) * MAX_BATCH_TAGGING_SIZE);

            List<String> subList = validOpenIdList.subList(fromIndex, toIndex);
            boolean batchTaggingByPage = batchTaggingByPage(wxUserTag, subList);
            if (batchTaggingByPage) {
                sucTimes++;
            }
            LOGGER.info("batchTaggingAll for, requestTimes : {}, cur : {}, totalSucCount : {}", requestTimes, i, sucTimes);
            if (toIndex == totalCount) {
                break;
            }
        }

        LOGGER.info("batchTaggingAll finish , requestTimes : {} , sucTimes : {}", requestTimes, sucTimes);
    }

    @Override
    public List<String> getTagUserList(WxUserTag wxUserTag) {
        List<String> result = new ArrayList<>();
        if (wxUserTag == null) {
            return result;
        }
        final WxMpUserTagService userTagService = wechatMpService.getUserTagService();

        try {
            WxTagListUser wxTagListUser = userTagService.tagListUser(wxUserTag.getId(), null);
            if (wxTagListUser.getCount() > 0) {
                final List<String> openidList = wxTagListUser.getData().getOpenidList();
                result.addAll(openidList);
            }
        } catch (WxErrorException e) {
           LOGGER.info("getTagUserList error.", e);
        }
        return result;
    }

    private boolean batchTaggingByPage(WxUserTag wxUserTag, List<String> tempOpenIds) {
        final WxMpUserTagService userTagService = wechatMpService.getUserTagService();
        boolean batchTagging = false;
        final String[] openids = tempOpenIds.toArray(new String[tempOpenIds.size()]);
        try {
            batchTagging = userTagService.batchTagging(wxUserTag.getId(), openids);
        } catch (WxErrorException e) {
            LOGGER.info("batchTaggingByPage error. ", e);
        }

        final List<String> errorList = new ArrayList<>();
        // 批量打标签失败后，只能一个个来
        if (!batchTagging) {
            for (String openid : openids) {
                try {
                    userTagService.batchTagging(wxUserTag.getId(), new String[]{openid});
                } catch (WxErrorException e) {
                    LOGGER.info("batchTagging one error. id : {}", openids, e);
                    errorList.add(openid);
                }
            }
        }

        LOGGER.info("errorList : {}", StringUtils.join(errorList, ","));

        return batchTagging;
    }
}
