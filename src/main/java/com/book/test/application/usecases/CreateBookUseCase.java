package com.book.test.application.usecases;

import org.springframework.stereotype.Service;

import com.book.test.domain.entities.Book;
import com.book.test.infrastructure.BookRepository;
import com.book.test.presentation.requests.CreateBookDto;

@Service
public final class CreateBookUseCase {
    

    private final BookRepository bookRepository;

    public CreateBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute(CreateBookDto data) {

        var book = new Book();
        book.setTitle(data.getTitle());

        this.bookRepository.saveAndFlush(book);
    }
}
