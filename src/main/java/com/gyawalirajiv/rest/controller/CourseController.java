package com.gyawalirajiv.rest.controller;

import com.gyawalirajiv.rest.models.Course;
import com.gyawalirajiv.rest.models.DTOs.CourseDTO;
import com.gyawalirajiv.rest.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course){
        return courseService.createCourse(course);
    }

    @GetMapping
    public List<CourseDTO> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public CourseDTO getCourse(@PathVariable("id") Long id){
        return courseService.getCourse(id);
    }

    @PutMapping("/{id}")
    public CourseDTO updateCourse(@PathVariable Long id, @RequestBody CourseDTO course){
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public CourseDTO deleteCourse(@PathVariable Long id){
        return courseService.deleteCourse(id);
    }

}
