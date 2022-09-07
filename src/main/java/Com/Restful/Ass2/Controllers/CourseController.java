package Com.Restful.Ass2.Controllers;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import Com.Restful.Ass2.Models.Course;
import Com.Restful.Ass2.Services.CourseService;

@RestController
@RequestMapping("courses")

public class CourseController {
	private CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	//create course
	@PostMapping
	public Course createCourse(@RequestBody Course course) {
		return this.courseService.createCourse(course);
	}
	
	//read given id
	@GetMapping("{/id}")
	public Course readCourse(@PathVariable int id) {
		return this.courseService.findOne(id);
	}
	
	//update course
	@PutMapping
	public Course updateCourse(@RequestBody Course course) {
		return this.updateCourse(course);
	}
	
	//delete given id
	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable int id) {
		this.courseService.deleteCourse(id);
	}
	
	//read all courses
	@GetMapping
	public List<Course> findAll(){
		return this.courseService.findAll();
	}
}
