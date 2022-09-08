package edu.miu.day2backend.service.impl;

import edu.miu.day2backend.domain.Course;
import edu.miu.day2backend.dto.CourseDto;
import edu.miu.day2backend.repo.CourseRepo;
import edu.miu.day2backend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    @Override
    public void add(CourseDto c) {
        Course course = modelMapper.map(c, Course.class);
        courseRepo.add(course);
    }

    @Override
    public CourseDto findById(int id) {
        Course c = courseRepo.findById(id);
        return modelMapper.map(c, CourseDto.class);
    }

    @Override
    public void update(CourseDto c, int id) {
        Course course = modelMapper.map(c, Course.class);
        courseRepo.update(course, id);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return courseRepo.findAll().stream().map(c -> modelMapper.map(c, CourseDto.class)).collect(Collectors.toList());
    }
}
