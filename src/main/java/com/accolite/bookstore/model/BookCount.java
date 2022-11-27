package com.accolite.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name="bookCount")
public class BookCount {

    @Id
    @Column(name="c_Id", nullable=false)
    private int cId;
    @Column(name="book_id")
    private int bookId;
    @Column(name="book_copies")
    private int bookCopies;

    public int getBookId() {
        return bookId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

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
