package com.accolite.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name="book_copies")
public class BookCopies {


//    @Column(name="c_Id", nullable=false)
//    private int cId;
    @Id
    @Column(name="book_id", nullable=false, unique = true)
    private int bookId;
    @Column(name="book_copies", nullable = false)
    private int bookCopies;

    public int getBookId() {
        return bookId;
    }

//    public int getcId() {
//        return cId;
//    }
//
//    public void setcId(int cId) {
//        this.cId = cId;
//    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(int bookCopies) {
        this.bookCopies = bookCopies;
    }
}
