package waa.lab2.dto;

import lombok.Data;
import waa.lab2.entity.CourseEntity;

import java.util.List;
@Data

public class StudentDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<CourseEntity> coursesTaken;




}
