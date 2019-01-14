package com.asq.cloud.eurekaservercolony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerColonyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerColonyApplication.class, args);
	}

}

