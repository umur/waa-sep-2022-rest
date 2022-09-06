package org.lab2.controller;

import lombok.RequiredArgsConstructor;
import org.lab2.dto.CourseDTO;
import org.lab2.dto.StudentDTO;
import org.lab2.entity.Course;
import org.lab2.service.impl.CourseServiceImpl;
import org.lab2.service.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private StudentServiceImpl studentService;


    @GetMapping
    public List<StudentDTO> findAll(){
        return  studentService.findAll();
    }

    @DeleteMapping("/{id}")
    public  void delete(@PathVariable Integer id){
        studentService.delete(id);
    }
    @PutMapping()
    public  StudentDTO updateCourse(@RequestBody StudentDTO student){
        return studentService.update(student);
    }

    @PostMapping()
    public void saveCourse(@RequestBody StudentDTO student){
        studentService.save(student);
    }

    @GetMapping("/filter")
    public List<StudentDTO> studentMajors(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDTO> studentCourses(@PathVariable Integer id){
        return  studentService.getCoursesByStudentId(id);
    }
}
