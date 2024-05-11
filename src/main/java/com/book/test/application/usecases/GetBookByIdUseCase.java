package com.book.test.application.usecases;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.book.test.application.mappers.BookMapper;
import com.book.test.application.models.BookModel;
import com.book.test.infrastructure.BookRepository;

@Service
public final class GetBookByIdUseCase {
    
    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    public GetBookByIdUseCase(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }


    public Optional<BookModel> execute(Integer id) {

        return this.bookRepository.findById(id).map(book -> this.bookMapper.toModel(book));

    }   
}
