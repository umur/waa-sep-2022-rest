package edu.miu.restws.dto;

import lombok.Data;

@Data
public class StudentDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String major;

    private float gpa;
}
