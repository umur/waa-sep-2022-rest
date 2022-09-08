package com.waa.backend.controller;

import com.waa.backend.dto.CourseDTO;
import com.waa.backend.dto.StudentDTO;
import com.waa.backend.entity.Student;
import com.waa.backend.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/filter")
    public List<StudentDTO> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDTO> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("")
    public List<StudentDTO> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.findById(id);
    }

    @PostMapping("")
    public void saveStudent(@RequestBody StudentDTO studentDTO) {
        studentService.save(studentDTO);
    }
}
