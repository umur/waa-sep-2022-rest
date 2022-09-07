package miu.edu.restfuldemo.controller;

import miu.edu.restfuldemo.entity.Course;
import miu.edu.restfuldemo.entity.Student;
import miu.edu.restfuldemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id) {
        return studentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }

    @GetMapping("/filter")
    public List<Student> getStudentByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable Integer id) {
        return studentService.getCoursesByStudentId(id);
    }
}
