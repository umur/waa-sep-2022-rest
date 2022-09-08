package com.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@Data
public class StudentDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private double gpa;
}
