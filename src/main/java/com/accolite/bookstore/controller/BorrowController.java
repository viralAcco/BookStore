package com.accolite.bookstore.controller;

import com.accolite.bookstore.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PutMapping("/users/rentBook/{userId}/{bookId}")
    private ResponseEntity<HttpStatus> borrowBook(@PathVariable int userId, @PathVariable int bookId){
        return borrowService.borrowBook(userId,bookId);
    }

    @PostMapping("/books/review/{userId}/{bookId}")
    private ResponseEntity<HttpStatus> updateUser(@PathVariable int userId,@PathVariable int bookId, @RequestBody String review){
        return borrowService.reviewBook(userId,bookId,review);
    }

    @PutMapping("/books/return/{brId}")
    private ResponseEntity<HttpStatus> returnBook(@PathVariable int brId){
        return borrowService.returnBook(brId);
    }

    @PostMapping("/books/like/{userId}/{bookId}")
    private ResponseEntity<HttpStatus> likeBook(@PathVariable int userId, @PathVariable int bookId){
        return borrowService.likeBook(userId,bookId);
    }

}
