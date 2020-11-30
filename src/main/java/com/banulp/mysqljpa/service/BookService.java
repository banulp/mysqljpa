package com.banulp.mysqljpa.service;

import com.banulp.mysqljpa.model.Book;
import com.banulp.mysqljpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Page<Book> getBooks(){
        return bookRepository.findAll(PageRequest.of(2, 15, Sort.by("id")));
    }

}
