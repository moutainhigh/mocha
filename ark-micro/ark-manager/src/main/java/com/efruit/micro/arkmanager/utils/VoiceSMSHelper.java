package com.efruit.micro.arkmanager.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.efruit.micro.arkcommon.utils.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class VoiceSMSHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(VoiceSMSHelper.class);

    private static final String HOST = "http://yuyintz.market.alicloudapi.com";
    private static final String API = "/ts/voiceNotifySms";
    private static final String APP_CODE = "5965e88e132b4e0194c30ecde7505fd1";

    private static final String DEFAULT_TPL_ID = "TP18110325";

    private static final Map<String, String> DEFAULT_HEADER = new HashMap<>();

    static {
        DEFAULT_HEADER.put("Authorization", "APPCODE " + APP_CODE);
    }

    public static SendResult sendDefaultVoiceSMS(String mobile, String addr, String deliver) {
        final StringBuilder paramsb = new StringBuilder();
        paramsb.append("addr:").append(addr);
        paramsb.append(",");
        paramsb.append("deliver:").append(deliver);
        return send(mobile, paramsb.toString(), DEFAULT_TPL_ID);
    }

    public static SendResult send(String mobile, String params, String tplId) {
        if (StringUtils.isAnyBlank(mobile, tplId)) {
            LOGGER.info("Send voice sms error. params is null.");
            return new SendResult(false);
        }
        Map<String, String> querys = new HashMap<>();
        querys.put("mobile", mobile);
        querys.put("param", params);
        querys.put("tpl_id", tplId);

        try {
            HttpResponse response = HttpUtils.doPost(HOST, API, DEFAULT_HEADER, querys, new HashMap<>());
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                // 成功例子：
                // {
                //  "return_code": "00000",
                //  "order_id": "TSVN15........824"
                //}
                String resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
                LOGGER.info("resultString : {}", resultString);
                final JSONObject jsonObject = JSON.parseObject(resultString);
                final String returnCode = jsonObject.getString("return_code");
                final String orderId = jsonObject.getString("order_id");
                final boolean isSuccess = StringUtils.equals(returnCode, "00000");
                return new SendResult(isSuccess, returnCode, orderId);
            }
        } catch (Exception e) {
            LOGGER.info("Send voice sms error.", e);
        }

        return new SendResult(false);
    }

    public static class SendResult {
        private boolean isSuccess;
        private String resultCode;
        private String orderId;

        public boolean isSuccess() {
            return isSuccess;
        }

        public void setSuccess(boolean success) {
            isSuccess = success;
        }

        public String getResultCode() {
            return resultCode;
        }

        public void setResultCode(String resultCode) {
            this.resultCode = resultCode;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public SendResult(boolean isSuccess) {
            this.isSuccess = isSuccess;
        }

        public SendResult(boolean isSuccess, String resultCode, String orderId) {
            this.isSuccess = isSuccess;
            this.resultCode = resultCode;
            this.orderId = orderId;
        }
    }


}
