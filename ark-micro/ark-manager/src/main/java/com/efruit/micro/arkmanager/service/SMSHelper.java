package com.efruit.micro.arkmanager.service;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class SMSHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(SMSHelper.class);

    //产品名称:云通信短信API产品,开发者无需替换
    private static final String PRODUCT = "Dysmsapi";
    //产品域名,开发者无需替换
    private static final String DOMAIN = "dysmsapi.aliyuncs.com";

    private static final String DEFAULT_REGIONID = "cn-hangzhou";

    private static final String SIGN_NAME = "多吃水果";
    // 模板内容为 "{\"addr\":\"金隅嘉华大厦\", \"deliver\":\"13631237676\", \"num\":\"1\"}"
    private static final String TEMPLATE_CODE = "SMS_151660232";
    private static final String TEMPLATE_KEY_ADDR = "addr";
    private static final String TEMPLATE_KEY_INFO = "info";
    private static final String TEMPLATE_KEY_DELIVER = "deliver";
    private static final String TEMPLATE_KEY_NUM = "num";

    private static final int MAX_PARAMS_LENGTH = 10;

    @Value("${aliyun.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.accessKeySecret}")
    private String accessKeySecret;

    private volatile IAcsClient acsClient;

    @PostConstruct
    public void init() {
        LOGGER.info("init start...");
        try {
            final String regionId = DEFAULT_REGIONID;
            IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
            DefaultProfile.addEndpoint(regionId, regionId, PRODUCT, DOMAIN);
            acsClient = new DefaultAcsClient(profile);
        } catch (ClientException e) {
            LOGGER.info("init error.", e);
        }
    }

    public SendSmsResponse send(SendSmsRequest sendSmsRequest) throws ClientException {
        if (acsClient == null) {
            init();
        }

        return acsClient.getAcsResponse(sendSmsRequest);
    }

    public SendSmsResponse sendDefaultSMS(String number, String addr, String info, String deliver, String fetchCode) throws ClientException {
        final SendSmsRequest sendSmsRequest = buildDefaultRequest(number, addr, info, deliver, fetchCode);
        if (sendSmsRequest == null) {
            return null;
        }
        return send(sendSmsRequest);
    }

    /**
     * @param number  目标手机号码
     * @param addr    短信模板 addr, 即配送点
     * @param deliver 短信模板 deliver, 即配送人名
     * @return
     */
    private SendSmsRequest buildDefaultRequest(String number, String addr, String info, String deliver, String fetchCode) {
        if (StringUtils.isEmpty(number)) {
            return null;
        }
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(number);
        request.setSignName(SIGN_NAME);
        request.setTemplateCode(TEMPLATE_CODE);

        final Map<String, String> params = new HashMap<>();
        params.put(TEMPLATE_KEY_ADDR, fixParamsLength(addr));
        params.put(TEMPLATE_KEY_INFO, fixParamsLength(info));
        params.put(TEMPLATE_KEY_DELIVER, deliver);
        params.put(TEMPLATE_KEY_NUM, fetchCode);
        final String jsonString = JSON.toJSONString(params);
        request.setTemplateParam(jsonString);
        return request;
    }


    private String fixParamsLength(String param) {
        if (StringUtils.isEmpty(param)) {
            return "";
        }

        final int length = param.length();
        if (length > MAX_PARAMS_LENGTH) {
            return param.substring(0, MAX_PARAMS_LENGTH);
        }
        return param;
    }

}
