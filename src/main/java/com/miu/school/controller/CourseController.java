package com.miu.school.controller;

import com.miu.school.dto.CourseDTO;
import com.miu.school.entity.Course;
import com.miu.school.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseServiceImpl courseServiceimpl;
    @GetMapping
    @CrossOrigin
    public List<CourseDTO> getAllCourse(){
        return courseServiceimpl.getAllCourses();
    }
    @PostMapping
    @CrossOrigin
    public void saveNewCourse(@RequestBody CourseDTO course){
        courseServiceimpl.saveNewCourse(course);
    }
    @DeleteMapping("/{id}")
    @CrossOrigin
    public void deleteCourse(@PathVariable int id){
        courseServiceimpl.deleteSpecificCourse(id);
    }
    @PutMapping("/{id}")
    @CrossOrigin
    public void updateSpecificCourse(@RequestBody CourseDTO course,@PathVariable int id){
        System.out.println("here");
        courseServiceimpl.updateSpecificCourse(course,id);
    }

}

