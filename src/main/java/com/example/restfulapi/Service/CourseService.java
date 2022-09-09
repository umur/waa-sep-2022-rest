package com.example.restfulapi.Service;

import com.example.restfulapi.DTO.CourseDTO;
import com.example.restfulapi.Model.Course;

import java.util.List;

public interface CourseService {

    public void saveCourse( CourseDTO course);
    public List<CourseDTO> findAllCourses();
    public void updateCourse(int id,CourseDTO course);
    public void deleteCourse(int id);


}
