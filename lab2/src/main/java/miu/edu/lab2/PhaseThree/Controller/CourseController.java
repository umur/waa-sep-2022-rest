package miu.edu.lab2.PhaseThree.Controller;

import miu.edu.lab2.PhaseThree.Dto.CourseDTO;
import miu.edu.lab2.PhaseThree.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Courses")
public class CourseController {


    @Autowired
    CourseService courseService;

    @GetMapping
    public List<CourseDTO> findall(){
     return    courseService.findAll();

    }

    @GetMapping("/{Id}")
    public CourseDTO findById(@PathVariable int id ){
        return courseService.findById(id);
    }

    @PostMapping

    public void createCourse(@RequestBody CourseDTO course){
        courseService.create(course);
    }

    @PutMapping("/{id}")

    public void updateCourse(@PathVariable int id , CourseDTO course){
        courseService.update(id,course);
    }

    @DeleteMapping("/{id}")

    public void deleteCourse(@PathVariable int id ){
        courseService.delete(id);
    }

}
