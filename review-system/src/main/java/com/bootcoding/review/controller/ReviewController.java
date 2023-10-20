package com.bootcoding.review.controller;

import com.bootcoding.review.model.Review;
import com.bootcoding.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping("/review")
    public String insertReview(@RequestBody Review review){

        return  reviewService.insertReview(review);
    }
    @GetMapping("/all_review")
    public List<Review> getAllReview(){
        return reviewService.getAllReview();
    }
    @GetMapping("/review/{id}")
    public Review getById(@PathVariable int id){
        return  reviewService.getById(id);
    }


}
