package waa.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import waa.lab2.dto.CourseDto;
import waa.lab2.dto.StudentDto;
import waa.lab2.service.StudentService;

import java.util.List;


@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public void saveStudent(@RequestBody StudentDto studentDto){
        studentService.save(studentDto);

    }

    @GetMapping("/students/{id}")
    public StudentDto getStudentById(@PathVariable Integer id){
        StudentDto studentDto=studentService.getStudentByID(id);
        return studentDto;
    }

    @GetMapping("/students")
    public List<StudentDto> getAllStudent(){
        List<StudentDto> listOfStudents =studentService.getAllStudents();
        return listOfStudents;
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable Integer id){

        studentService.deleteStudentById(id);

    }

    @PutMapping("/students/{id}")
    public void updateStudent (@PathVariable Integer id, @RequestBody StudentDto studentDto){

        studentService.updateStudent(id, studentDto);

    }
    
    @GetMapping("/major/{major}")
    public List<StudentDto> getStudentsByMajor(@PathVariable String major){
        
        return studentService.getStudentByMajor(major);
    }
@GetMapping("students/{id}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable  int id){

        return studentService.getCoursesByStudentId(id);

}

}
