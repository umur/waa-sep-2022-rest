package com.gyawalirajiv.rest.models.DTOs;

import com.gyawalirajiv.rest.models.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Integer gpa;
    private List<Course> courseList;

}
