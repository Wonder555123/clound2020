package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.FileGroup;
import com.atguigu.springcloud.entities.PageResult;
import com.atguigu.springcloud.entities.QueryPageBean;

import com.atguigu.springcloud.entities.Result;
import com.atguigu.springcloud.service.RecoveryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/file")
public class RecoveryController {
    @Autowired
    private RecoveryService recoveryService;

//    文件上传，实现预约设置数据批量导入
    @RequestMapping("/upload")
    public Result upload(@RequestParam("excelFile") MultipartFile excelFile){
        try {
            String originalFilename = excelFile.getOriginalFilename();
            File file = new File("D:\\system\\mid\\"+originalFilename);
            excelFile.transferTo(file);
//            python代码嵌入
            String[] argv = new String[] { "D:\\Py_Charm\\cs_recovery\\v\\Scripts\\python.exe",
                    "C:\\Users\\17574\\Desktop\\test\\encryption.py",originalFilename};
            Process pr = Runtime.getRuntime().exec(argv);
            System.out.println("encryption success!");
            return new Result(true,"文件上传成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"文件上传失败！");
        }
    }

//  文件下载
    @RequestMapping("/download")
    public Result download(@RequestParam("name") String name){
        try {
            String originalFilename = name+".wav";
            System.out.println(originalFilename);
//            python代码嵌入
                String[] argv = new String[] { "D:\\Py_Charm\\cs_recovery\\v\\Scripts\\python.exe",
                        "C:\\Users\\17574\\Desktop\\test\\decryption.py",originalFilename};
                Process pr = Runtime.getRuntime().exec(argv);
                System.out.println("decryption success!");
                return new Result(true,"文件下载成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"文件下载失败！");
        }
    }

//    添加数据
    @RequestMapping("/add")
    public Result add(@RequestBody FileGroup fileGroup){
        try {
            recoveryService.add(fileGroup);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"添加失败！");
        }
        return new Result(true,"添加成功！");
    }
//    删除数据
    @RequestMapping("/delete")
    public Result delete(@RequestParam Integer id){
        try {
            recoveryService.deleteById(id);
        }catch (Exception e){
        e.printStackTrace();
        return new Result(false,"删除失败！");
        }
    return new Result(true,"删除成功！");
    }

//    钩子函数，分页查询
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return  recoveryService.pageQuery(queryPageBean);
    }


}
