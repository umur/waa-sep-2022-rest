package edu.miu.phase1.controller;

import edu.miu.phase1.entity.Course;
import edu.miu.phase1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    public void save(@RequestBody Course course){
        courseService.save(course);
    }
    @GetMapping
    public List<Course> courses(){
      return courseService.findAll();
    }

    @GetMapping("/{code}")
    public Course getByCourseCode(@PathVariable String code){
        return courseService.getByCourseCode(code);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Course course){
         courseService.update(id,course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }

}
