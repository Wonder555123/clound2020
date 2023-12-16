package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Result;
import com.atguigu.springcloud.entities.User;
import com.atguigu.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public Result findByNameAndPassword(@RequestBody User user) {
        try{
            String password = user.getPassword();
            if(user==null||user.getUsername()==null||password==null) {
                return new Result(false,"密码或账号为空");
            }
            User user2= userService.findPasswordByName(user.getUsername());
            if(user2==null){
                return new Result(false,"密码或账号错误");
            }else{
                String password2 = user2.getPassword();
                if(password.equals(password2)){
                    return new Result(true,"登录成功");
                }else{
                    return new Result(false,"密码或账号错误");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"密码或账号错误");
        }
    }

}
