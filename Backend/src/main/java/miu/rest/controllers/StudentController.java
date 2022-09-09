package miu.rest.controllers;

import lombok.RequiredArgsConstructor;
import miu.rest.Dto.StudentDto;
import miu.rest.model.Course;
import miu.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {


    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> findAll(){
        return studentService.findAll();
    }
    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable int id){
        return studentService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }

    @PostMapping
    public void save(@RequestBody StudentDto s){
        System.out.println("Something");
        studentService.save(s);

    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int id){
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("/filter")
    public List<StudentDto> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable int id, @RequestBody StudentDto s){

        studentService.put(id, s);

    }


}
