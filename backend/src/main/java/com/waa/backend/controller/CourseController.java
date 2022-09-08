package com.waa.backend.controller;

import com.waa.backend.dto.CourseDTO;
import com.waa.backend.service.impl.CourseServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/courses")
public class CourseController {
    private final CourseServiceImpl courseService;

    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public List<CourseDTO> getCourses() {
        return courseService.findAll();
    }

    @PostMapping("")
    public void save(@RequestBody CourseDTO courseDTO) {
        courseService.save(courseDTO);
    }

    @GetMapping("/{id}")
    public CourseDTO findById(@PathVariable int id) {
        return courseService.findById(id);
    }
}
