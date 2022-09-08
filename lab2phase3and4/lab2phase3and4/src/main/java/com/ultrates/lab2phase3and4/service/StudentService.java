package com.ultrates.lab2phase3and4.service;




import com.ultrates.lab2phase3and4.dto.CourseDto;
import com.ultrates.lab2phase3and4.dto.StudentDto;

import java.util.List;


public interface StudentService {
    void save(StudentDto s);
    void delete(int id);
    List<StudentDto> getAll();
    StudentDto getById(int id);
    List<StudentDto> getStudentsByMajor(String major);

    List<CourseDto> getCoursesByStudentId(int id);
}
