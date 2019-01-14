package com.asq.service.provider.controller;

import com.asq.service.provider.domain.User;
import com.asq.service.provider.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * @author liuj
 * @version 1.0
 * @date 2019/1/2 11:55
 * @description TODO
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User findById(@PathVariable Long id){
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            UserDetails user= (UserDetails) principal;
            Collection<? extends GrantedAuthority> collection=user.getAuthorities();
            for(GrantedAuthority c:collection){
                logger.info("当前用户是{}，角色是{}",user.getUsername(),c.getAuthority());
            }
        }else{

        }
        User user=userRepository.findOneById(id );
        return user;
    }
}
