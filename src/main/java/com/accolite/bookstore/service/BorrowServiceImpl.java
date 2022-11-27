package com.accolite.bookstore.service;

import com.accolite.bookstore.model.*;
import com.accolite.bookstore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

            if(bookCopies.getBookCopies() > 0 && user.isUserStatus() && neededBal<user.getUserWallet() && user.getRentedBooks()<3){
                bookCopies.setBookCopies(bookCopies.getBookCopies()-1);
                user.setUserWallet(user.getUserWallet()-(int)(0.2*(double)(book.getBookPrice())));
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
}
