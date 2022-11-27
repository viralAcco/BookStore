package com.accolite.bookstore.service;

import com.accolite.bookstore.model.User;
import com.accolite.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    User setUser(User user);

    User addMoney(int id, int money);

    User updateUser(User user);

    List<User> getUsers();

    User getUserById(int id);

    User suspendUser(User user);

    void deleteUser(int id);

}
