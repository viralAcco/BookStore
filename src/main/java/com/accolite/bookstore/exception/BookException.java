package com.accolite.bookstore.exception;

public class BookException extends RuntimeException{
    private static final long serviceVersionUID = 1L;

    public BookException(String message){
        super(message);
    }

    public BookException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
