package com.cloud.service.hi.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.service.hi.ServiceHiApplication;

/**
 * @author liujian
 * @date 2018/3/2
 */
@RestController
public class HiController {

	private static final Logger logger = Logger.getLogger(ServiceHiApplication.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/hi")
	public String callHome(){
		logger.log(Level.INFO, "calling trace service-hi  ");
		return restTemplate.getForObject("http://localhost:8989/miya", String.class);
	}
	@RequestMapping("/info")
	public String info(){
		logger.log(Level.INFO, "calling trace service-hi ");

		return "i'm service-hi";

	}
}
