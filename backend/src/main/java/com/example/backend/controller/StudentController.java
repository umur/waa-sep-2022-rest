package com.example.backend.controller;

import com.example.backend.dto.CourseDTO;
import com.example.backend.dto.StudentDTO;
import com.example.backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentDTO> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id:[0-9]}")
    public StudentDTO getById(@PathVariable int id){
        return studentService.getById(id);
    }

    @DeleteMapping("/{id:[0-9]}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }

    @PutMapping("/{id:[0-9]}")
    public void update(@PathVariable int id, @RequestBody StudentDTO student){
        studentService.update(id, student);
    }

    @PostMapping
    public StudentDTO create(@RequestBody StudentDTO student){
        return studentService.create(student);
    }

    @GetMapping("/filter")
    public List<StudentDTO> getStudentsByMajor(@RequestParam String major){
        return studentService.getByMajor(major);
    }

    @GetMapping("/{id:[0-9]}/courses")
    public List<CourseDTO> getStudentCourses(@PathVariable int id){
        return studentService.getStudentCourses(id);
    }
}
