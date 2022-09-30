package waa.lab2.service;

import waa.lab2.dto.CourseDto;

import java.util.List;

public interface CourseService {
    void saveCourse(CourseDto courseDto);

    List<CourseDto> getAllCourses();

    CourseDto getCourseById(int id);

    void deleteCourseByID(int id);

    void updateCourseById(int id, CourseDto courseDto);
}
