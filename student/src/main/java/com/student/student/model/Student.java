package com.student.student.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private int id;
    private String studentName;
    private String gmailId;
    private  long phoneNumber;
    private  String address;
    private List<Student> student;

}
