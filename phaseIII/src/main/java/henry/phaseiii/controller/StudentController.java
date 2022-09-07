package henry.phaseiii.controller;

import henry.phaseiii.dto.CourseDto;
import henry.phaseiii.dto.StudentDto;
import henry.phaseiii.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.findAll();
    }

    @GetMapping("/{studentId}/courses")
    public List<CourseDto> getCourses(@PathVariable int studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }

    @GetMapping("/search")
    public List<StudentDto> getByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @PostMapping
    public StudentDto save(@RequestBody StudentDto student) {
        return studentService.save(student);
    }

    @PostMapping("/{studentId}/courses")
    public void takeCourse(@PathVariable int studentId, @RequestBody CourseDto course) {
        studentService.takeCourse(studentId, course);
    }

    @PutMapping("/{studentId}")
    public StudentDto update(@PathVariable int studentId, @RequestBody StudentDto student) {
        return studentService.update(studentId, student);
    }

    @DeleteMapping("/{studentId}")
    public StudentDto delete(@PathVariable int studentId) {
        return studentService.delete(studentId);
    }
}
