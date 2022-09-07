package henry.phasei.controller;

import henry.phasei.entity.Course;
import henry.phasei.entity.Student;
import henry.phasei.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @GetMapping("/{studentId}/courses")
    public List<Course> getCourses(@PathVariable int studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }

    @GetMapping("/search")
    public List<Student> getByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }

    @PostMapping("/{studentId}/courses")
    public void takeCourse(@PathVariable int studentId, @RequestBody Course course) {
        studentService.takeCourse(studentId, course);
    }

    @PutMapping("/{studentId}")
    public void update(@PathVariable int studentId, @RequestBody Student student) {
        studentService.update(studentId, student);
    }

    @DeleteMapping("/{studentId}")
    public Student delete(@PathVariable int studentId) {
        return studentService.delete(studentId);
    }
}
