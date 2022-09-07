package com.miu.school.service.impl;

import com.miu.school.entity.Course;
import com.miu.school.repo.CourseRepository;
import com.miu.school.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses(){
       return  courseRepository.getAllCourse();
    }

    public void saveNewCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteSpecificCourse(int id) {
        courseRepository.deleteCourseById(id);
    }
    public void updateSpecificCourse(Course course,int id){
        courseRepository.updateCourseById(course,id);
    }
}
