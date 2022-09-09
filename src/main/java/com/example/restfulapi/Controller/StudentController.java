package com.example.restfulapi.Controller;

import com.example.restfulapi.DTO.CourseDTO;
import com.example.restfulapi.DTO.StudentDTO;
import com.example.restfulapi.Model.Course;
import com.example.restfulapi.Model.Student;
import com.example.restfulapi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<StudentDTO> getAllStudents(){
        return studentService.findAll();
    }

    @PostMapping
    public void saveStudent(@RequestBody StudentDTO student){
        studentService.add(student);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).build();
    }
    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody StudentDTO student){
        studentService.updateStudent(id,student);
    }

    @GetMapping("/filter")
    public List<StudentDTO> getAllStudentsByMajor(@RequestParam String major ){
        return studentService.getAllStudentsByMajor(major);
    }
    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable int id){
        return studentService.findStudentById(id);
    }




    @GetMapping("/{id}/courses")
    public List<CourseDTO> getCoursesByStudentId(@PathVariable int id){
        return studentService.getAllCoursesByStudentId(id);
    }
}
