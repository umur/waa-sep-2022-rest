package edu.miu.restfuldemo.controller;

import edu.miu.restfuldemo.dto.CourseDto;
import edu.miu.restfuldemo.dto.StudentDto;
import edu.miu.restfuldemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public List<StudentDto> get() {
        return studentService.get();
    }

    @GetMapping("/{id}")
    public StudentDto get(@PathVariable int id) {
        return studentService.get(id);
    }

    @PostMapping()
    public StudentDto post(@RequestBody StudentDto c) {
        return studentService.add(c);
    }

    @PutMapping("/{id}")
    public boolean put(@PathVariable int id, @RequestBody StudentDto c) {
        studentService.update(id, c);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        studentService.delete(id);
        return true;
    }

    @GetMapping("/filter")
    public List<StudentDto> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }

}
