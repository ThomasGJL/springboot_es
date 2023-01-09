package com.example.springbootes;

import com.example.springbootes.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.document.Document;

@SpringBootTest
@Slf4j
class SpringbootEsApplicationTests {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void testIndex(){

        IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(Book.class);

        indexOperations.create();
        Document mapping = indexOperations.createMapping(Book.class);
        indexOperations.putMapping(mapping);

        boolean exsits = indexOperations.exists();
        //indexOperations.delete();

        log.info("index exsit======" + exsits);


    }

}
