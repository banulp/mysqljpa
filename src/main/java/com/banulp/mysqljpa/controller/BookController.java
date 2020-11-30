package com.banulp.mysqljpa.controller;

import com.banulp.mysqljpa.model.Book;
import com.banulp.mysqljpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "banulp.lv", produces = "application/json;charset=UTF-8")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/getBooks")
    public Page<Book> getBooks() {
        return bookService.getBooks();
    }

}
