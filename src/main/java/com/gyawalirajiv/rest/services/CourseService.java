package com.gyawalirajiv.rest.services;

import com.gyawalirajiv.rest.models.Course;
import com.gyawalirajiv.rest.models.DTOs.CourseDTO;

import java.util.List;

public interface CourseService {
    CourseDTO createCourse(CourseDTO course);

    List<CourseDTO> getCourses();

    CourseDTO getCourse(Long id);

    CourseDTO updateCourse(Long id, CourseDTO course);

    CourseDTO deleteCourse(Long id);
}
