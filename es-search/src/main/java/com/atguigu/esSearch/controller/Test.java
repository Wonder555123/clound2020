package com.atguigu.esSearch.controller;

import com.atguigu.esSearch.dao.EmpRepository;
import com.atguigu.esSearch.index.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/test")
public class Test {

    @Autowired
    private EmpRepository empRepository;

    @PostMapping("/test1")
    public void test1(){

        Emp emp = new Emp();
        emp.setId("123456");
        emp.setAge(19);
        emp.setAddress("shanghai");
        emp.setContent("nihao");
        emp.setName("高启强+1");
        emp.setBir(new Date());
        empRepository.save(emp);
        Emp build = Emp.builder().id("12323").bir(new Date()).name("高启兰").age(19)
                .content("EAT FISH").address("京海").build();
        empRepository.save(build);

    }

    @GetMapping("/test2")
    public Emp test2(){

        Optional<Emp> byId = empRepository.findById("123456");
        return byId.get();

    }

    @GetMapping("/test3")
    public List<Emp> test3(){

        Iterable<Emp> all = empRepository.findAll();
        List<Emp> list = new ArrayList<>();
        all.forEach(x->{
            list.add(x);
        });
        return list;

    }

    @PutMapping("/test4")
    public void test4(){

        Emp build = Emp.builder().id("12323").bir(new Date()).name("高启兰").age(19)
                .content("EAT FISH").build();

    }

    @GetMapping("/test5")
    public void test5(){

        Emp build = Emp.builder().id("123230").bir(new Date()).name("高启兰").age(19)
                .content("老莫要吃鱼了").build();
        empRepository.save(build);

    }

    @GetMapping("/test6/{name}")
    public List<Emp> test6(@PathVariable String name){

        return  empRepository.findByName(name);

    }

    @GetMapping("/test7/{content}")
    public List<Emp> test7(@PathVariable String content){

        return  empRepository.findByContent(content);

    }

}
