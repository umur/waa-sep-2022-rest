package edu.miu.rest.dto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Component
public class StudentDto {
      private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String major;
        private List<CourseDto> Courses;
        private Double gpa;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setCourses(List<CourseDto> courses) {
        Courses = courses;
    }

    public List<CourseDto> getCourses() {
        return Courses;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

}

