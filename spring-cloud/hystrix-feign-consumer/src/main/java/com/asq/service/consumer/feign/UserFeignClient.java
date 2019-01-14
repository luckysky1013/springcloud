package com.asq.service.consumer.feign;

import com.asq.service.consumer.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

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
 *  fallback = FeignClientFallback.class   需要手动开启feign的断路器
 **/
@FeignClient(name="service-provider",fallback = FeignClientFallback.class)
public interface UserFeignClient
{

    /**
     * /user/{id} 为指定客户端的请求路径
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

    /**
     * 调用多个url参数的请求路径 例如：localhost:8000/user/user.json?id=1&username
     * feign 调用GET方法有两种方式
     * 1.通过@RequestParam参数的形式
     * 2.通过使用Map来构建
     * @param id
     * @param username
     * @return
     */
    @RequestMapping(value = "/user/user.json",method = RequestMethod.GET)
    public User findByIdAndUsername(@RequestParam("id") Long id,@RequestParam("username")String username);

    @RequestMapping(value = "/user/user.json",method = RequestMethod.GET)
    public User findByIdAndUsername(@RequestParam Map<String ,Object> map);
}

@Component
class FeignClientFallback implements UserFeignClient{

    @Override
    public User findById(Long id) {
        User user =new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

    @Override
    public User findByIdAndUsername(Long id, String username) {
        User user =new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

    @Override
    public User findByIdAndUsername(Map<String, Object> map) {
        User user =new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }
}