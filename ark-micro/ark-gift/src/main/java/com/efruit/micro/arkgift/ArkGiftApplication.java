package com.efruit.micro.arkgift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.efruit.micro")
@EnableScheduling
public class ArkGiftApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(ArkGiftApplication.class, args);
    }
    
}
