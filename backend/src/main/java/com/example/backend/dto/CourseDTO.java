package com.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@Data
public class CourseDTO {
    private int id;
    private String name;
    private String code;
}
