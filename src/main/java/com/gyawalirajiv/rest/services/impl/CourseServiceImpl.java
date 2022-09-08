package com.gyawalirajiv.rest.services.impl;

import com.gyawalirajiv.rest.models.Course;
import com.gyawalirajiv.rest.models.DTOs.CourseDTO;
import com.gyawalirajiv.rest.repositories.RestRepository;
import com.gyawalirajiv.rest.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final RestRepository restRepository;

    private final ModelMapper modelMapper;

    @Override
    public CourseDTO createCourse(CourseDTO course) {
        return modelMapper.map(restRepository.createCourse(modelMapper.map(course, Course.class)), CourseDTO.class);
    }

    @Override
    public List<CourseDTO> getCourses() {
        List<Course> courses = restRepository.getCourses();
        return courses.stream().map(c -> modelMapper.map(c, CourseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourse(Long id) {
        return modelMapper.map(restRepository.getCourse(id), CourseDTO.class);
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO course) {
        return modelMapper.map(restRepository.updateCourse(id, modelMapper.map(course, Course.class)), CourseDTO.class);
    }

    @Override
    public CourseDTO deleteCourse(Long id) {
        return modelMapper.map(restRepository.deleteCourse(id), CourseDTO.class);
    }
}
