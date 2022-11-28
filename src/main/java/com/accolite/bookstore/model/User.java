package com.accolite.bookstore.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "mail_id",unique = true)
    private String mailId;
    @Column(name = "phone_num",unique = true)
    private String phoneNum;
    @Column(name = "user_status")
    @Value("true")
    private boolean userStatus;
    @Column(name = "user_wallet")
    private double userWallet;
    @Column(name="rented_books")
    private int rentedBooks;
    @CreationTimestamp
    @Column(name = "user_log_time")
    private Date userLogTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public double getUserWallet() {
        return userWallet;
    }

    public void setUserWallet(double userWallet) {
        this.userWallet = userWallet;
    }
    public boolean isUserStatus() {
        return userStatus;
    }
    public void setUserStatus(boolean userStatus){
        this.userStatus = userStatus;
    }
    public int getRentedBooks() {
        return rentedBooks;
    }

    public void setRentedBooks(int rentedBooks) {
        this.rentedBooks = rentedBooks;
    }
    public Date getUserLogTime() {
        return userLogTime;
    }

    public void setUserLogTime(Date userLogTime) {
        this.userLogTime = userLogTime;
    }
}
