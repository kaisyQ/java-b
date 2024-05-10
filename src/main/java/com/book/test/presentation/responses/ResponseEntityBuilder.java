package com.book.test.presentation.responses;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;


public final class ResponseEntityBuilder {

    public static <T> ResponseEntity<T> build(HttpStatusCode status, @Nullable T data) {
        
        return new ResponseEntity<T>(data, status);
    }

    public static ResponseEntity<Void> build(HttpStatusCode status) {
        
        return new ResponseEntity<>(status);
    }
}
