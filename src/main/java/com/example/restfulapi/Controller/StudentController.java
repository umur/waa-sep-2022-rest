package com.example.restfulapi.Controller;

import com.example.restfulapi.Model.Course;
import com.example.restfulapi.Model.Student;
import com.example.restfulapi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
       return studentService.findAll();
    }

    @PostMapping
    public void saveStudent(@RequestBody Student student){
        studentService.add(student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }
    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student){
        studentService.updateStudent(id,student);
    }

    @GetMapping("/filter")
    public List<Student> getAllStudentsByMajor(@RequestParam String major ){
        return studentService.getAllStudentsByMajor(major);
    }

    @GetMapping("/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable int id){
       return studentService.getAllCoursesByStudentId(id);
    }


}
