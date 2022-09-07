package edu.miu.restws.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private Integer id;

    private String name;

    private String code;

    @EqualsAndHashCode.Exclude
    private List<Student> students = new ArrayList<>();

    public Course(Integer id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
