package com.bootcoding.review.service;

import com.bootcoding.review.model.Review;
import com.bootcoding.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public String insertReview(Review review) {
//        print(review);
        reviewRepository.save(review);
        return "insert successfully data";
    }
    public void print(Review review){
        System.out.println(review.getTotalCount());
        System.out.println(review.getOneStar());
        System.out.println(review.getTwoStar());
        System.out.println(review.getThreeStar());
        System.out.println(review.getFourStar());
        System.out.println(review.getFiveStar());
    }

    public List<Review> getAllReview() {
        return  reviewRepository.getAllReview();
    }
}
