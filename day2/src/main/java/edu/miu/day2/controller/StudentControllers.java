package edu.miu.day2.controller;

import edu.miu.day2.entity.Course;
import edu.miu.day2.entity.Student;
import edu.miu.day2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentControllers {
    private final StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createAStudent(student);

    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") Long id){
        return studentService.getAStudent(id);
    }
    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable("id") int studentId){
        return studentService.getAllCourseByStudentId(studentId);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }


}
