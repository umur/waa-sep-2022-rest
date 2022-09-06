package edu.miu.restfuldemo.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseDto {

    private int id;
    private String name;
    private String code;

}
