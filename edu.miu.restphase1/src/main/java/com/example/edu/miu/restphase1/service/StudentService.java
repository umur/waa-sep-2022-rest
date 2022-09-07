package com.example.edu.miu.restphase1.service;

import com.example.edu.miu.restphase1.entity.Course;
import com.example.edu.miu.restphase1.entity.Student;

import java.util.List;

public interface StudentService {

    void save(Student student);
    void update(Student student);
    void delete(int id);
    Student getById(int id);
    List<Student> getAll();
    List<Course> getCoursesByStudentId(int studentId);
    List<Student> getStudentsByMajor(String major);
}
