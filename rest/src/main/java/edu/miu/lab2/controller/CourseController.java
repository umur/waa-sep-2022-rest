package edu.miu.lab2.controller;

import edu.miu.lab2.dto.CourseDto;
import edu.miu.lab2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping()
    public List<CourseDto> get() {
        return courseService.get();
    }

    @GetMapping("/{id}")
    public CourseDto get(@PathVariable int id) {
        return courseService.get(id);
    }

    @PostMapping()
    public CourseDto post(@RequestBody CourseDto c) {
        return courseService.add(c);
    }

    @PutMapping("/{id}")
    public boolean put(@PathVariable int id, @RequestBody CourseDto c) {
        courseService.update(id, c);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        courseService.delete(id);
        return true;
    }

}
