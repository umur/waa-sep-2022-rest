package edu.miu.lab2.service;

import edu.miu.lab2.dto.CourseDto;
import edu.miu.lab2.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> get();
    StudentDto get(int id);
    StudentDto add(StudentDto course);
    void update(int id, StudentDto course);
    void delete(int id);
    List<StudentDto> getStudentsByMajor(String major);
    List<CourseDto> getCoursesByStudentId(int id);

}
