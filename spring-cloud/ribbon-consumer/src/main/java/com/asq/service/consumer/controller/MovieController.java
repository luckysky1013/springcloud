package com.asq.service.consumer.controller;

import com.asq.service.consumer.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuj
 * @version 1.0
 * @date 2019/1/2 14:46
 * @description TODO
 **/
@Controller
public class MovieController {

    private static final Logger logger= LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public User findById(@PathVariable Long id){
        User user= null;
        try {
            user = this.restTemplate.getForObject("http://service-provider/user/"+id,User.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return user;
    }

    @GetMapping("log-instance")
    @ResponseBody
    public void logUserInstance(){
        ServiceInstance serviceInstance=this.loadBalancerClient.choose("service-provider");
        logger.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }

}
