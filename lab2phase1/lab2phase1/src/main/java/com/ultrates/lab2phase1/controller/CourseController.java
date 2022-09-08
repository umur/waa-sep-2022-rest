package com.ultrates.lab2phase1.controller;


import com.ultrates.lab2phase1.model.Course;
import com.ultrates.lab2phase1.service.CourseService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("v1/courses")
    public ResponseEntity<List<Course>> getAll(){
        return ResponseEntity.status(200).body(courseService.getAll());
    }

    @GetMapping("v1/courses/{id}")
    public Course getById(@PathVariable int id) {
        return courseService.getById(id);
    }
    @PostMapping("v1/courses")
    public  void save(@RequestBody Course c) {
        courseService.save(c);
    }

    @DeleteMapping("v1/courses/{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }


}
