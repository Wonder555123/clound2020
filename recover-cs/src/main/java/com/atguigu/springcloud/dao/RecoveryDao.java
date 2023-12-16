package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.FileGroup;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecoveryDao {
    public Page<FileGroup> selectByCondition(String queryString);
    public void deleteById(Integer id);
    public void add(FileGroup fileGroup);
}
