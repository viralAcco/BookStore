package com.accolite.bookstore.repository;

import com.accolite.bookstore.model.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<BookReview, Integer> {

}
