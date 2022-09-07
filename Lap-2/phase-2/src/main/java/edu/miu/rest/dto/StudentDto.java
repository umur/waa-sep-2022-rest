package edu.miu.rest.dto;

import edu.miu.rest.entity.Course;
import edu.miu.rest.entity.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Component
public class StudentDto {
@Autowired
private CourseDto courseDto;

        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String major;
        private List<CourseDto> Courses;
        private Double gpa;

    public StudentDto toDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setMajor(student.getMajor());
        dto.setEmail(student.getEmail());
        var n = student.getCourses();
        for (Course c : n) {
            courseDto.toDto(c);
        }

        return dto;
    }


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

    public Student toEntity(){
        Student student  = new Student();
        student.setId(this.id);
        student.setFirstName(this.firstName);
        student.setLastName(this.lastName);
        student.setEmail(this.email);
        var n = this.Courses;
        for (CourseDto c : n) {
            student.setCourses((List<Course>) courseDto.toEntity(c));
        }
        student.setGpa(this.gpa);

        return student;
    }

}

