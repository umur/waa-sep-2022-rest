package com.gyawalirajiv.rest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Integer gpa;
    private List<Course> courseList;

}
