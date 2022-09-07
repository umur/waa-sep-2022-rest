package henry.phaseii.controller;

import henry.phaseii.dto.CourseDto;
import henry.phaseii.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/courses")
@RequiredArgsConstructor
@RestController
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<CourseDto> getAll() {
        return courseService.findAll();
    }

    @PostMapping
    public void save(@RequestBody CourseDto course) {
        courseService.save(course);
    }

    @PutMapping("/{courseId}")
    public void update(@PathVariable int courseId, @RequestBody CourseDto course) {
        courseService.update(courseId, course);
    }

    @DeleteMapping("/{courseId}")
    public CourseDto delete(@PathVariable int courseId) {
        return courseService.delete(courseId);
    }
}
