package edu.miu.restfullab2.service;

import edu.miu.restfullab2.entity.Course;
import edu.miu.restfullab2.entity.Student;

import java.util.List;

public interface CourseService {
    void save(Course c);

    List<Course> findAll();

    Course getById(int id);

    Course createCourse(Course course);

    int deleteCourse(int id);

    Course updateCourse(int id, Course course);
}
