package com.gyawalirajiv.rest.services;

import com.gyawalirajiv.rest.models.Course;
import com.gyawalirajiv.rest.models.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    List<Student> getStudents();

    Student getStudent(Long id);

    Student updateStudent(Long id, Student student);

    Student deleteStudent(Long id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int studentId);
}
