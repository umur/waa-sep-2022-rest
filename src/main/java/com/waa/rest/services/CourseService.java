package com.waa.rest.services;

import com.waa.rest.models.Course;
import com.waa.rest.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseImpl implements CourseInterface {

    private CourseRepository courseRepository;
    public CourseImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course findOne() {

    }

    @Override
    public List<Course> finAll() {
        return null;
    }

    @Override
    public Course save() {
        return null;
    }

    @Override
    public void delete() {

    }


}
