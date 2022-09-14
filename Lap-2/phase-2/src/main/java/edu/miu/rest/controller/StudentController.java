package edu.miu.rest.controller;
import edu.miu.rest.dto.StudentDto;
import edu.miu.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private  StudentService studentService;

   @Autowired // optional
   public StudentController(StudentService StudentService){
       this.studentService=StudentService;
   }

   // http://localhost:8080/students
    @GetMapping
    public List<StudentDto> findAllStudents() {
       System.out.println("requested");
        return studentService.findAll();
    }
    @GetMapping("/searchByMajor")
    public List<StudentDto> getStudentMajor(@PathVariable String major)
    {
    return studentService.getStudentsByMajor(major);
}
// http://localhost:8080/students?major=Java

    @GetMapping("/search")
    public List<StudentDto> getAllStudentsByMajor(@RequestParam String major){

       return studentService.getStudentsByMajor(major);
    }
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable int id){
        System.out.println("id = " + id);

        return studentService.getById(id);
    }
    @PostMapping
    public void create(@RequestBody StudentDto dt){
        studentService.create(dt);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody StudentDto dto,
                       @PathVariable int id){
       studentService.update(dto,id);

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.DeleteById(id);
    }

    }



