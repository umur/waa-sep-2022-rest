package com.waa.rest.controllers;

import com.waa.rest.models.Course;
import com.waa.rest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("courses")
public class CourseController {

    private CourseService courseService;
    // inject Course service
    @Autowired // is optional
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

   /* // Create course
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return this.courseService.save(course);
    } */
    // Create course
    @PostMapping
    public Course createCourse(@RequestParam String name, @RequestParam String code,
                               HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
        return this.courseService.save(new Course(0, name, code));
    }
    // Read/Get course by Id
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return this.courseService.findOne(id);
    }
    // Update course by Id
    @PutMapping
    public Course updateCourse(@RequestBody Course course) {
        return this.courseService.update(course);
    }
    // Delete course by Id
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        this.courseService.delete(id);
    }
    // Get all courses
    @GetMapping()
    public List<Course> getAllCourses() {
        return this.courseService.findAll();
    }

}
