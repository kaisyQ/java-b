package com.book.test.application.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.book.test.application.models.BookModel;
import com.book.test.domain.entities.Book;

@Mapper(componentModel = "spring", uses = BookMapper.class)
public interface BookListMapper {
    
    List<BookModel> toModelList(List<Book> books);

    List<Book> toEntityList(List<BookModel> bookModels);
}
