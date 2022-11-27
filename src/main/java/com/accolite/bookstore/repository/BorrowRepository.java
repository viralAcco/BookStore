package com.accolite.bookstore.repository;

import com.accolite.bookstore.model.BookRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<BookRent,Integer> {
}
