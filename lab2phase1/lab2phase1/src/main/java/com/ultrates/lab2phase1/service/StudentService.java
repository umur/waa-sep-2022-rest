package com.ultrates.lab2phase1.service;

import com.ultrates.lab2phase1.model.Course;
import com.ultrates.lab2phase1.model.Student;


import java.util.List;


public interface StudentService {

    void save(Student s);
    void delete(int id);
    List<Student> getAll();
    Student getById(int id);
    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int id);
}
