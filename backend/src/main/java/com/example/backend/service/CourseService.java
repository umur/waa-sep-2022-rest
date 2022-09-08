package com.example.backend.service;

import com.example.backend.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAll();

    CourseDTO getById(int id);

    void delete(int id);

    void update( int id, CourseDTO course);

    CourseDTO create(CourseDTO course);
}
