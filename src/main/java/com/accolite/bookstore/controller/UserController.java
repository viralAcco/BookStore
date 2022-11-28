package com.accolite.bookstore.controller;

import com.accolite.bookstore.model.User;
import com.accolite.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController{
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    private ResponseEntity<List<User>> displayUsers(){
        return ResponseEntity.ok().body(this.userService.getUsers());
    }

    @GetMapping("/users/{userId}")
    private ResponseEntity<User> displayUser(@PathVariable int userId){
        return ResponseEntity.ok().body(this.userService.getUserById(userId));
    }

    @PostMapping("/addUser")
    private ResponseEntity<User> setUser(@RequestBody User user){
        return ResponseEntity.ok().body(this.userService.setUser(user));
    }

    @PutMapping("/updateUser/{userId}")
    private ResponseEntity<User> updateUser(@PathVariable int userId,@RequestBody User user){
        user.setUserId(userId);
        return ResponseEntity.ok().body(this.userService.updateUser(user));
    }

    @PutMapping("/addMoney/{userId}/{money}")
    private ResponseEntity<User> updateWallet(@PathVariable int userId, @PathVariable int money){
        return ResponseEntity.ok().body(this.userService.addMoney(userId, money));
    }
//    @PutMapping("/suspendUser/{userId}")
//    private ResponseEntity<User> suspendUser(@PathVariable int userId,@RequestBody User user) {
//        user.setUserId(userId);
//        return ResponseEntity.ok().body(this.userService.suspendUser(user));
//    }
    @PutMapping("/suspendUser/{userId}")
    private HttpStatus suspendUser(@PathVariable int userId){
        this.userService.suspendUser(userId);
        return HttpStatus.OK;
    }
    @DeleteMapping("/removeUser/{userId}")
    private HttpStatus deleteUser(@PathVariable int userId){
        this.userService.deleteUser(userId);
        return HttpStatus.OK;
    }
}