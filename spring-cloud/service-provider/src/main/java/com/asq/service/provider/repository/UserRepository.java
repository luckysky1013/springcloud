package com.asq.service.provider.repository;

import com.asq.service.provider.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author liuj
 * @version 1.0
 * @date 2019/1/2 11:54
 * @description TODO
 **/
public interface UserRepository extends JpaRepository<User,Long>,CrudRepository<User,Long> {

    public User findOneById(Long id);

    @Query(value = "select * from user where id=?1 and username=?2 ",nativeQuery = true)
    public User findOneByIdAndUserName(Long id, String username);
}
