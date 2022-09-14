package edu.miu.rest.controller;
import edu.miu.rest.entity.Course;
import edu.miu.rest.entity.Student;
import edu.miu.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {



    // injecting Service  object
    private final StudentService studentService;

   @Autowired /// inject in constructor
   public StudentController(StudentService studentService){
       this.studentService=studentService;
   }

   @GetMapping
    public List<Student> findAllProducts() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getById( @PathVariable int id){
        return studentService.getById(id);
   }
    @GetMapping("/searchByMajor")
    public List<Student> getStudentMajor(@PathVariable String major)

    {
       System.out.println(major.toString());
        return  studentService.getStudentsByMajor(major);
    }

    @GetMapping("/courses/{id}")
    public List<Course> getCoursebyStudentId(@PathVariable int id )
    {
        return  studentService.getCoursesByStudentId(id);

    }

    @PostMapping
    public void create(@RequestBody Student std){
       System.out.println(std);
       studentService.create(std);
   }

    @PutMapping("/{id}")
    public void update(@RequestBody Student std,
                       @PathVariable int id){
        System.out.println(std);
       studentService.update(std,id);

    }

    @DeleteMapping("/{id}")
    public String  delete(@PathVariable int id){
       return studentService.DeleteById(id);

    }
}
