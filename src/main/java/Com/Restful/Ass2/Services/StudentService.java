package Com.Restful.Ass2.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import Com.Restful.Ass2.Models.Course;
import Com.Restful.Ass2.Models.Student;
import Com.Restful.Ass2.Repo.StudentRepo;

@Service
public class StudentService {
	private StudentRepo studentRepo;
	
	public StudentService(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	//create student
	public Student createStudent(Student student) {
		return this.studentRepo.createStudent(student);
	}
	//read student by id
	public Student findOneStudent(int id) {
		return this.studentRepo.findStudentOne(id);
	}
	
	//update student
	public Student updateStudent(Student student) {
		return this.studentRepo.createStudent(student);
	}
	
	//delete student by id
	public void deleteStudent(int id) {
		this.studentRepo.deleteStudentOne(id);
	}
	
	//get student by major
	public List<Student> getStudentByMajor(String major){
		return this.studentRepo.getStudentsByMajor(major);
	}
	//get courses by studnet id
	public List<Course> getCoursesByStudentId(int id){
		return this.studentRepo.getCoursesByStudentId(id);
	}
}
