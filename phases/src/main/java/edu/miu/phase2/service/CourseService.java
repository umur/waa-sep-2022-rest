package edu.miu.phase2.service;

import edu.miu.phase2.dto.CourseDto;

import java.util.List;

public interface CourseService {
    CourseDto save(CourseDto course);

    List<CourseDto> findAll();

    CourseDto findById(int id);

    CourseDto update(int id, CourseDto course);

    CourseDto delete(int id);
}
