package com.waa.rest.controllers;

import com.waa.rest.models.Course;
import com.waa.rest.models.Student;
import com.waa.rest.services.CourseService;
import com.waa.rest.services.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
@CrossOrigin
public class StudentController {

    private StudentService studentService;
    private CourseService courseService;
    // inject Student service
    public StudentController(StudentService studentService,
                             CourseService courseService
                             ) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    // Create student
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Student createStudent(
                                 @RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName,
                                 @RequestParam(required = false) String major,
                                 @RequestParam(required = false) double gpa,
                                 @RequestParam(required = false) List<String> courseCodes,
                                 @RequestParam(required = false) String email,
                                 HttpServletResponse response
                                 ) throws IOException {
        List<Course> studentCourses = new ArrayList<>();
        courseCodes.forEach(code ->studentCourses.add(this.courseService.findCourseByCode(code)));
        Student student = new Student(1,firstName,lastName,email,major, gpa,studentCourses);
        response.sendRedirect("/");
        return this.studentService.create(student);
    }
    // Read/Get student by Id
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return this.studentService.getStudentById(id);
    }
    // Update student by Id
    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return this.studentService.update(student);
    }
    // Delete student by Id
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        this.studentService.delete(id);
    }
    // Get all students
    @GetMapping()
    public List<Student> getAllStudents() {
        return this.studentService.getAllStudents();
    }

    @GetMapping("filter") // ?major=major-name
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return this.studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/course")
    public List<Course> getCoursesByStudentId(@PathVariable int id) {
        return this.studentService.getCoursesByStudentId(id);
    }
}
