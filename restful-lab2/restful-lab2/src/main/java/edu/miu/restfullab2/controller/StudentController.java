package edu.miu.restfullab2.controller;

import edu.miu.restfullab2.dto.StudentDto;
import edu.miu.restfullab2.entity.Student;
import edu.miu.restfullab2.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/students")
@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public List<StudentDto> findAll(){
        return studentService.findAll();
    }
    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable int id){
       return studentService.getById(id) ;
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @DeleteMapping("/{id}")
    public int deleteStudent(@PathVariable int id){
        return studentService.deleteStudentById(id);
    }
    @PutMapping("{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
    @GetMapping("/filter/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }


}
