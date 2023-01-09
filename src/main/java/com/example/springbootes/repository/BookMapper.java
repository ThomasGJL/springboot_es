package com.example.springbootes.repository;

import com.example.springbootes.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper extends ElasticsearchRepository<Book, Integer> {

}
