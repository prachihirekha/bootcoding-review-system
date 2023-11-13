package com.student.student.service;

import com.student.student.dao.CourseRepository;
import com.student.student.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public String insertCourse(Course course) {
        courseRepository.insertCourse(course);
        return "inserted";
    }

//    public List<Course> getAllCourse() {
//        return courseRepository.getAllCourse();
//    }
//
//    public Course getById(int id) {
//        return  courseRepository.getById(id);
//    }
//
//    public String deleteById(int id) {
//        return courseRepository.deleteById(id);
//    }
//
//    public Course updateById(int id, Course course) {
//        return courseRepository.updateById(id,course);
   // }
}
