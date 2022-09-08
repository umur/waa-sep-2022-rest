package com.waa.backend.service.impl;

import com.waa.backend.dto.CourseDTO;
import com.waa.backend.entity.Course;
import com.waa.backend.repo.CourseRepo;
import com.waa.backend.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final ModelMapper modelMapper;
    private final CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo, ModelMapper modelMapper) {
        this.courseRepo = courseRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(CourseDTO courseDTO) {
        var course = modelMapper.map(courseDTO, Course.class);
        courseRepo.save(course);
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepo.findAll().stream().map(course -> modelMapper.map(course, CourseDTO.class)).toList();
    }

    @Override
    public CourseDTO findById(int id) {
        Course course = courseRepo.findById(id);
        return modelMapper.map(course, CourseDTO.class);
    }
}
