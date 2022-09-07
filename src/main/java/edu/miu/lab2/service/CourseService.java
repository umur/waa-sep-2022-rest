package edu.miu.lab2.service;

import edu.miu.lab2.dto.CourseDto;

import java.util.List;

public interface CourseService {

    List<CourseDto> get();
    CourseDto get(int id);
    CourseDto add(CourseDto course);
    void update(int id, CourseDto course);
    void delete(int id);

}