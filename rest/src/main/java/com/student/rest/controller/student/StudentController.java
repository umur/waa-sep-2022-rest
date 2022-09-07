package com.student.rest.controller.student;

import com.student.rest.exceptions.student.StudentAlreadyExistsException;
import com.student.rest.exceptions.student.StudentDoesNotExistException;
import com.student.rest.model.Course;
import com.student.rest.model.Student;
import com.student.rest.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    // /course GET
    @GetMapping
    public List<Student> getAll() {
        return studentService.get();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) throws StudentAlreadyExistsException {
        studentService.add(student);
    }

    @PutMapping("/{id}")
    public boolean updateStudent(Student student) throws StudentDoesNotExistException {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable int id) throws StudentDoesNotExistException {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/course/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }

}
