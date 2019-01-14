package com.asq.service.consumer.feign;

import com.asq.service.consumer.domain.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
@FeignClient(name="service-provider",fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {

    /**
     * /user/{id} 为指定客户端的请求路径
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}

@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{

    private static final Logger logger= LoggerFactory.getLogger(FeignClientFallbackFactory.class);
    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                logger.info("fallback; reason was ",throwable.getMessage());
                User user=new User();
                user.setId((-1L));
                user.setName("默认用户");
                return user;
            }
        };
    }
}