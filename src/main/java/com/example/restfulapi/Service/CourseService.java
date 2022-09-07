package com.example.restfulapi.Service;

import com.example.restfulapi.Model.Course;

import java.util.List;

public interface CourseService {

    public void saveCourse( Course course);
    public List<Course> findAllCourses();
    public void updateCourse(int id,Course course);
    public void deleteCourse(int id);


}
