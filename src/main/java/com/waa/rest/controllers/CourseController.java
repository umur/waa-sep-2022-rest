package com.waa.rest.controllers;

import com.waa.rest.models.Student;
import com.waa.rest.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private StudentService studentService;
    // inject Student service
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
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
}
