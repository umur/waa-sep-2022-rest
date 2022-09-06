package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    void create(Course course);

    void delete(int id);

    void update(Course course, int id);
}
