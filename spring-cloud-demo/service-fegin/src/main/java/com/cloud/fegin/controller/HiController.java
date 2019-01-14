package com.cloud.fegin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.fegin.feignclient.SchedualServiceHi;

/**
 * @author liujian
 * @date 2018/2/28
 */
@RestController
public class HiController {

	@Autowired
	SchedualServiceHi schedualServiceHi;

	@RequestMapping(value = "/hi",method = RequestMethod.GET)
	public String sayHi(@RequestParam String name){
		return schedualServiceHi.sayHiFromClientOne(name);
	}
}
