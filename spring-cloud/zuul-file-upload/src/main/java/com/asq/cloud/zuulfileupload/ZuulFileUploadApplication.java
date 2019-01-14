package com.asq.cloud.zuulfileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZuulFileUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulFileUploadApplication.class, args);
	}

}

