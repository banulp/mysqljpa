package com.banulp.mysqljpa.repository;

import com.banulp.mysqljpa.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
public interface BookRepository  extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT id, author, story, star, title FROM book as b WHERE author like %:keyword% ",
            countQuery = "SELECT count(*) FROM book as b WHERE author like %:keyword% ",
            nativeQuery = true)
    Page<Book> searchKeyword(@Param(value="keyword") String keyword, Pageable pageable);

}