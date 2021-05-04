package com.act.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(Exception exc){
        ExceptionResponse error = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage());
        HttpHeaders headers =  new HttpHeaders();
        headers.add("Description", "Exception");
        return new ResponseEntity<>(error, headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(NotFoundResponse exc){
        ExceptionResponse error = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage());
        HttpHeaders headers =  new HttpHeaders();
        headers.add("Description", "Not Found Exception");
        return new ResponseEntity<>(error, headers, HttpStatus.NOT_FOUND);
    }
}
