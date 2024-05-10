package com.book.test.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.test.domain.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {   
}