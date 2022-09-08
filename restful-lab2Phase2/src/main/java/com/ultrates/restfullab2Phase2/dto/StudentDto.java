package com.ultrates.restfullab2Phase2.dto;


import com.ultrates.restfullab2Phase2.model.Course;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;
    private float gpa;

}
