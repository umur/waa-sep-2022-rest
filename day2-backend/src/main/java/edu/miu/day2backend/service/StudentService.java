package edu.miu.day2backend.service;

import edu.miu.day2backend.dto.CourseDto;
import edu.miu.day2backend.dto.StudentDto;

import java.util.List;

public interface StudentService {
    void add(StudentDto s);

    StudentDto findById(int id);

    void update(StudentDto c, int id);

    void delete(int id);

    List<StudentDto> getAllStudents();

    List<StudentDto> findStudentsByMajor(String major);

    List<CourseDto> findCourseTakenByStudent(Integer studentId);




}
