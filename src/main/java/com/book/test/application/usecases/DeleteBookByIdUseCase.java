package com.book.test.application.usecases;

import org.springframework.stereotype.Service;

import com.book.test.infrastructure.BookRepository;

@Service
public final class DeleteBookByIdUseCase {
    
    private final BookRepository bookRepository;

    public DeleteBookByIdUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute(Integer id) {
        var result = this.bookRepository.findById(id);
    
        
        if (!result.isPresent()) {
            // validation error
        }

        this.bookRepository.deleteById(id);
    }
}
