package com.gyawalirajiv.rest.services.impl;

import com.gyawalirajiv.rest.models.Course;
import com.gyawalirajiv.rest.repositories.RestRepository;
import com.gyawalirajiv.rest.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final RestRepository restRepository;

    @Override
    public Course createCourse(Course course) {
        return restRepository.createCourse(course);
    }

    @Override
    public List<Course> getCourses() {
        return restRepository.getCourses();
    }

    @Override
    public Course getCourse(Long id) {
        return restRepository.getCourse(id);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        return restRepository.updateCourse(id, course);
    }

    @Override
    public Course deleteCourse(Long id) {
        return restRepository.deleteCourse(id);
    }
}
