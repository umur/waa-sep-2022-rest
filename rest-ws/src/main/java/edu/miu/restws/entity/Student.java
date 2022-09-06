package edu.miu.restws.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Student {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String major;

    private float gpa;

    public Student(Integer id, String firstName, String lastName, String email, String major, float gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
    }

    @EqualsAndHashCode.Exclude
    private List<Course> coursesTaken = new ArrayList<>();

}
