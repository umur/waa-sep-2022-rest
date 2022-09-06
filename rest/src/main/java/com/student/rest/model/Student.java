package com.student.rest.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    private List<String> coursesTaken;
}
