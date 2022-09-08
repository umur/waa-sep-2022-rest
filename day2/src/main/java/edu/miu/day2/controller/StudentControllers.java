package edu.miu.day2.controller;

import edu.miu.day2.entity.Course;
import edu.miu.day2.entity.DTO.CourseDTO;
import edu.miu.day2.entity.DTO.StudentDTO;
import edu.miu.day2.entity.Student;
import edu.miu.day2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/students")
public class StudentControllers {
    private final StudentService studentService;

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO student){
        return studentService.createAStudent(student);

    }

    @GetMapping
    public List<StudentDTO> getStudents(){

        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable("id") Long id){
        return studentService.getAStudent(id);
    }
    @GetMapping("/{id}/courses")
    public List<CourseDTO> getCoursesByStudentId(@PathVariable("id") int studentId){
        return studentService.getAllCourseByStudentId(studentId);
    }

    @PutMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable Long id, @RequestBody StudentDTO student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public StudentDTO deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }


}
