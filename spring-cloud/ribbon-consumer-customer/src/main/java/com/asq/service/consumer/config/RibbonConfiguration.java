package com.asq.service.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuj
 * @version 1.0
 * @date 2019/1/4 17:18
 * @description TODO
 **/
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        //负载均衡规则很多实现
        //负载均衡规则，改为随机
//        return  new RandomRule();
//        简单轮询
//        return new RoundRobinRule();
//        加权响应时间负载均衡
//          return new WeightedResponseTimeRule();
//        区域感知轮询负载均衡
          return new ZoneAvoidanceRule();

    }
}
