package edu.miu.phase1.controller;

import edu.miu.phase1.domain.Course;
import edu.miu.phase1.domain.Student;
import edu.miu.phase1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentSvc;

    @GetMapping
    public List<Student> findAll() {
        return studentSvc.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable int id) {
        return studentSvc.findById(id);
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentSvc.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable int id, @RequestBody Student student) {
        return studentSvc.update(id, student);
    }

    @DeleteMapping("/{id}")
    public Student delete(@PathVariable int id) {
        return studentSvc.delete(id);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCourseByStudentId(@PathVariable int id) {
        return studentSvc.getCourseByStudentId(id);
    }

    @GetMapping("/filter")
    public List<Student> getStudentsByMajor(@RequestParam (required = false) String major) {
        return studentSvc.getStudentsByMajor(major);
    }
}
