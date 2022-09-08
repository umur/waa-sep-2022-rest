package edu.miu.restfullab2.controller;

import edu.miu.restfullab2.dto.CourseDto;
import edu.miu.restfullab2.entity.Course;
import edu.miu.restfullab2.entity.Student;
import edu.miu.restfullab2.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/courses")
@RestController
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAll(){
        return courseService.findAll();
    }
    @GetMapping("/{id}")
    public Course getById(@PathVariable int id){
        return courseService.getById(id);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

    @DeleteMapping("/{id}")
    public int deleteStudentById(@PathVariable int id){
        return courseService.deleteCourse(id);
    }

    @PutMapping
    public Course updateCourse(@PathVariable int id, @RequestBody Course course){
        return courseService.updateCourse(id, course);
    }

}
