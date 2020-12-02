package com.banulp.mysqljpa.controller;

import com.banulp.mysqljpa.model.Book;
import com.banulp.mysqljpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "banulp.lv", produces = "application/json;charset=UTF-8")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/getBooks")
    public Page<Book> getBooks(@RequestParam(required=false, defaultValue="1")  int page, @RequestParam(required=false, defaultValue="30")  int size ){
        return bookService.getBooks(page-1, size);
    }

    @GetMapping("/getBooksSearchPage")
    public Page<Book> getBooksSearch(@RequestParam(required=false, defaultValue="1")  int page, @RequestParam(required=false, defaultValue="30")  int size,  @RequestParam(required=false, defaultValue="a") String keyword){
        return bookService.getBooksSearchPage(page-1, size, keyword);
    }

    @GetMapping("/getBooksEaPage")
    public Page<Book> getBooksExample(@RequestParam(required=false, defaultValue="1")  int page, @RequestParam(required=false, defaultValue="30")  int size,  @RequestParam(required=false, defaultValue="a") String keyword){
        return bookService.getBooksExamplePage(page-1, size, keyword);
    }

    @GetMapping("/getBooksSearchList")
    public List<Book> getBooksSearchList(@RequestParam(required=false, defaultValue="a") String keyword){
        return bookService.getBooksSearchList(keyword);
    }

}
