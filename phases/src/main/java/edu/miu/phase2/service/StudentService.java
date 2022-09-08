package edu.miu.phase2.service;

import edu.miu.phase1.domain.Student;
import edu.miu.phase2.dto.CourseDto;
import edu.miu.phase2.dto.StudentDto;

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
