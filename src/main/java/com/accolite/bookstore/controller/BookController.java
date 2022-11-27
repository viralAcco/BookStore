package com.accolite.bookstore.controller;

import com.accolite.bookstore.model.Book;
import com.accolite.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    private ResponseEntity<List<Book>> displayBook(){
        return ResponseEntity.ok().body(this.bookService.getBook());
    }

    @GetMapping("/books/{bookId}")
    private ResponseEntity<Book> displayUser(@PathVariable int bookId){
        return ResponseEntity.ok().body(this.bookService.getBookById(bookId));
    }

    @PostMapping("/addBook")
    private ResponseEntity<Book> setUser(@RequestBody Book book){
        return ResponseEntity.ok().body(this.bookService.addBook(book));
    }

    @PutMapping("/updateBook/{bookId}")
    private ResponseEntity<Book> updateUser(@PathVariable int bookId,@RequestBody Book book){
        book.setBookId(bookId);
        return ResponseEntity.ok().body(this.bookService.updateBook(book));
    }

    @DeleteMapping("/removeBook/{bookId}")
    private HttpStatus deleteBook(@PathVariable int bookId){
        this.bookService.deleteBook(bookId);
        return HttpStatus.OK;
    }
}
