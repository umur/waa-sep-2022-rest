package miu.edu.restfuldemo.controller;

import miu.edu.restfuldemo.dto.CourseDTO;
import miu.edu.restfuldemo.dto.StudentDTO;
import miu.edu.restfuldemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public void save(@RequestBody StudentDTO studentDTO) {
        studentService.save(studentDTO);
    }

    @GetMapping
    public List<StudentDTO> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable Integer id) {
        return studentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }

    @GetMapping("/filter")
    public List<StudentDTO> getStudentByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDTO> getCoursesByStudentId(@PathVariable Integer id) {
        return studentService.getCoursesByStudentId(id);
    }
}
