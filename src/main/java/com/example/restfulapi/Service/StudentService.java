package com.example.restfulapi.Service;

import com.example.restfulapi.Model.Course;
import com.example.restfulapi.Model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAll();
    public void add(Student student);
    public void updateStudent(int id, Student student);
    public void deleteStudent(int id);

    public List<Student> getAllStudentsByMajor(String major);
    public List<Course> getAllCoursesByStudentId(int id);


}
