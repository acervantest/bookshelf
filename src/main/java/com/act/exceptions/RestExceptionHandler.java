package com.act.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(RuntimeException ex){
        ExceptionResponse error = new ExceptionResponse();

        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        HttpHeaders headers =  new HttpHeaders();
        headers.add("Description", "Bad Request Exception");

        return new ResponseEntity<>(error, headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(NotFoundException exc){
        ExceptionResponse error = new ExceptionResponse();

        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        HttpHeaders headers =  new HttpHeaders();
        headers.add("Description", "Not Found Exception");

        return new ResponseEntity<>(error, headers, HttpStatus.NOT_FOUND);
    }
}
