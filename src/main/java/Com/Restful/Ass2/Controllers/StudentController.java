package Com.Restful.Ass2.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Com.Restful.Ass2.Models.Course;
import Com.Restful.Ass2.Models.Student;
import Com.Restful.Ass2.Services.StudentService;

@RestController
@RequestMapping

public class StudentController {
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return this.studentService.createStudent(student);
	}
	
	@GetMapping("/{id}")
	public Student findOneStudent(@PathVariable int id) {
		return this.studentService.findOneStudent(id);
	}
	
	@PutMapping
	public Student updateStudent(@RequestBody Student student) {
		return this.studentService.updateStudent(student);
	}
	
	@GetMapping("/id")
	public void deleteStudent(@PathVariable int id) {
		this.studentService.deleteStudent(id);
	}
	
	@GetMapping("filter") // ?major=major-name
	public List<Student> getStudentByMajor(@RequestParam String major){
		return this.studentService.getStudentByMajor(major);
	}
	
	@GetMapping("/{id}/course")
	public List<Course> getCourseByStudentId(@PathVariable int id){
		return this.studentService.getCoursesByStudentId(id);
	}
}
