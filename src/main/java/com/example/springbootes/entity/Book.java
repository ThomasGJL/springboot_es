package com.example.springbootes.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 *  索引名, 是否创建索引
 * */
@Document(indexName = "book", createIndex = false)
@Data
public class Book implements Serializable {

    @Id
    private String id;

    @Field(type= FieldType.Text)
    private String title;

    @Field(type = FieldType.Keyword)
    private String author;

    @Field(type = FieldType.Keyword)
    private String createDate;

    @Field(type = FieldType.Long)
    private Double price;


    public Book() {
    }
}
