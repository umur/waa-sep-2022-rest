package edu.miu.restfuldemo.service;

import edu.miu.restfuldemo.dto.CourseDto;
import edu.miu.restfuldemo.entity.Course;

import java.util.List;

public interface CourseService {

    List<CourseDto> get();
    CourseDto get(int id);
    CourseDto add(CourseDto course);
    void update(int id, CourseDto course);
    void delete(int id);

}