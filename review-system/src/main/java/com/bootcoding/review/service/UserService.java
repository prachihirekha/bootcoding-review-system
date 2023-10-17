package com.bootcoding.review.service;

import com.bootcoding.review.model.User;
import com.bootcoding.review.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
     private  UserRepository userRepository;
    public String createUser(User user) {
      print(user);
      userRepository.save(user);
      return "SuccessFully User Created";

    }
    private  void print(User user){
        System.out.println(user.getUserName());
        System.out.println(user.getEmailId());
        System.out.println(user.getPhoneNumber());

    }

    public List<User> getAllUsers() {
        return  userRepository.getAllUser();
    }

    public User getById(int id) {
        return userRepository.getById(id);
    }

    public String deleteById(int id) {
       return  userRepository.deleteById(id);
    }

    public User updateById(int id, User user) {
        return userRepository.updateById(id,user);
    }

    public List<User> insertMultipleUser(List<User> users) {
        return  userRepository.insertMultipleUser(users);
    }
}
