package com.accolite.bookstore.service;

import com.accolite.bookstore.model.Book;
import com.accolite.bookstore.model.BookCopies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    Book updateBook(Book book);
    List<Book> getBook();
    Book getBookById(int bookID);
    void deleteBook(int bookID);
    Book setLike(int bookID);
    ResponseEntity<HttpStatus> addCopies(BookCopies bc);
}
