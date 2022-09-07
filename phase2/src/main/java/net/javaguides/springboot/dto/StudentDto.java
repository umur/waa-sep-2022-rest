package net.javaguides.springboot.dto;

import lombok.Data;
import net.javaguides.springboot.entity.Course;
import net.javaguides.springboot.entity.Student;

import java.util.List;
@Data
public class StudentDto {
    private int id;
    private String fName;
    private String lName;
    private String email;
    private String major;
    private List<Course> courseTaken;
    private double gpa;


    public StudentDto toDto(Student student){
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setFName(student.getFistName());
        dto.setLName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setMajor(student.getMajor());
        dto.setCourseTaken(student.getCourseTaken());
        dto.setGpa(student.getGpa());
        return dto;
    }

    public Student toEntity() {
        Student student = new Student();
        student.setId(this.id);
        student.setFistName(this.fName);
        student.setMajor(this.major);
        student.setLastName(this.lName);
        student.setEmail(this.email);
        student.setCourseTaken(this.courseTaken);
        student.setGpa(this.gpa);
        return student;
    }

}
