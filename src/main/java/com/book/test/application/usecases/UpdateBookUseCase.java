package com.book.test.application.usecases;

import org.springframework.stereotype.Service;

import com.book.test.infrastructure.BookRepository;
import com.book.test.presentation.requests.UpdateBookDto;

@Service
public final class UpdateBookUseCase {
    
    private final BookRepository bookRepository;

    public UpdateBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    } 

    public void execute(Integer id, UpdateBookDto data) {
        var result = this.bookRepository.findById(id);
    
        if (!result.isPresent()) {
            //
        }

        var book = result.get();

        book.setTitle(data.getTitle());
    
        this.bookRepository.saveAndFlush(book);
    }
}
