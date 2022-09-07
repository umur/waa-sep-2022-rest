package edu.miu.day2backend.service;

import edu.miu.day2backend.dto.CourseDto;

import java.util.List;

public interface CourseService {
    void add(CourseDto c);

    CourseDto  findById(int id);

    void update(CourseDto c, int id);

    void delete(int id);

    List<CourseDto> getAllCourses();

}
