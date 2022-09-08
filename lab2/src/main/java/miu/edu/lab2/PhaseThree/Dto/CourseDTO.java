package miu.edu.lab2.PhaseThree.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miu.edu.lab2.PhaseThree.Domain.Course;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    int id;
    String name;
    String code;
    public static CourseDTO changeTOCourseDTO(Course course){
        CourseDTO courseDT= new CourseDTO(course.getId(),course.getName(),course.getCode());
        return courseDT;
    }

    public static Course changeToCourse(CourseDTO courseDto){
        Course course= new Course(courseDto.getId(),courseDto.getName(),courseDto.getCode());
        return course;
    }
}
