package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private double gpa;
    private List<Course> courses = new ArrayList<>();
}
