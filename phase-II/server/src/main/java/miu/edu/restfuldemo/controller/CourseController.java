package miu.edu.restfuldemo.controller;

import miu.edu.restfuldemo.dto.CourseDTO;
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
    public void save(@RequestBody CourseDTO courseDTO) {
        courseService.save(courseDTO);
    }

    @GetMapping
    public List<CourseDTO> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public CourseDTO getById(@PathVariable Integer id) {
        return courseService.getById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody CourseDTO courseDTO) {
        courseService.update(id, courseDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        courseService.delete(id);
    }
}
