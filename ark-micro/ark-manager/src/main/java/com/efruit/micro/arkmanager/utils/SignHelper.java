package com.efruit.micro.arkmanager.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class SignHelper {

    public static boolean checkVaild(String signature, String nonce, String timestamp, String secret) {
        if (StringUtils.isAnyBlank(signature, nonce, timestamp)) {
            return false;
        }

        final String tempSign = genSignature(secret, nonce, timestamp);
        return StringUtils.equalsIgnoreCase(tempSign, signature);
    }

    public static String genSignature(String secret, String nonce, String timestamp) {

        String[] tempStrArray = {secret, nonce, timestamp};
        final StringBuilder mark = new StringBuilder();
        Arrays.sort(tempStrArray);
        for (String str : tempStrArray) {
            mark.append(str);
        }
        System.out.println("mark: " + mark);

        return DigestUtils.sha1Hex(mark.toString());
    }
}
