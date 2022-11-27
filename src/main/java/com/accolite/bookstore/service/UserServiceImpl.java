package com.accolite.bookstore.service;

import com.accolite.bookstore.exception.UserException;
import com.accolite.bookstore.model.User;
import com.accolite.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    public UserRepository userRepository;


    @Override
    public User setUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userObj = this.userRepository.findById(user.getUserId());
        if(userObj.isPresent()) {
            User u = userObj.get();
            u.setUserId(user.getUserId());
            u.setUserName(user.getUserName());
            u.setUserStatus(user.getUserStatus());
            u.setPhoneNum(user.getPhoneNum());
            u.setMailId(user.getMailId());
            return this.userRepository.save(u);
        }else{
            throw new UserException("User didn't found with ID: "+ user.getUserId());
        }
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        Optional<User> userObj = this.userRepository.findById(id);
        if(userObj.isPresent()){
            return userObj.get();
        }else{
            throw new UserException("User didn't found with ID: "+ id);
        }
    }

    @Override
    public User suspendUser(User user) {
        Optional<User> userObj = this.userRepository.findById(user.getUserId());
        if(userObj.isPresent()){
            User u = userObj.get();
            u.setUserStatus(user.getUserStatus());
            return this.userRepository.save(u);
        }else{
            throw new UserException("User didn't found with ID: "+ user.getUserId());
        }
    }
}
