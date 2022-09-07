package com.gyawalirajiv.rest.controller;

import com.gyawalirajiv.rest.models.Course;
import com.gyawalirajiv.rest.models.DTOs.CourseDTO;
import com.gyawalirajiv.rest.models.DTOs.StudentDTO;
import com.gyawalirajiv.rest.models.Student;
import com.gyawalirajiv.rest.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO student){
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<StudentDTO> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable("id") Long id){
        return studentService.getStudent(id);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDTO> getCoursesByStudentId(@PathVariable("id") int studentId){
        return studentService.getCoursesByStudentId(studentId);
    }

    @GetMapping("/filter")
    public List<StudentDTO> getStudentsByMajor(@RequestParam("major") String major){
        return studentService.getStudentsByMajor(major);
    }

    @PutMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable Long id, @RequestBody StudentDTO student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public StudentDTO deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

}
