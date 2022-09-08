package edu.miu.phase2.dto;



import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {
    //id, firstName, lastName, email, major, gpa, and coursesTaken
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private float gpa;
    private List<CourseDto> coursesTaken;
}
