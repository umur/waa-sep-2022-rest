package com.miu.school.service.impl;

import com.miu.school.dto.CourseDTO;
import com.miu.school.entity.Course;
import com.miu.school.repo.CourseRepository;
import com.miu.school.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ModelMapper mapper;

    public List<CourseDTO> getAllCourses(){
       return  courseRepository.getAllCourse().stream().map(course -> mapper.map(course, CourseDTO.class)).collect(Collectors.toList());
    }

    public void saveNewCourse(CourseDTO course) {
        courseRepository.save(mapper.map(course,Course.class));
    }

    public void deleteSpecificCourse(int id) {
        courseRepository.deleteCourseById(id);
    }
    public void updateSpecificCourse(CourseDTO course, int id){

        courseRepository.updateCourseById( mapper.map(course,Course.class),id);
    }
}
