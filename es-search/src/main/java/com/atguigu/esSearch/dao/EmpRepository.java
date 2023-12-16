package com.atguigu.esSearch.dao;
import com.atguigu.esSearch.index.Emp;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EmpRepository extends ElasticsearchRepository<Emp,String> {

    List<Emp> findByName(String name);

    List<Emp> findByContent(String content);

}
