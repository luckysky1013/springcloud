package com.cloud.fegin.feignclient;

import org.springframework.stereotype.Component;

/**
 * @author liujian
 * @date 2018/3/1
 */
@Component
public class SchedualServiceHystric implements SchedualServiceHi{
	@Override
	public String sayHiFromClientOne(String name) {
		return "sorry "+name;
	}
}
