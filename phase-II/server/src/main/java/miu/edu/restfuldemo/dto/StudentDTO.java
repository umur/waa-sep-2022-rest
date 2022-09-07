package miu.edu.restfuldemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miu.edu.restfuldemo.entity.Course;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    private ArrayList<Course> coursesTaken;
}
