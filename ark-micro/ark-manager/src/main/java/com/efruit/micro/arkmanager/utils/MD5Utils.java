package com.efruit.micro.arkmanager.utils;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import java.io.File;

public class MD5Utils {

    private static Logger logger = LoggerFactory.getLogger(MD5Utils.class);

    public static String md5(File file) {
        try {
            final byte[] bytes = FileUtils.readFileToByteArray(file);
            return DigestUtils.md5DigestAsHex(bytes);
        } catch (Exception e) {
            logger.info("md5(file) error, e : ", e);
        }

        return null;
    }
}
