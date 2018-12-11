package com.efruit.micro.arkmanager.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;

public class StatUrlParser {
    private static final Logger LOOGER = LoggerFactory.getLogger(StatUrlParser.class);
    private static final String BASE_URL = "http://gift-web.efruitpro.com/web/statistics?target=";

    private static final String KEY_URL = "url";
    private static final String KEY_FROM = "from";
    private static final String KEY_TYPE = "type";

    public static String parse(String url, String from, String caseType) throws UnsupportedEncodingException {
        if (StringUtils.isEmpty(url)) {
            return "";
        }

        final StringBuilder tmpResult = new StringBuilder();
        final byte[] urlBytes = url.getBytes("utf-8");
        tmpResult.append(KEY_URL + "=" + Base64Utils.encodeToUrlSafeString(urlBytes));
        tmpResult.append("&");

        tmpResult.append(KEY_FROM + "=" + from);
        tmpResult.append("&");

        tmpResult.append(KEY_TYPE + "=" + caseType);
        final String tmpResultStr = tmpResult.toString();
        LOOGER.info("tmpResultStr : {}" , tmpResultStr);
        return BASE_URL + Base64Utils.encodeToUrlSafeString(tmpResultStr.getBytes("utf-8"));
    }
}
