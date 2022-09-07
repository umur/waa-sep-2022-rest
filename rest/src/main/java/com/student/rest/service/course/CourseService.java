package com.student.rest.service.course;

import com.student.rest.dto.CourseDto;
import com.student.rest.exceptions.course.CourseDoesNotExistsException;
import com.student.rest.exceptions.course.CourseAlreadyExistsException;
import com.student.rest.model.Course;

import java.util.List;

public interface CourseService {
    public CourseDto add(CourseDto course) throws CourseAlreadyExistsException;
    public List<CourseDto> get();
    public boolean updateCourse (CourseDto course, int id) throws CourseDoesNotExistsException;
    public boolean deleteCourse (int id) throws CourseDoesNotExistsException;
}
