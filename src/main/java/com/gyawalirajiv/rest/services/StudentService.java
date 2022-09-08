package com.gyawalirajiv.rest.services;

import com.gyawalirajiv.rest.models.Course;
import com.gyawalirajiv.rest.models.DTOs.CourseDTO;
import com.gyawalirajiv.rest.models.DTOs.StudentDTO;
import com.gyawalirajiv.rest.models.Student;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO student);

    List<StudentDTO> getStudents();

    StudentDTO getStudent(Long id);

    StudentDTO updateStudent(Long id, StudentDTO student);

    StudentDTO deleteStudent(Long id);

    List<StudentDTO> getStudentsByMajor(String major);

    List<CourseDTO> getCoursesByStudentId(int studentId);
}
