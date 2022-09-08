package com.ultrates.lab2phase3and4.dto;


import com.ultrates.lab2phase3and4.model.Course;
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
