package com.atguigu.springcloud.service;

import com.atguigu.springcloud.dao.UserDao;
import com.atguigu.springcloud.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;
    @Override
    public User findPasswordByName(String name) {
        return userDao.findPasswordByName(name);
    }
}
