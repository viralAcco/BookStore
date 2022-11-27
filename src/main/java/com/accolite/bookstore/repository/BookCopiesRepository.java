package com.accolite.bookstore.repository;

import com.accolite.bookstore.model.BookCopies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCopiesRepository extends JpaRepository<BookCopies, Integer> {

}
