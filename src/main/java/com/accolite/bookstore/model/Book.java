package com.accolite.bookstore.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id", nullable=false)
    private int bookId;
    @Column(name="book_name", nullable=false)
    private String bookName;
    @Column(name="book_author", nullable=false)
    private String bookAuthor;
    @Column(name="book_price", nullable=false)
    private int bookPrice;
    @Column(name="book_category", nullable=false)
    private String bookCategory;
    @Column(name="book_like")
    private int bookLike;
    @CreationTimestamp
    @Column(name="book_log_time")
    private Date bookLogTime;
    // implement get reviews lazy load them

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public int getBookLike() {
        return bookLike;
    }

    public void setBookLike(int bookLike) {
        this.bookLike = bookLike;
    }

    public Date getBookLogTime() {
        return bookLogTime;
    }

    public void setBookLogTime(Date bookLogTime) {
        this.bookLogTime = bookLogTime;
    }
}
