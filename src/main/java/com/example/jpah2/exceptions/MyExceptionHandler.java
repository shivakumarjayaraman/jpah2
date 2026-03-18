package com.example.jpah2.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        //ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 400);
        ErrorResponse errorResponse = new ErrorResponse(
                "We are experiencing an error in our service. Apologies", 400);
        return ResponseEntity.status(400).body(errorResponse);
    }
}
