package com.efruit.micro.youzan.common;

import org.apache.commons.lang3.StringUtils;

public class TokenUtils {
    public static boolean isVaild(YouzanToken youzanToken) {
        if (youzanToken == null) {
            return false;
        }

        String accessToken = youzanToken.getAccessToken();
        if (StringUtils.isEmpty(accessToken)) {
            return false;
        }

        final int expiresIn = youzanToken.getExpiresIn();// 单位为秒

        long createTime = youzanToken.getCreateTime();

        long time = System.currentTimeMillis() - createTime;
        if (time > expiresIn * 1000) {
            return false;
        }

        return true;

    }
}
