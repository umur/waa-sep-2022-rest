package edu.miu.phase3.service.impl;

import edu.miu.phase3.domain.Course;
import edu.miu.phase3.dto.CourseDto;
import edu.miu.phase3.repo.CourseRepo;
import edu.miu.phase3.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CourseDto save(CourseDto course) {
        //dto to entity
        Course entity = mapper.map(course, Course.class);
        Course addedCourse = courseRepo.add(entity);
        return mapper.map(addedCourse, CourseDto.class);
    }

    @Override
    public List<CourseDto> findAll() {
        //entity to dto
        List<Course> courses = courseRepo.findAll();
        return courses.stream().map(c -> mapper.map(c, CourseDto.class)).toList();
    }

    @Override
    public CourseDto findById(int id) {
        Course course = courseRepo.getCourseById(id);
        return mapper.map(course, CourseDto.class);
    }

    @Override
    public CourseDto update(int id, CourseDto course) {
        Course c = mapper.map(course, Course.class);
        Course result = courseRepo.updateCourse(id, c);
        return result != null ? mapper.map(result, CourseDto.class) : null;
    }

    @Override
    public CourseDto delete(int id) {
        Course c = courseRepo.deleteCourseById(id);
        return c != null ? mapper.map(c, CourseDto.class) : null;
    }
}
