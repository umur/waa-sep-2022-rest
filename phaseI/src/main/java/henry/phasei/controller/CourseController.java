package henry.phasei.controller;

import henry.phasei.entity.Course;
import henry.phasei.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/courses")
@RequiredArgsConstructor
@RestController
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<Course> getAll() {
        return courseService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Course course) {
        courseService.save(course);
    }

    @PutMapping("/{courseId}")
    public void update(@PathVariable int courseId, @RequestBody Course course) {
        courseService.update(courseId, course);
    }

    @DeleteMapping("/{courseId}")
    public Course delete(@PathVariable int courseId) {
        return courseService.delete(courseId);
    }
}
