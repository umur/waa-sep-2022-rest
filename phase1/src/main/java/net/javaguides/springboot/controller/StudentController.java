package net.javaguides.springboot.controller;

import net.javaguides.springboot.entity.Course;
import net.javaguides.springboot.entity.Student;
import net.javaguides.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    private List<Student> findAllStudents(){
        return studentService.findAll();
    }
    @PostMapping
    public Student create(@RequestBody Student student){
        studentService.create(student);
        return student;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable int id){
         studentService.delete(id);
         return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/search")
    public List<Student> getStudentsByMalor(@RequestParam(name="major") String major){
        return studentService.findByMajor(major);
    }

    @GetMapping("{id}/course")
    public List<Course> getCourseByStudentId(@PathVariable  int id){
        return studentService.findByIdCourse(id);
    }


}
