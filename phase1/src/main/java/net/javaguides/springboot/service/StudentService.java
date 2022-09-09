package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.Course;
import net.javaguides.springboot.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    void create(Student student);

    void delete(int id);

    List<Student> findByMajor(String major);

    List<Course> findByIdCourse(int id);

}
