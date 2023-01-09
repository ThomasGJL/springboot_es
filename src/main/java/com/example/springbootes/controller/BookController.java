package com.example.springbootes.controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootes.entity.Book;
import com.example.springbootes.repository.BookMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

    @Autowired
    BookMapper bookMapper;

    @PostMapping("/save")
    public Book save(@RequestBody Book book) {

        log.info("bookname======" + book.getTitle());

        return bookMapper.save(book);
    }

    @GetMapping("/get")
    public Book getBook(@RequestParam Integer id) {

        Optional<Book> book = bookMapper.findById(id);
        log.info(JSON.toJSONString(book));
        return book.get();
    }

}
