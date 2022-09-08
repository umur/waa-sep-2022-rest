package edu.miu.phase3.controller;

import edu.miu.phase3.domain.Student;
import edu.miu.phase3.dto.CourseDto;
import edu.miu.phase3.dto.StudentDto;
import edu.miu.phase3.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentSvc;

    @GetMapping
    public List<StudentDto> findAll() {
        return studentSvc.findAll();
    }

    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable int id) {
        return studentSvc.findById(id);
    }

    @PostMapping
    public StudentDto add(@RequestBody StudentDto student) {
        return studentSvc.save(student);
    }

    @PutMapping("/{id}")
    public StudentDto update(@PathVariable int id, @RequestBody StudentDto student) {
        return studentSvc.update(id, student);
    }

    @DeleteMapping("/{id}")
    public StudentDto delete(@PathVariable int id) {
        return studentSvc.delete(id);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDto> getCourseByStudentId(@PathVariable int id) {
        return studentSvc.getCourseByStudentId(id);
    }

    @GetMapping("/filter")
    public List<StudentDto> getStudentsByMajor(@RequestParam (required = false) String major) {
        return studentSvc.getStudentsByMajor(major);
    }
}
