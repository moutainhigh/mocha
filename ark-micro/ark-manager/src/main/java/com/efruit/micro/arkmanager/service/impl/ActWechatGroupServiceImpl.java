package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.service.ActWechatGroupService;
import com.efruit.micro.arkmanager.utils.FileHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ActWechatGroupServiceImpl implements ActWechatGroupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActWechatGroupServiceImpl.class);

    private static final ConcurrentHashMap<String, File> IMAGE_CACHE_MAP = new ConcurrentHashMap<>();

    @Autowired
    private ResourceLoader resourceLoader;

    private static final Map<String, String> IMAGE_PATH_MAP = new HashMap<>();

    private static final String PATH_PREF = "classpath:/raw/";
    private static final String IMAGE_JPG = ".jpg";

    private static final String[] FETCH_KEY_WORDS = {
            "中航",
            "先锋大厦",
            "启迪",
            "开拓",
            "彩虹大厦",
            "得实大厦",
            "搜狐",
            "文思海辉",
            "新浪",
            "方正大厦",
            "爱奇艺",
            "爱立信",
            "瑞斯康达",
            "甲骨文",
            "百度",
            "立思辰",
            "金隅嘉华",
            "八维",
    };

    static {
        for (String keyword : FETCH_KEY_WORDS) {
            IMAGE_PATH_MAP.put(keyword, PATH_PREF + keyword + IMAGE_JPG);
        }
    }

    @Override
    public File getActImage(String fetchName) {
        final File file = IMAGE_CACHE_MAP.get(fetchName);
        final boolean checkValid = FileHelper.checkValid(file);
        if (checkValid) {
            return file;
        }

        File loadActImage = null;
        try {
            final String resourcePath = getResourcePath(fetchName);
            loadActImage = loadActImage(fetchName, resourcePath);
        } catch (IOException e) {
            LOGGER.info("getActImage() error.", e);
            return null;
        }

        if (loadActImage == null) {
            return null;
        }

        IMAGE_CACHE_MAP.put(fetchName, loadActImage);
        return loadActImage;
    }

    private String extractKeyword(String fetchName) {
        for (String keyword : FETCH_KEY_WORDS) {
            if (StringUtils.contains(fetchName, keyword)) {
                return keyword;
            }
        }

        return "";

    }

    private String getResourcePath(String fetchName) {
        final String keyword = extractKeyword(fetchName);
        if (StringUtils.isEmpty(keyword)) {
            return "";
        }

        final String path = IMAGE_PATH_MAP.get(keyword);
        if (StringUtils.isEmpty(path)) {
            return "";
        }

        return path;
    }

    private File loadActImage(String fetchName, String resourcePath) throws IOException {
        if (StringUtils.isEmpty(fetchName) || StringUtils.isEmpty(resourcePath)) {
            return null;
        }
        Resource resource = resourceLoader.getResource(resourcePath);
        final InputStream inputStream = resource.getInputStream();
        final String name = UUID.randomUUID().toString() + "_" + fetchName;
        return FileHelper.createTmpFile(inputStream, name, "jpeg");
    }
}
