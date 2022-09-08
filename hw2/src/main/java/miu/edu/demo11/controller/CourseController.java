package miu.edu.demo11.controller;


import lombok.RequiredArgsConstructor;
import miu.edu.demo11.entity.Course;
import miu.edu.demo11.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostRemove;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api.courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course>getCourses(){
        return courseService.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course save(@RequestBody Course body){
        return courseService.save(body);
    }


    @PutMapping
    public Course update(@PathVariable Integer id, @RequestBody Course body){
        return courseService.update(id,body);
    }


    @GetMapping("{id}")
    public Course getCourse(@PathVariable Integer id){
        return courseService.findOne(id);
    }

    @DeleteMapping("{id")
    public void delete(@PathVariable Integer id){
        courseService.delete(id);
    }


}
