package edu.miu.lab2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private int gpa;
    private List<Integer> coursesTaken;

}
