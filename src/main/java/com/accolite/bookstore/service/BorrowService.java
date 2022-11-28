package com.accolite.bookstore.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface BorrowService {
    ResponseEntity<HttpStatus> borrowBook(int userId, int bookId);
    ResponseEntity<HttpStatus> reviewBook(int uId, int bookId, String review);
    ResponseEntity<HttpStatus> returnBook(int rentedId);
    ResponseEntity<HttpStatus> likeBook(int uId, int bookId);
}
