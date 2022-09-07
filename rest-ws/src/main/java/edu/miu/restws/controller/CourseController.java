package edu.miu.restws.controller;

import edu.miu.restws.dto.CourseDto;
import edu.miu.restws.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseDto> getAll() {
        return courseService.findAllCourses();
    }

    @GetMapping("/{id}")
    public CourseDto getById(@PathVariable int id) {
        return courseService.findById(id);
    }

    @PostMapping
    public void add(@RequestBody CourseDto courseDto) {
        courseService.save(courseDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody CourseDto courseDto) {
        courseService.update(courseDto);
    }
}
