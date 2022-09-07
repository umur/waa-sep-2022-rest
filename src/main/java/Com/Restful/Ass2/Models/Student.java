package Com.Restful.Ass2.Models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
	public int id;
	private String firstName;
	private String lastName;
	private String email;
	public String major;
	private double gpa;
	private List<Course> courseTaken;
	public List<Course> getCourseTaken(){
		return courseTaken;
	}
	public String getMajor() {
		return major;
	}	
}
