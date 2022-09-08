package com.waa.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDto {
    //id, firstName, lastName, email, major, gpa, and coursesTaken
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;
    private List<CourseDto> coursesTaken;
}
