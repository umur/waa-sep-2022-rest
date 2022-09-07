package com.miu.school.controller;

import com.miu.school.dto.StudentDTO;
import com.miu.school.entity.Course;
import com.miu.school.entity.Student;
import com.miu.school.service.impl.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentServiceImp studentServiceImp;

    @GetMapping
    @CrossOrigin
    public List<StudentDTO> getAllStudents(){
        return studentServiceImp.getAllStudents();
    }
    @PostMapping
    @CrossOrigin
    public void saveStudent(@RequestBody StudentDTO student){
        studentServiceImp.saveNewStudent(student);
    }
    @DeleteMapping("/{id}")
    @CrossOrigin
    public void deleteStudent(@PathVariable int id){
        studentServiceImp.deleteSpecificStudent(id);
    }
    @PutMapping("/{id}")
    @CrossOrigin
    public void updateSpecificStudent(@RequestBody StudentDTO student, @PathVariable int id){
        System.out.println("here");
        studentServiceImp.updateSpecificCourse(student,id);
    }
    @GetMapping("/filter/{major}")
    @ResponseBody
    @CrossOrigin
    public List<Student> getStudentsByMajor(@PathVariable String major){
        System.out.println(major);
        return studentServiceImp.getStudentsByMajor(major);
    }
    @GetMapping("/course/{id}")
    @CrossOrigin
    public List<Course> getCoursesByStudentId(@PathVariable int id){
        return studentServiceImp.getCourseByStudentId(id);
    }
}
