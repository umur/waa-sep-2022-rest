package edu.miu.phase3.service;

import edu.miu.phase3.dto.CourseDto;
import edu.miu.phase3.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto save(StudentDto student);
    List<StudentDto> findAll();
    StudentDto findById(int id);
    StudentDto update(int id, StudentDto student);
    StudentDto delete(int id);
    List<CourseDto> getCourseByStudentId(int studentId);
    List<StudentDto> getStudentsByMajor(String major);
}
