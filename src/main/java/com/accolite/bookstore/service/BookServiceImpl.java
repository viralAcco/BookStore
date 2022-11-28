package com.accolite.bookstore.service;

import com.accolite.bookstore.exception.BookException;
import com.accolite.bookstore.model.Book;
import com.accolite.bookstore.model.BookCopies;
import com.accolite.bookstore.repository.BookCopiesRepository;
import com.accolite.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    public BookRepository bookRepository;

    @Autowired
    public BookCopiesRepository bookCopiesRepository;
    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
    @Override
    public Book updateBook(Book book) {
        Optional<Book> bookObj = this.bookRepository.findById(book.getBookId());
        if(bookObj.isPresent()) {
            Book b = bookObj.get();
            b.setBookId(book.getBookId());
            b.setBookName(book.getBookName());
            b.setBookCategory(book.getBookCategory());
            b.setBookAuthor(book.getBookAuthor());
            b.setBookPrice(book.getBookPrice());
            return this.bookRepository.save(b);
        }else{
            throw new BookException("Book didn't found with ID: "+ book.getBookId());
        }
    }
    @Override
    public List<Book> getBook() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book getBookById(int bookID) {
        Optional<Book> bookObj = this.bookRepository.findById(bookID);
        if(bookObj.isPresent()){
            return bookObj.get();
        }else{
            throw new BookException("Book didn't found with ID: "+ bookID);
        }
    }
    @Override
    public void deleteBook(int bookID) {
        Optional<Book> bookObj = this.bookRepository.findById(bookID);
        if(bookObj.isPresent()){
            this.bookRepository.deleteById(bookID);
        }else{
            throw new BookException("Book didn't found with ID: "+ bookID);
        }
    }
    @Override
    public Book setLike(int bookID) {
        Optional<Book> bookObj = this.bookRepository.findById(bookID);
        if (bookObj.isPresent()) {
            Book b = bookObj.get();
            b.setBookLike(b.getBookLike() + 1);
            return bookRepository.save(b);
        } else {
            return null;
        }
    }

    @Override
    public ResponseEntity<HttpStatus> addCopies(BookCopies bookCopies) {
        Optional<BookCopies> bookCopiesObj = this.bookCopiesRepository.findById(bookCopies.getBookId());
        if(bookCopiesObj.isPresent()){
            BookCopies copiesAdd = bookCopiesObj.get();
            copiesAdd.setBookCopies(bookCopiesObj.get().getBookCopies()+bookCopies.getBookCopies());
            bookCopiesRepository.save(copiesAdd);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            bookCopiesRepository.save(bookCopies);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @Override
    public List<Book> sortedBooksByDate() {
        List<Book> bookItems= bookRepository.findAll();
        bookItems.sort(Comparator.comparing(Book::getBookLogTime));
        return bookItems;
    }

    @Override
    public List<Book> sortedBooksByLikes() {
        List<Book> bookItems= bookRepository.findAll();
        bookItems.sort(Comparator.comparing(Book::getBookLike));
        return bookItems;
    }
}
