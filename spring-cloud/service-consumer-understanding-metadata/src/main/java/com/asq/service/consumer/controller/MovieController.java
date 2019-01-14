package com.asq.service.consumer.controller;

import com.asq.service.consumer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author liuj
 * @version 1.0
 * @date 2019/1/2 14:46
 * @description TODO
 **/
@Controller
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public User findById(@PathVariable Long id){
        User user= null;
        try {
            user = this.restTemplate.getForObject("http://localhost:8000/user/"+id,User.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return user;
    }

    @GetMapping(value = "user-instance")
    @ResponseBody
    public List<ServiceInstance> showInfo(){
        return this.discoveryClient.getInstances("service-provider");
    }
}
