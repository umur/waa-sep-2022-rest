package henry.phaseii.controller;

import henry.phaseii.dto.CourseDto;
import henry.phaseii.dto.StudentDto;
import henry.phaseii.service.StudentService;
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
    public void save(@RequestBody StudentDto student) {
        studentService.save(student);
    }

    @PostMapping("/{studentId}/courses")
    public void takeCourse(@PathVariable int studentId, @RequestBody CourseDto course) {
        studentService.takeCourse(studentId, course);
    }

    @PutMapping("/{studentId}")
    public void update(@PathVariable int studentId, @RequestBody StudentDto student) {
        studentService.update(studentId, student);
    }

    @DeleteMapping("/{studentId}")
    public StudentDto delete(@PathVariable int studentId) {
        return studentService.delete(studentId);
    }
}
