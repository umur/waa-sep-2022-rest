package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.StudentDto;
import net.javaguides.springboot.entity.Course;
import net.javaguides.springboot.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();

    void create(StudentDto dto);

    void delete(int id);
    StudentDto update(StudentDto dto, int id);


    List<StudentDto> findByMajor(String major);

    List<Course> findCoursesByStudentId(int id);

}
