package com.example.backend.service;

import com.example.backend.dto.CourseDTO;
import com.example.backend.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAll();

    StudentDTO getById(int id);

    void delete(int id);

    void update( int id, StudentDTO student);

    List<StudentDTO> getByMajor(String major);

    List<CourseDTO> getStudentCourses(int id);

    StudentDTO create(StudentDTO student);
}
