package com.accolite.bookstore.service;

import com.accolite.bookstore.exception.BookException;
import com.accolite.bookstore.exception.UserException;
import com.accolite.bookstore.model.Book;
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
    public User addMoney(int id, int money) {
        Optional<User> userObj = this.userRepository.findById(id);
        if(userObj.isPresent()){
            if(money%500 == 0 && money != 0) {
                User u = userObj.get();
                u.setUserWallet(u.getUserWallet() + money);
                return this.userRepository.save(u);
            }else{
                throw new UserException("You added money which is not multiple of 500: "+ id);
            }
        }else{
            throw new UserException("User didn't found with ID: "+ id);
        }
    }
    @Override
    public User updateUser(User user) {
        Optional<User> userObj = this.userRepository.findById(user.getUserId());
        if(userObj.isPresent()) {
            User u = userObj.get();
            u.setUserId(user.getUserId());
            u.setUserName(user.getUserName());
            u.setPhoneNum(user.getPhoneNum());
            u.setMailId(user.getMailId());
            u.setUserWallet(user.getUserWallet());
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
    public User suspendUser(int id) {
        Optional<User> userObj = this.userRepository.findById(id);
        if(userObj.isPresent()){
            User u = userObj.get();
            u.setUserStatus(false);
            return this.userRepository.save(u);
        }else{
            throw new UserException("User didn't found with ID: "+ id);
        }
    }


//    @Override
//    public User suspendUser(User user) {
//        Optional<User> userObj = this.userRepository.findById(user.getUserId());
//        if(userObj.isPresent()){
//            User u = userObj.get();
//            u.setUserStatus(false);
//            return this.userRepository.save(u);
//        }else{
//            throw new UserException("User not found with id: "+ user.getUserId());
//        }
//    }


    @Override
    public void deleteUser(int userId) {
        Optional<User> userObj = this.userRepository.findById(userId);
        if(userObj.isPresent()){
            this.userRepository.deleteById(userId);
        }else{
            throw new UserException("User didn't found with ID: "+ userId);
        }
    }
}
