package com.bootcoding.review.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Review {
//    private int id;
    private int userId;
    private int totalCount;
    private int oneStar;
    private int twoStar;
    private  int threeStar;
    private  int fourStar;
    private  int fiveStar;
}
