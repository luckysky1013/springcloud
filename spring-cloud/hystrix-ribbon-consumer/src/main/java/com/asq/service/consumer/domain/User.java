package com.asq.service.consumer.domain;

import java.math.BigDecimal;

/**
 * @author liuj
 * @version 1.0
 * @date 2019/1/2 14:43
 * @description TODO
 **/
public class User {

    private Long id;

    private String username;

    private String name;

    private int age;

    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
