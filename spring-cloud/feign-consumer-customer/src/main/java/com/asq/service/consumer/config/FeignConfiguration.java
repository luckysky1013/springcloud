package com.asq.service.consumer.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuj
 * @version 1.0
 * @date 2019/1/7 14:10
 * @description TODO
 * 该类为Feign的配置类
 * FeignCOnfiguration类不能包含在主应用程序上下文的@ComponentScan 中，否则该类中的配置信息就会被所有的FeignClient共享
 * 因此想要自定义某个Feign客户端的配置，必须防止@Configuration注解的类所在一的包与@ComponentScan扫描的包重叠，
 * 或应显示指定@ComponentScan不扫描@Configuration类所在的包
 **/
@Configuration
public class FeignConfiguration {

    /**
     * 将契约改为feign原生的默认契约，这样可以使用feign自带的注解
     * @return
     */
    @Bean
    public Contract feignContract(){
        return new Contract.Default();
    }
}
