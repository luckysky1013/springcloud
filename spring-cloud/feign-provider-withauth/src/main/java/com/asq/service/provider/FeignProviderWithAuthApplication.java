package com.asq.service.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 失败案例 ，项目访问后 重复提交用户名密码，并没有请求到方法
 */
@SpringBootApplication
@EnableEurekaClient
public class FeignProviderWithAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignProviderWithAuthApplication.class, args);
	}

}

