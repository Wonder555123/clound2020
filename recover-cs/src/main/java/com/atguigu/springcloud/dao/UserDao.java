package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    public User findPasswordByName(String name);

}
