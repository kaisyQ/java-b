package com.book.test.presentation;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.test.application.models.BookModel;
import com.book.test.application.usecases.CreateBookUseCase;
import com.book.test.application.usecases.DeleteBookByIdUseCase;
import com.book.test.application.usecases.GetBookByIdUseCase;
import com.book.test.application.usecases.GetBooksUseCase;
import com.book.test.application.usecases.UpdateBookUseCase;
import com.book.test.domain.entities.Book;
import com.book.test.presentation.requests.CreateBookDto;
import com.book.test.presentation.requests.UpdateBookDto;
import com.book.test.presentation.responses.ResponseEntityBuilder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("v1/books")
public final class BookController {

    private final GetBooksUseCase getBooksUseCase;

    private final GetBookByIdUseCase getBookByIdUseCase;

    private final CreateBookUseCase createBookUseCase;

    private final DeleteBookByIdUseCase deleteBookByIdUseCase;

    private final UpdateBookUseCase updateBookUseCase;

    public BookController(
        GetBooksUseCase getBooksUseCase,
        GetBookByIdUseCase getBookByIdUseCase,
        CreateBookUseCase createBookUseCase,
        DeleteBookByIdUseCase deleteBookByIdUseCase,
        UpdateBookUseCase updateBookUseCase
    ) {
        this.getBookByIdUseCase = getBookByIdUseCase;
        this.getBooksUseCase = getBooksUseCase;
        this.createBookUseCase = createBookUseCase;
        this.deleteBookByIdUseCase = deleteBookByIdUseCase;
        this.updateBookUseCase = updateBookUseCase;
    }


    @GetMapping("")
    public ResponseEntity<List<Book>> getBooks() {
        var result = this.getBooksUseCase.execute();
        
        return ResponseEntityBuilder.build(HttpStatus.OK, result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BookModel>> getBook (@PathVariable Integer id) {

        var result = this.getBookByIdUseCase.execute(id);

        return ResponseEntityBuilder.build(HttpStatus.OK, result);
    }
    
    @PostMapping("")
    public ResponseEntity<Void> create(@RequestBody CreateBookDto data) {
        this.createBookUseCase.execute(data);

        return ResponseEntityBuilder.build(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.deleteBookByIdUseCase.execute(id);

        return ResponseEntityBuilder.build(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody UpdateBookDto data) {
        this.updateBookUseCase.execute(id, data);
        
        return ResponseEntityBuilder.build(HttpStatus.OK);
    }
    

}
