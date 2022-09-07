package edu.miu.day2.controller;

import edu.miu.day2.entity.Course;
import edu.miu.day2.entity.DTO.CourseDTO;
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
        return courseService.updateCourse(id,course);
    }

    @DeleteMapping("/{id}")
    public CourseDTO deleteCourse(@PathVariable Long id){
        return courseService.deleteCourse(id);
    }




}
