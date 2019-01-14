package com.asq.service.consumer.controller;

import com.asq.service.consumer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RestTemplate restTemplate;

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
}
