package com.bootcoding.review.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private  String emailId;
    private long phoneNumber;
}
