package com.efruit.micro.arkmanager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvConfig {

    @Value("${env.config.isDev}")
    public boolean isDev;
}
