package org.lab2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.lab2.entity.Course;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    private List<Course> coursesTaken;
}
