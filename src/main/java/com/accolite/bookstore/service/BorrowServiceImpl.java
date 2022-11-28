package com.accolite.bookstore.service;

import com.accolite.bookstore.model.*;
import com.accolite.bookstore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService{

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCopiesRepository bookCopiesRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RentRepository rentRepository;

    @Override
    public ResponseEntity<HttpStatus> borrowBook(int userId, int bookId) {

        Optional<User> userObj = userRepository.findById(userId);
        Optional<Book> bookObj = bookRepository.findById(bookId);
        Optional<BookCopies> bookCopiesObj = bookCopiesRepository.findById(bookId);

        User user =userObj.get();
        Book book =bookObj.get();
        BookCopies bookCopies=bookCopiesObj.get();

        BookRent br = new BookRent();

        if(userObj.isPresent() && bookObj.isPresent()){
            double neededBal = 0.3*(double)(book.getBookPrice());
            if(neededBal>user.getUserWallet()){

            }
            if(bookCopies.getBookCopies() > 0 && user.isUserStatus() && neededBal<user.getUserWallet() && user.getRentedBooks()<3){
                bookCopies.setBookCopies(bookCopies.getBookCopies()-1);
                user.setUserWallet(user.getUserWallet()-(0.2*(double)(book.getBookPrice())));
                user.setRentedBooks(user.getRentedBooks()+1);

                br.setUserId(user.getUserId());
                br.setBookId(book.getBookId());

                borrowRepository.save(br);
                bookCopiesRepository.save(bookCopies);
                userRepository.save(user);

                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public ResponseEntity<HttpStatus> reviewBook(int userId, int bookId, String review) {

        Optional<User> userObj = userRepository.findById(userId);
        Optional<Book> bookObj = bookRepository.findById(bookId);
        User user = userObj.get();
        Book book = bookObj.get();
        BookReview r = new BookReview();
        if(userObj.isPresent() && bookObj.isPresent())
        {
            r.setUserId(user.getUserId());
            r.setBookId(book.getBookId());
            r.setReview(review);
            reviewRepository.save(r);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<HttpStatus> returnBook(int brId) {
        Optional<BookRent> rentObj = rentRepository.findById(brId);
        BookRent br = rentObj.get();
        if(rentObj.isPresent())
        {
            Optional<Book> bookObj = bookRepository.findById(br.getBookId());
            Book book = bookObj.get();
            double rentAmt=0.1*(double)book.getBookPrice();
            double deposit=0.2*(double)book.getBookPrice();

            Optional<BookCopies> bookCopiesObj = bookCopiesRepository.findById(br.getBookId());
            BookCopies bookCopies = bookCopiesObj.get();

            Optional<User> userObj = userRepository.findById(br.getUserId());
            User user = userObj.get();

            user.setUserWallet(user.getUserWallet() + deposit-rentAmt);
            bookCopies.setBookCopies(bookCopies.getBookCopies()+1);
            user.setRentedBooks(user.getRentedBooks()-1);

            br.setReturnDate(LocalDateTime.now());

            borrowRepository.save(br);
            bookCopiesRepository.save(bookCopies);
            userRepository.save(user);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<HttpStatus> likeBook(int userId, int bookId) {
        Optional<User> userObj = userRepository.findById(userId);
        Optional<Book> bookObj = bookRepository.findById(bookId);
        Book book = bookObj.get();
        if(userObj.isPresent() && bookObj.isPresent()){
            if(rented(userId,bookId)) {
                book.setBookLike(book.getBookLike() + 1);
                bookRepository.save(book);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean rented(int userId, int bookId) {
            List<BookRent> brList = new ArrayList<>();
            brList = this.rentRepository.findAll();
            for (BookRent br : brList) {
                if (br.getUserId() == userId && br.getBookId() == bookId) {
                    return true;
                }
            }
            return false;
    }
}