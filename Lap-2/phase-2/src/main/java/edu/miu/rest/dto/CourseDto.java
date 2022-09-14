package edu.miu.rest.dto;

import edu.miu.rest.entity.Course;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CourseDto {

    private int id;
    private String name;
    private String code;

    public CourseDto toDto(Course course){
        CourseDto dto = new CourseDto();
        dto.setId(course.getId());
        dto.setCode(course.getCode());
        dto.setName(course.getName());
        return dto;
    }

    public Course toEntity(CourseDto c){
        Course course = new Course();
        course.setId(this.id);
        course.setName(this.name);
        course.setCode(this.code);
        return course;
    }

}
