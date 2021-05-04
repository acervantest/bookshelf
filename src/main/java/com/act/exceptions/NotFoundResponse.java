package com.act.exceptions;

public class NotFoundResponse extends RuntimeException {

    public NotFoundResponse(String message) {
        super(message);
    }
}
