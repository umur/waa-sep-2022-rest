package edu.miu.restfuldemo.entity;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private int gpa;
    private List<Integer> coursesTaken;

}
