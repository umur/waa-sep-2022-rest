package miu.edu.restfuldemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private int id;
    private String name;
    private String code;
}
