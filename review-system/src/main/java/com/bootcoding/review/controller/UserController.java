package com.bootcoding.review.controller;

import com.bootcoding.review.model.User;
import com.bootcoding.review.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/health/check")
    public String healthCheck(){
        return "I am live";
    }
    @PostMapping("/user")
    public String createUser(@RequestBody User user){
        return  userService.createUser(user);

    }
    @GetMapping("/user")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }
//    @GetMapping("/user/{id}")
//    public User getById(@PathVariable int id){
//        return userService.getById(id);
//    }
}
