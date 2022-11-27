package com.accolite.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name="bookCount")
public class BookCount {

    @Id
    @Column(name="book_id", nullable=false, unique = true)
    private int bookId;
    @Column(name="book_copies")
    private int bookCopies;

    public int getBookId() {
        return bookId;
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
