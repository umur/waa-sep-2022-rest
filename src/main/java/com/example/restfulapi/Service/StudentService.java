package com.example.restfulapi.Service;

import com.example.restfulapi.DTO.CourseDTO;
import com.example.restfulapi.DTO.StudentDTO;
import com.example.restfulapi.Model.Course;
import com.example.restfulapi.Model.Student;

import java.util.List;

public interface StudentService {

    public List<StudentDTO> findAll();
    public void add(StudentDTO student);
    public void updateStudent(int id, StudentDTO student);
    public void deleteStudent(int id);

    public List<StudentDTO> getAllStudentsByMajor(String major);
    public List<CourseDTO> getAllCoursesByStudentId(int id);



}
