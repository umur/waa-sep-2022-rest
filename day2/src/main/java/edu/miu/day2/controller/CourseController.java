package edu.miu.day2.controller;

import edu.miu.day2.entity.Course;
import edu.miu.day2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course){

        return courseService.createCourse(course);
    }

    @GetMapping
    public List<Course> getCourses(){

        return courseService.getCourses();
    }
    @GetMapping("/{id}")
    public Course getCourse(@PathVariable("id") Long id){
        return courseService.getCourse(id);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course){
        return courseService.updateCourse(id,course);
    }

    @DeleteMapping("/{id}")
    public Course deleteCourse(@PathVariable Long id){
        return courseService.deleteCourse(id);
    }




}
