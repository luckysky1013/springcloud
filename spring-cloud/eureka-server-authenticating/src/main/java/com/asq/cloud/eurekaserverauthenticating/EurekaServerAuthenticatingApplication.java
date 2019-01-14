package com.asq.cloud.eurekaserverauthenticating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerAuthenticatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerAuthenticatingApplication.class, args);
	}

}

