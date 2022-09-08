package com.ultrates.restfullab2Phase2.service;


import com.ultrates.restfullab2Phase2.dto.CourseDto;

import java.util.List;


public interface CourseService {

    void save(CourseDto c);
    void delete(int id);
    List<CourseDto> getAll();
    CourseDto getById(int id);

}
