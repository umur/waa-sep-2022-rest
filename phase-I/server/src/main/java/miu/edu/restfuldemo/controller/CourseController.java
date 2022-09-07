package miu.edu.restfuldemo.controller;

import miu.edu.restfuldemo.entity.Course;
import miu.edu.restfuldemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public void save(@RequestBody Course course) {
        courseService.save(course);
    }

    @GetMapping
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Integer id) {
        return courseService.getById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Course course) {
        courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        courseService.delete(id);
    }
}
