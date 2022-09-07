package net.javaguides.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String fistName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> courseTaken;
    private double gpa;



}
