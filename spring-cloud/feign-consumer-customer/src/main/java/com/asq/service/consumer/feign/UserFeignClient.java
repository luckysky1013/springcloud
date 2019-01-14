package com.asq.service.consumer.feign;

import com.asq.service.consumer.config.FeignConfiguration;
import com.asq.service.consumer.domain.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author liuj
 * @version 1.0
 * @date 2019/1/7 11:52
 * @description TODO
 * @FeignClient(name="service-provider")  注解中的servier-provider 是一个任意的客户端名称
 * 用于创建ribbon 负载均衡器 。由于使用了Eureka ，所以Ribbon 会把service-provider解析成Eureka Server 服务注册表中的服务。
 * 还可以使用url指定请求的url（url 可以是完整的url或者主机名 ）
 * @FeignClient(name="service-provider",url = "localhost:8001")
 * PS:当使用Eureka 服务注册中心时，需注意注解中的名称一定要对应服务注册中心客户端的名称。
 *
 **/
@FeignClient(name="service-provider",configuration = FeignConfiguration.class)
public interface UserFeignClient
{

    /**
     * 使用feign自带的注解@RequestLine
     * @param id
     * @return
     */
    @RequestLine("GET /user/{id}")
    public User findById(@Param("id") Long id);
}
