package com.banulp.mysqljpa.repository;

import com.banulp.mysqljpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookSearchRepository extends JpaRepository<Book, Integer> {

//    @Query(value = "SELECT b.id, b.author, b.story, b.star, b.title FROM book b WHERE b.author = :keyword ", nativeQuery = true)
    @Query(value = "SELECT b.id, b.author, b.story, b.star, b.title FROM book b WHERE b.author like %:keyword% ", nativeQuery = true)
    List<Book> searchKeyword(@Param(value="keyword") String keyword);

}