package com.ultrates.lab2phase3and4.controller;


import com.ultrates.lab2phase3and4.dto.CourseDto;
import com.ultrates.lab2phase3and4.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAll(){
        return ResponseEntity.status(200).body(courseService.getAll());
    }

    @GetMapping("/{id}")
    public CourseDto getById(@PathVariable int id) {
        return courseService.getById(id);
    }
    @PostMapping
    public  void save(@RequestBody CourseDto c) {
        courseService.save(c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }


}
