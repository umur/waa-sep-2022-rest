package edu.miu.phase3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDto {
    //id, name, code
    private int id;
    private String name;
    private String code;
}
