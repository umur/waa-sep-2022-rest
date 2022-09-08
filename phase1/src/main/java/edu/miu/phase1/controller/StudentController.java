package edu.miu.phase1.controller;

import edu.miu.phase1.entity.Course;
import edu.miu.phase1.entity.Student;
import edu.miu.phase1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable int id) {
        return studentService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

    @PutMapping({"/{id}"})
    public void update(@PathVariable int id, @RequestBody Student student) {
        studentService.update(id,student);
    }

    // Get student by major
    @GetMapping("/filter")
   public List<Student> getStudentsByMajor(@RequestParam (required = true) String major ){
    return studentService.getStudentsByMajor(major);
   }

   // Get all the courses of the student with ID
    @GetMapping("/{studentId}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int studentId){
        return studentService.getCoursesByStudentId(studentId);
    }


}
