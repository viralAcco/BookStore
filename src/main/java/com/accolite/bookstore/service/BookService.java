package com.accolite.bookstore.service;

import com.accolite.bookstore.model.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    Book updateBook(Book book);
    List<Book> getBook();
    Book getBookById(int bookID);
    void deleteBook(int bookID);
}
