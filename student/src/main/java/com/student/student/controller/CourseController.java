package com.student.student.controller;

import com.student.student.model.Course;
import com.student.student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public String insertCourse(@RequestBody Course course){
        return  courseService.insertCourse(course);
    }
    @GetMapping("/course")
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }
    @GetMapping("/course/{id}")
    public Course getById(@PathVariable int id){
        return courseService.getById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        return courseService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public Course updateById(@PathVariable int id,@RequestBody Course course){
        return   courseService.updateById(id,course);
    }
}
