package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.User;

public interface UserService {

    public User findPasswordByName(String name);

}
