package com.banulp.mysqljpa.service;

import com.banulp.mysqljpa.model.Book;
import com.banulp.mysqljpa.repository.BookRepository;
import com.banulp.mysqljpa.repository.BookSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookSearchRepository bookSearchRepository;

    public Page<Book> getBooks(int page, int size){
        return bookRepository.findAll(PageRequest.of(page, size, Sort.by("id")));
    }

    public Page<Book> getBooksSearchPage(int page, int size, String keyword){
        return bookRepository.searchKeyword(keyword, PageRequest.of(page, size, Sort.by("id")));
    }

    public Page<Book> getBooksExamplePage(int page, int size, String keyword){
        ExampleMatcher em = ExampleMatcher.matchingAny()
                .withMatcher("author", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Book b = new Book();
        b.setAuthor(keyword);
        Example<Book> example = Example.of(b, em);
        return bookRepository.findAll(example, PageRequest.of(page, size, Sort.by("id")));
    }

    public List<Book> getBooksSearchList(String keyword){
        return bookSearchRepository.searchKeyword(keyword);
    }

}
