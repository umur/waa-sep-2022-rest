package org.lab2.service.impl;

import lombok.RequiredArgsConstructor;
import org.lab2.dto.CourseDTO;
import org.lab2.entity.Course;
import org.lab2.repository.CourseRepo;
import org.lab2.service.ICourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {

    private CourseRepo courseRepo;

    private ModelMapper modelMapper;
    @Override
    public void save(CourseDTO courseDTO) {
        Course newCourse = modelMapper.map(courseDTO, Course.class);
        courseRepo.add(newCourse);
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepo.getCourses().stream().map(course -> modelMapper.map(course,CourseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CourseDTO update(CourseDTO courseDTO) {
        Course course = modelMapper.map(courseDTO,Course.class);
        Course updatedCourse = courseRepo.update(course);
        return  modelMapper.map(updatedCourse,CourseDTO.class);
    }

    @Override
    public void delete(Integer courseID) {
        courseRepo.delete(courseID);
    }
}
