package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.CourseDto;
import net.javaguides.springboot.entity.Course;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAll();

    void create(CourseDto dto);

    void delete(int id);

    CourseDto update(CourseDto courseDto, int id);
}
