package edu.miu.day2.service;

import edu.miu.day2.entity.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);

    List<Course> getCourses();

    Course getCourse(Long id);

    Course updateCourse(Long id, Course course);

    Course deleteCourse(Long id);

}
