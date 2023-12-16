package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.FileGroup;
import com.atguigu.springcloud.entities.PageResult;
import com.atguigu.springcloud.entities.QueryPageBean;

public interface RecoveryService {
    public PageResult pageQuery(QueryPageBean queryPageBean);
    public void deleteById(Integer id);
    public void add(FileGroup fileGroup);
}
