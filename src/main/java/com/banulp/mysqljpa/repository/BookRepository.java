package com.banulp.mysqljpa.repository;

import com.banulp.mysqljpa.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {

}