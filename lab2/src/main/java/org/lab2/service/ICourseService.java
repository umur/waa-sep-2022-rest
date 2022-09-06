package org.lab2.service;

import org.lab2.dto.CourseDTO;

import java.util.List;

public interface ICourseService {
    void save(CourseDTO courseDTO);

    List<CourseDTO> findAll();

    CourseDTO update(CourseDTO courseDTO);

    void delete(Integer courseID);
}
