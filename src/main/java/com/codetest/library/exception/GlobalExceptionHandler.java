package com.codetest.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception){
      ErrorResponse er = new ErrorResponse();
      er.setStatus(404);
      er.setMessage(exception.getMessage());
      er.setError("NOT FOUND");
      er.setTimestamp(LocalDateTime.now());
      return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }
}
