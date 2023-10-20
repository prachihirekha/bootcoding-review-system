package com.student.student.controller;

import com.student.student.model.Student;
import com.student.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
     @PostMapping("/student")
    public String insertStudent(@RequestBody Student student){
         return  studentService.insertStudent(student);
     }
     @GetMapping("/students")
    public List<Student> getAllStudent(){
         return studentService.getAllStudent();
     }
     @GetMapping("/student/{id}")
    public  Student getStudentById(@PathVariable int id){
         return studentService.getStudentById(id);
     }
     @DeleteMapping("/students/{id}")
    public String deleteById(@PathVariable int id){
         return studentService.deleteById(id);
     }
     @PutMapping("/student/{id}")
    public Student  updateStudent(@PathVariable int id,@RequestBody Student student){
         return  studentService.updateStudent(id,student);
     }
}
