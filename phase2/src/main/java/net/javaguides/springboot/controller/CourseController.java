package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.CourseDto;
import net.javaguides.springboot.entity.Course;
import net.javaguides.springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService= courseService;
    }

    @GetMapping
    public List<CourseDto> findAllCourses(){
        return courseService.findAll();
    }

    @PostMapping
    public void create(@RequestBody CourseDto dto){
        courseService.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }
    @PutMapping("/{id}")
    public CourseDto update(@RequestBody CourseDto courseDto, @PathVariable int id){
       return courseService.update(courseDto, id);
    }

}
