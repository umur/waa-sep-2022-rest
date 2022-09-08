package miu.edu.lab2.PhaseOne.Controller;

import miu.edu.lab2.PhaseOne.Domain.Course;
import miu.edu.lab2.PhaseOne.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Courses")
public class CourseController {


    @Autowired
    CourseService courseService;

    @GetMapping
    public List<Course> findall(){
     return    courseService.findAll();

    }

    @GetMapping("/{Id}")
    public Course findById(@PathVariable int id ){
        return courseService.findById(id);
    }

    @PostMapping

    public void createCourse(@RequestBody Course course){
        courseService.create(course);
    }

    @PutMapping("/{id}")

    public void updateCourse(@PathVariable int id , Course course){
        courseService.update(id,course);
    }

    @DeleteMapping("/{id}")

    public void deleteCourse(@PathVariable int id ){
        courseService.delete(id);
    }

}
