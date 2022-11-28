//package com.accolite.bookstore.model;
//
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//@Entity
//@Table(name="rentalTransaction")
//public class RentalTransaction {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "rt_id")
//    private int rtId;
//
//    @Column(name = "user_id")
//    private int userId;
//
//    @Column(name = "book_id")
//    private int bookId;
//
//    @CreationTimestamp
//    @Column(name="issue_date", columnDefinition = "TIMESTAMP")
//    private Date issueDate;
//
//    @Column(name="return_date", columnDefinition = "TIMESTAMP")
//    private LocalDateTime returnDate;
//
//}
