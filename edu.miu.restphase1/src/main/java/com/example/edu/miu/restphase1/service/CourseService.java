package com.example.edu.miu.restphase1.service;

import com.example.edu.miu.restphase1.entity.Course;

import java.util.List;

public interface CourseService {
    void save(Course course);
    void update(Course course);
    void delete(int id);
    Course getById(int id);
    List<Course> getAll();
}
