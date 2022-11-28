
package com.accolite.bookstore.repository;

import com.accolite.bookstore.model.BookRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<BookRent,Integer> {

}