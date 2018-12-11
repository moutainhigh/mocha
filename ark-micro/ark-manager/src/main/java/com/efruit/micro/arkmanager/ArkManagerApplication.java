package com.efruit.micro.arkmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.efruit.micro.arkmanager.mapper")
@ComponentScan("com.efruit.micro")
public class ArkManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArkManagerApplication.class, args);
    }
}
