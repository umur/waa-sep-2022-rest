package com.waa.backend.service;

import com.waa.backend.dto.CourseDTO;
import com.waa.backend.dto.StudentDTO;
import com.waa.backend.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getStudentsByMajor(String major);
    List<CourseDTO> getCoursesByStudentId(int studentId);
    void save(StudentDTO studentDTO);
    List<StudentDTO> findAll();

    Student findById(int id);
}
