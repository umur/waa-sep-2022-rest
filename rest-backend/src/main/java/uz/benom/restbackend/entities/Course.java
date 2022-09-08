package uz.benom.restbackend.entities;

import lombok.Data;
import lombok.Getter;

@Data
public class Course {
    private Integer id;
    private String name;
    private String code;
}
