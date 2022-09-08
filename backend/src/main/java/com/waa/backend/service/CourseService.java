package com.waa.backend.service;

import com.waa.backend.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    void save(CourseDTO courseDTO);
    List<CourseDTO> findAll();
    CourseDTO findById(int id);
}
