package com.atguigu.springcloud.service;

import com.atguigu.springcloud.dao.RecoveryDao;
import com.atguigu.springcloud.entities.FileGroup;
import com.atguigu.springcloud.entities.PageResult;
import com.atguigu.springcloud.entities.QueryPageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecoveryServiceImp implements RecoveryService{

    @Autowired
    private RecoveryDao recoveryDao;

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage,pageSize);
        Page<FileGroup> page = recoveryDao.selectByCondition(queryString);
        long total = page.getTotal();
        List<FileGroup> result = page.getResult();
        return  new PageResult(total,result);
    }
    @Override
    public void deleteById(Integer id) {
        recoveryDao.deleteById(id);
    }
    @Override
    public void add(FileGroup fileGroup) {
        fileGroup.setSubmitDate(new Date());
        recoveryDao.add(fileGroup);
    }

}
