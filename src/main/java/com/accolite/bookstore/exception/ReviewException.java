package com.accolite.bookstore.exception;

public class ReviewException extends RuntimeException{
    private static final long serviceVersionUID = 1L;

    public ReviewException(String message){
        super(message);
    }

    public ReviewException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
