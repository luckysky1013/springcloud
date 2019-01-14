package com.asq.service.consumer.controller;

import com.asq.service.consumer.domain.User;
import com.asq.service.consumer.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author liuj
 * @version 1.0
 * @date 2019/1/2 14:46
 * @description TODO
 **/
@Controller
public class MovieController {

    @Autowired
    private UserFeignClient feignClient;

    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public User findById(@PathVariable Long id){
        return this.feignClient.findById(id);
    }

    @GetMapping(value = "/user")
    @ResponseBody
    public User findByIdAndName(@RequestParam Long id,@RequestParam String username){
        return this.feignClient.findByIdAndUsername(id,username);
    }

    @GetMapping(value = "/user/map")
    @ResponseBody
    public User findByIdAndName1(@RequestParam Long id,@RequestParam String username){
        HashMap<String ,Object> map =new HashMap<>();
        map.put("id",id);
        map.put("username",username);
        return this.feignClient.findByIdAndUsername(map);
    }
}
