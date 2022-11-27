package com.accolite.bookstore.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="rented")
public class BookRent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "book_id")
    private int bookId;
    @Column(name = "book_quantity")
    private int bookQt;
    @CreationTimestamp
    private Date issueDate;
    @UpdateTimestamp
    private Date returnDate;
    public int getBrId() {
        return brId;
    }

    public void setBrId(int brId) {
        this.brId = brId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookQt() {
        return bookQt;
    }

    public void setBookQt(int bookQt) {
        this.bookQt = bookQt;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
