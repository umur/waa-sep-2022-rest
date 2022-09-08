package edu.miu.phase3.controller;

import edu.miu.phase3.domain.Course;
import edu.miu.phase3.dto.CourseDto;
import edu.miu.phase3.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseSvc;

    @GetMapping
    public List<CourseDto> findAll() {
        return courseSvc.findAll();
    }

    @GetMapping("/{id}")
    public CourseDto findById(@PathVariable int id) {
        return courseSvc.findById(id);
    }

    @PostMapping
    public CourseDto save(@RequestBody CourseDto course) {
        return courseSvc.save(course);
    }

    @PutMapping("/{id}")
    public CourseDto update(@PathVariable int id, @RequestBody CourseDto course) {
        return courseSvc.update(id, course);
    }

    @DeleteMapping("/{id}")
    public CourseDto delete(@PathVariable int id) {
        return courseSvc.delete(id);
    }
}
