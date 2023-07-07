package com.example.searchbook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import com.example.searchbook.entity.Book;
public interface BookRepository extends JpaRepository<Book, Long>, QuerydslPredicateExecutor<Book> {


}