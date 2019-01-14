package com.asq.service.consumer.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuj
 * @version 1.0
 * @date 2019/1/4 17:21
 * @description TODO
 *
 * 使用RibbonClient ，为特定name的RibbonClient自定义配置
 * 使用RibbonCLient的configuration属性，指定Ribbon的配置类
 **/
@Configuration
@RibbonClient(name="ribbon-consumer-customer",configuration = RibbonConfiguration.class)
public class TestConfiguration {
}
