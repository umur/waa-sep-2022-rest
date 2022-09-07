package com.miu.school.controller;

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
    public List<Student> getAllStudents(){
        return studentServiceImp.getAllStudents();
    }
    @PostMapping
    public void saveNewCourse(@RequestBody Student student){
        studentServiceImp.saveNewStudent(student);
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id){
        studentServiceImp.deleteSpecificStudent(id);
    }
    @PutMapping("/{id}")
    public void updateSpecificCourse(@RequestBody Student student,@PathVariable int id){
        System.out.println("here");
        studentServiceImp.updateSpecificCourse(student,id);
    }
    @GetMapping("/filter/{major}")
    @ResponseBody
    public List<Student> getStudentsByMajor(@PathVariable String major){
        System.out.println(major);
        return studentServiceImp.getStudentsByMajor(major);
    }
    @GetMapping("/course/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable int id){
        return studentServiceImp.getCourseByStudentId(id);
    }
}
