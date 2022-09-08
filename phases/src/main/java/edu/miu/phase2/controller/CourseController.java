package edu.miu.phase2.controller;

import edu.miu.phase1.domain.Course;
import edu.miu.phase1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseSvc;

    @GetMapping
    public List<Course> findAll() {
        return courseSvc.findAll();
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable int id) {
        return courseSvc.findById(id);
    }

    @PostMapping
    public Course save(@RequestBody Course course) {
        return courseSvc.save(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable int id, @RequestBody Course course) {
        return courseSvc.update(id, course);
    }

    @DeleteMapping("/{id}")
    public Course delete(@PathVariable int id) {
        return courseSvc.delete(id);
    }
}
