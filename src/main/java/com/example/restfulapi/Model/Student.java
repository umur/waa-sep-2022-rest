package com.example.restfulapi.Model;

import lombok.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double GPA;
    private List<Course> courseTaken;
}
