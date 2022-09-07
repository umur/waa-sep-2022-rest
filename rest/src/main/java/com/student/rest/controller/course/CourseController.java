package com.student.rest.controller.course;

import com.student.rest.exceptions.course.CourseDoesNotExistsException;
import com.student.rest.exceptions.course.CourseAlreadyExistsException;
import com.student.rest.model.Course;
import com.student.rest.service.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    // /course GET
    @GetMapping
    public List<Course> getAll() {
        return courseService.get();
    }

    @PostMapping
    public void addCourse(Course course) throws CourseAlreadyExistsException {
        courseService.add(course);
    }

    @PutMapping("/{id}")
    public boolean updateCourse(@PathVariable int id, @RequestBody Course course) throws CourseDoesNotExistsException {
        return courseService.updateCourse(course, id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCourse(int id) throws CourseDoesNotExistsException {
        return courseService.deleteCourse(id);
    }
}
