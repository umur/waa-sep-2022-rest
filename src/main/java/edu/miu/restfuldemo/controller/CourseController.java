package edu.miu.restfuldemo.controller;

import edu.miu.restfuldemo.dto.CourseDto;
import edu.miu.restfuldemo.service.CourseService;
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
    public CourseDto put(@PathVariable int id, @RequestBody CourseDto c) {
        courseService.update(id, c);
        return c;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        courseService.delete(id);
        return true;
    }

}
