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
    @Value("1")
    private boolean userStatus;
    @Column(name = "user_wallet")
    private int userWallet;
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

    public boolean getUserStatus() {
        return userStatus;
    }
    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }
    public int getUserWallet() {
        return userWallet;
    }

    public void setUserWallet(int userWallet) {
        this.userWallet = userWallet;
    }
    public Date getUserLogTime() {
        return userLogTime;
    }

    public void setUserLogTime(Date userLogTime) {
        this.userLogTime = userLogTime;
    }
}
