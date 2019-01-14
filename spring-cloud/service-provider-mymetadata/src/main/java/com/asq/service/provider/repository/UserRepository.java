package com.asq.service.provider.repository;

import com.asq.service.provider.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author liuj
 * @version 1.0
 * @date 2019/1/2 11:54
 * @description TODO
 **/
public interface UserRepository extends JpaRepository<User,Long>,CrudRepository<User,Long> {

    public User findOneById(Long id);
}
