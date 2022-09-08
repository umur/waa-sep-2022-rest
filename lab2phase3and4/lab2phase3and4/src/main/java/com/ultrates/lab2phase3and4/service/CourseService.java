package com.ultrates.lab2phase3and4.service;


import com.ultrates.lab2phase3and4.dto.CourseDto;

import java.util.List;


public interface CourseService {

    void save(CourseDto c);
    void delete(int id);
    List<CourseDto> getAll();
    CourseDto getById(int id);

}
