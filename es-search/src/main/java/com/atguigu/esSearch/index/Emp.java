package com.atguigu.esSearch.index;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "ems", type = "emp")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

    @Id //与ES中_id进行映射
    private String id;

    /**
     * @Description: 用在属性上 代表mapping中一个属性 一个字段
     * type:属性 用来指定字段类型 analyzer:指定分词器
     * @Author: xj0927
     * @Date Created in 2020/12/30 14:38
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name;

    @Field(type = FieldType.Integer)
    private Integer age;

    @Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bir;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;

    @Field(type = FieldType.Keyword)
    private String address;
}
