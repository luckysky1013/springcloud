package com.asq.service.provider.controller;

import com.asq.service.provider.domain.User;
import com.asq.service.provider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuj
 * @version 1.0
 * @date 2019/1/2 11:55
 * @description TODO
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User findById(@PathVariable Long id){
        User user=userRepository.findOneById(id );
        return user;
    }
}
