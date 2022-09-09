package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.StudentDto;
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
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    private List<StudentDto> findAllStudents(){
        return studentService.findAll();
    }

    @PostMapping
    public void create(@RequestBody StudentDto dto){
        studentService.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
         studentService.delete(id);
    }

    @PutMapping("/{id}")
    public StudentDto update(@RequestBody StudentDto studentDto, @PathVariable int id) {
        return studentService.update(studentDto, id);
    }

    @GetMapping("/search")
    public List<StudentDto> getStudentsByMalor(@RequestParam(name="major") String major){
        return studentService.findByMajor(major);
    }

    @GetMapping("{id}/course")
    public List<Course> getCourseByStudentId(@PathVariable  int id){
        return studentService.findCoursesByStudentId(id);
    }


}
