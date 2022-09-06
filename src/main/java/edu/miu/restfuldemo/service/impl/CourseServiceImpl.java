package edu.miu.restfuldemo.service.impl;

import edu.miu.restfuldemo.dto.CourseDto;
import edu.miu.restfuldemo.entity.Course;
import edu.miu.restfuldemo.repo.CourseRepo;
import edu.miu.restfuldemo.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    public CourseServiceImpl(CourseRepo courseRepo, ModelMapper modelMapper) {
        this.courseRepo = courseRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CourseDto> get() {
        List<Course> courses = courseRepo.getAll();
        return courses.stream().map(p -> modelMapper.map(p, CourseDto.class)).toList();
    }

    @Override
    public CourseDto get(int id) {
        Course course = courseRepo.get(id);
        return course == null ? null : modelMapper.map(course, CourseDto.class);
    }

    @Override
    public CourseDto add(CourseDto course) {
        Course c = modelMapper.map(course, Course.class);
        Course newCourse = courseRepo.add(c);
        return modelMapper.map(newCourse, CourseDto.class);
    }

    @Override
    public void update(int id, CourseDto course) {
        Course c = modelMapper.map(course, Course.class);
        courseRepo.update(id, c);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

}
