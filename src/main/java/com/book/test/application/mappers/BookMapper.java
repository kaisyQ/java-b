package com.book.test.application.mappers;

import org.mapstruct.Mapper;

import com.book.test.application.models.BookModel;
import com.book.test.domain.entities.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
    
    BookModel toModel(Book book);

    Book toEntity(BookModel model);
}
