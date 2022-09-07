package Com.Restful.Ass2.Services;

import org.springframework.stereotype.Service;
import Com.Restful.Ass2.Models.Course;
import Com.Restful.Ass2.Repo.CourseRepo;
import java.util.*;
@Service
public class CourseService {
	private CourseRepo courseRepo;
	
	public CourseService(CourseRepo courseRepo) {
		this.courseRepo = courseRepo;
	}
	//create course
	public Course createCourse(Course course) {
		return this.createCourse(course);
	}
	
	//read given id
	public Course findOne(int id) {
		return this.courseRepo.findOne(id);
	}
	
	//update given course
	public Course updateCourse(Course course) {
		return this.courseRepo.updateCourse(course);
	}
	
	//delete course given id
	public void deleteCourse(int id) {
		this.courseRepo.deleteCourse(id);
	}
	public List<Course> findAll() {
		return this.courseRepo.findAllCourses();
	}
	
}
