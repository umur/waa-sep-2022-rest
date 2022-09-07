package Com.Restful.Ass2.Repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import Com.Restful.Ass2.Models.Course;

@Repository
public class CourseRepo {
	
	private Map<Integer, Course> courses = new HashMap();
	
	//create course
	public Course createCourse(Course course) {
		return courses.put(course.id, course);
	}
	
	//read course
	public Course findOne(int id) {
		return courses.get(id);
	}
	
	//update with given course
	public Course updateCourse(Course course) {
		return courses.put(course.id, course);
	}
	
	//delete course given id	
	public void deleteCourse(int id) {
		courses.remove(id);
	}
	
	//return all courses
	public List<Course> findAllCourses(){
		 return courses.values().stream().collect(Collectors.toList());
	}
}
