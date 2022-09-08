package com.waa.rest.services;

import com.waa.rest.models.Course;
import com.waa.rest.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private CourseRepository courseRepository;
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course findOne(int id) {
        return this.courseRepository.findOne(id);
    }

    public Course findCourseByCode(String code) {
        return this.courseRepository.findByCode(code);
    }

    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    
    public Course save(Course course) {
        return this.courseRepository.createCourse(course);
    }

    
    public void delete(int id) {
        this.courseRepository.delete(id);
    }
    
    public Course update(Course course) {
        return this.courseRepository.update(course);
    }

}
