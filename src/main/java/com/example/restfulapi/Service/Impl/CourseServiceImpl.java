package com.example.restfulapi.Service.Impl;

import com.example.restfulapi.Model.Course;
import com.example.restfulapi.Repository.CourseRepo;
import com.example.restfulapi.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Override
    public void saveCourse(Course course) {
        courseRepo.saveCourse(course);

    }

    @Override
    public List<Course> findAllCourses() {
      return  courseRepo.getCourses();
    }

    @Override
    public void updateCourse(int id,Course course) {
        courseRepo.updateCourse(id,course);
    }
    @Override
    public void deleteCourse(int id) {
   courseRepo.deleteCourse(id);
    }



}
