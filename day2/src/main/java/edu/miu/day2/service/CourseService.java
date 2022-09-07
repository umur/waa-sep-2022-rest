package edu.miu.day2.service;

import edu.miu.day2.entity.Course;
import edu.miu.day2.entity.DTO.CourseDTO;

import java.util.List;

public interface CourseService {
    CourseDTO createCourse(CourseDTO course);

    List<CourseDTO> getCourses();

    CourseDTO getCourse(Long id);

    CourseDTO updateCourse(Long id, CourseDTO course);

    CourseDTO deleteCourse(Long id);

}
