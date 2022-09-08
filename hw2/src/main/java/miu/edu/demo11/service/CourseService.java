package miu.edu.demo11.service;

import miu.edu.demo11.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    Course save(Course body);

    Course update(Integer id, Course body);


    Course findOne(Integer id);

    void delete(Integer id);

}
