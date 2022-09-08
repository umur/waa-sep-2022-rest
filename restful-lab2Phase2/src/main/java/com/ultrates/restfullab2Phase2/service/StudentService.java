package com.ultrates.restfullab2Phase2.service;


import com.ultrates.restfullab2Phase2.dto.CourseDto;
import com.ultrates.restfullab2Phase2.dto.StudentDto;

import java.util.List;


public interface StudentService {

    void save(StudentDto s);
    void delete(int id);
    List<StudentDto> getAll();
    StudentDto getById(int id);
    List<StudentDto> getStudentsByMajor(String major);

    List<CourseDto> getCoursesByStudentId(int id);
}
