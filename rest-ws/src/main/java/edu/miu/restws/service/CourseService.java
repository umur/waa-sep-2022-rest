package edu.miu.restws.service;

import edu.miu.restws.dto.CourseDto;
import edu.miu.restws.entity.Course;

import java.util.List;

public interface CourseService {

    void save(CourseDto courseDto);

    void delete(int id);

    void update(CourseDto courseDto);

    List<CourseDto> findAllCourses();

    CourseDto findById(int id);

    List<CourseDto> findCoursesByStudentId(int studentId);
}
