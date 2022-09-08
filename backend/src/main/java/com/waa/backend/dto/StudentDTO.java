package com.waa.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private String firstName;
    private String lastName;
    private String major;
    private String email;
    private float gpa;
}
