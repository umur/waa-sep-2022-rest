package com.example.restfulapi.Controller;

import com.example.restfulapi.DTO.CourseDTO;
import com.example.restfulapi.Model.Course;
import com.example.restfulapi.Repository.CourseRepo;
import com.example.restfulapi.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/courses")
public class CourseController {
       @Autowired
       CourseService courseService;
    @PostMapping
    public void addCourse(@RequestBody CourseDTO course){
        courseService.saveCourse(course);
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){
        return courseService.findAllCourses();
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable int id, @RequestBody CourseDTO course){
        courseService.updateCourse(id,course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
    }





}
