package org.lab2.controller;

import lombok.RequiredArgsConstructor;
import org.lab2.dto.CourseDTO;
import org.lab2.service.impl.CourseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private CourseServiceImpl courseService;


    @GetMapping
    public List<CourseDTO> findAll(){
        return  courseService.findAll();
    }

    @DeleteMapping("/{id}")
    public  void delete(@PathVariable Integer id){
        courseService.delete(id);
    }
    @PutMapping()
    public  CourseDTO updateCourse(@RequestBody CourseDTO course){
        return courseService.update(course);
    }

    @PostMapping()
    public void saveCourse(@RequestBody CourseDTO course){
        courseService.save(course);
    }

}
