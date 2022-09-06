package com.gyawalirajiv.rest.services;

import com.gyawalirajiv.rest.models.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);

    List<Course> getCourses();

    Course getCourse(Long id);

    Course updateCourse(Long id, Course course);

    Course deleteCourse(Long id);
}
