package edu.miu.day2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Integer gpa;
    private String courseTaken;

    private List<Course> courses;



}
