package edu.miu.restws.controller;

import edu.miu.restws.dto.CourseDto;
import edu.miu.restws.dto.StudentDto;
import edu.miu.restws.service.CourseService;
import edu.miu.restws.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    private final CourseService courseService;

    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.findAllStudents();
    }

    @GetMapping("/search")
    public List<StudentDto> searchByMajor(@RequestParam String major) {
        return studentService.findStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable("id") int studentId) {
        return courseService.findCoursesByStudentId(studentId);
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable int id) {
        return studentService.findById(id);
    }

    @PostMapping
    public void add(@RequestBody StudentDto studentDto) {
        studentService.save(studentDto);
    }

    @PutMapping
    public void update(@RequestBody StudentDto studentDto) {
        studentService.update(studentDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }
}
