package com.accolite.bookstore.controller;

import com.accolite.bookstore.model.User;
import com.accolite.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController{
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    private ResponseEntity<List<User>> displayUsers(){
        return ResponseEntity.ok().body(this.userService.getUsers());
    }

    @GetMapping("/user/{userId}")
    private ResponseEntity<User> displayUser(@PathVariable int userId){
        return ResponseEntity.ok().body(this.userService.getUserById(userId));
    }

    @PostMapping("/add")
    private ResponseEntity<User> setUser(@RequestBody User user){
        return ResponseEntity.ok().body(this.userService.setUser(user));
    }

    @PutMapping("/update/{userId}")
    private ResponseEntity<User> updateUser(@PathVariable int userId,@RequestBody User user){
        user.setUserId(userId);
        return ResponseEntity.ok().body(this.userService.updateUser(user));
    }

    @PutMapping("/updateStatus/{userId}")
    private ResponseEntity<User> updateUserStatus(@PathVariable int userId,@RequestBody User user) {
        user.setUserId(userId);
        return ResponseEntity.ok().body(this.userService.suspendUser(user));
    }
}