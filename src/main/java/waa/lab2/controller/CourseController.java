package waa.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import waa.lab2.dto.CourseDto;
import waa.lab2.service.CourseService;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    public CourseService courseService;

    @PostMapping("courses")
    public void saveCourse (@RequestBody CourseDto courseDto){

        courseService.saveCourse(courseDto);


    }

    @GetMapping("courses")
    public List<CourseDto> getAllCourses(){
        return courseService.getAllCourses();

    }

    @GetMapping("courses/{id}")
    public CourseDto getCourseById(@PathVariable int id){

        return courseService.getCourseById(id);
    }
    @DeleteMapping("courses/{id}")
    public void deleteCourseByID (@PathVariable int id){

        courseService.deleteCourseByID(id);
    }

    @PutMapping("courses/{id}")
    public void updateCourseById (@PathVariable int id , @RequestBody CourseDto courseDto){

        courseService.updateCourseById (id, courseDto);
    }


}
