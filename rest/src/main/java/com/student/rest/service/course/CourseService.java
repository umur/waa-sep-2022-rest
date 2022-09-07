package com.student.rest.service.course;

import com.student.rest.exceptions.course.CourseDoesNotExistsException;
import com.student.rest.exceptions.course.CourseAlreadyExistsException;
import com.student.rest.model.Course;

import java.util.List;

public interface CourseService {
    public void add(Course course) throws CourseAlreadyExistsException;
    public List<Course> get();
    public boolean updateCourse (Course course) throws CourseDoesNotExistsException;
    public boolean deleteCourse (int id) throws CourseDoesNotExistsException;
}
