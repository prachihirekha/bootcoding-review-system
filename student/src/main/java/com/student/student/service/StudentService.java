package com.student.student.service;

import com.student.student.dao.StudentRepository;
import com.student.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public String  insertStudent(Student student) {
         studentRepository.insertStudent(student);
         return "insert successfully";
    }

    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    public Student getStudentById(int id) {
        return  studentRepository.getStudentById(id);
    }

    public String deleteById(int id) {
        return studentRepository.deleteById(id);
    }

    public Student updateStudent(int id, Student student) {
        return  studentRepository.updateById(id,student);
    }
}
