package com.efruit.micro.arkgift.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class EnvironmentRemind {
	
	@Profile("dev")
	@Bean
	public CurrEnvironment devRemind() {
		System.out.println("开发环境启动。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
		return new CurrEnvironment();
	}

	@Profile("prod")
	@Bean
	public CurrEnvironment prodRemind() {
		System.out.println("正式环境启动。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
		return new CurrEnvironment();
	}
	
	class CurrEnvironment {
		
	}
}
