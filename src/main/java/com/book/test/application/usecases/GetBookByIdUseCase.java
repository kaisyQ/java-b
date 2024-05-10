package com.book.test.application.usecases;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.book.test.domain.entities.Book;
import com.book.test.infrastructure.BookRepository;

@Service
public final class GetBookByIdUseCase {
    

    private final BookRepository bookRepository;


    public GetBookByIdUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> execute(Integer id) {

        return this.bookRepository.findById(id);
    }
    
}
