package com.book.test.application.usecases;

import java.util.List;

import org.springframework.stereotype.Service;

import com.book.test.domain.entities.Book;
import com.book.test.infrastructure.BookRepository;


@Service
public final class GetBooksUseCase {
    
    private final BookRepository bookRepository;

    public GetBooksUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> execute() {
        return this.bookRepository.findAll();
    }
}
