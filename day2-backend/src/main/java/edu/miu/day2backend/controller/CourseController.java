package edu.miu.day2backend.controller;

import edu.miu.day2backend.dto.CourseDto;
import edu.miu.day2backend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseDto getCourse(@PathVariable Integer id) {
        return courseService.findById(id);
    }

    @PostMapping
    public void saveCourse(@RequestBody CourseDto courseDto) {
        courseService.add(courseDto);
    }

    @PutMapping("/{id}")
    public void updateCourse(@RequestBody CourseDto courseDto, @PathVariable Integer id) {
        courseService.update(courseDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        courseService.delete(id);
    }

    @GetMapping("/filter")
    public List<CourseDto> filterCourseByStudentId(@RequestParam Integer studentId) {
        return null;
    }




}
