package edu.miu.day2backend.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {
    private int id;
    private String name;
    private String code;
}
