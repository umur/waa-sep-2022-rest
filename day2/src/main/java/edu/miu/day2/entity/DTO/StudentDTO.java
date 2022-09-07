package edu.miu.day2.entity.DTO;

import edu.miu.day2.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collector;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Integer gpa;
    private String courseTaken;

    private List<Course> courses;



}