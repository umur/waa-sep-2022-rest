package edu.miu.day2backend.controller;

import edu.miu.day2backend.dto.CourseDto;
import edu.miu.day2backend.dto.StudentDto;
import edu.miu.day2backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable Integer id) {
        return studentService.findById(id);
    }

    @PostMapping
    public void saveStudent(@RequestBody StudentDto studentDto) {
        studentService.add(studentDto);
    }

    @PutMapping("/{id}")
    public void updateStudent(@RequestBody StudentDto studentDto, @PathVariable Integer id) {
        studentService.update(studentDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.delete(id);
    }

    @GetMapping("/filter")
    public List<StudentDto> getStudentsByMajor(@RequestParam String major) {
        return studentService.findStudentsByMajor(major);
    }

    @GetMapping("/{studentId}/coures")
    public List<CourseDto> getCoursesTakenByStudent(@PathVariable Integer studentId) {
        return studentService.findCourseTakenByStudent(studentId);

    }
}
