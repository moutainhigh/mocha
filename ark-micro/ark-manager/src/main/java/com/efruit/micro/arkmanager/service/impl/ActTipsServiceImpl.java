package com.efruit.micro.arkmanager.service.impl;

import com.efruit.micro.arkmanager.service.ActTipsService;
import com.efruit.micro.arkmanager.utils.FileHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;

@Service
public class ActTipsServiceImpl implements ActTipsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActTipsServiceImpl.class);

    private File image;

    private static final String DEFAULT_TEMP_IMAGE_NAME = "temp_act_tips";

    @Autowired
    private ResourceLoader resourceLoader;

    @PostConstruct
    public void init() {
        try {
            Resource resource = resourceLoader.getResource("classpath:/raw/act_tips.jpeg");
            final InputStream inputStream = resource.getInputStream();
            final String name = UUID.randomUUID().toString() + "_" + DEFAULT_TEMP_IMAGE_NAME;
            image = FileHelper.createTmpFile(inputStream, name, "jpeg");

            LOGGER.info("init() image path : " + image.getAbsolutePath());
        } catch (Exception e) {
            LOGGER.info("init() error.", e);
        }
    }

    @Override
    public File getActTipsPageFile() {
        if (!FileHelper.checkValid(image)) {
            init();
        }
        return image;
    }

}
