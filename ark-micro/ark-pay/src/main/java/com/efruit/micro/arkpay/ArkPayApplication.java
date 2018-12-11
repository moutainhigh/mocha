package com.efruit.micro.arkpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.efruit.micro")
public class ArkPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArkPayApplication.class, args);
    }
}
