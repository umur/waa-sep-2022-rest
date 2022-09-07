package edu.miu.restws.mapper;

import edu.miu.restws.dto.CourseDto;
import edu.miu.restws.entity.Course;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseMapper {

    private final ModelMapper modelMapper;

    public CourseDto toDto(Course course) {
        return modelMapper.map(course, CourseDto.class);
    }

    public List<CourseDto> toDtos(List<Course> courses) {
        return courses.stream()
                .map(this::toDto)
                .toList();
    }

    public Course toEntity(CourseDto courseDto) {
        return modelMapper.map(courseDto, Course.class);
    }

    public List<Course> toEntities(List<CourseDto> courseDtos) {
        return courseDtos.stream()
                .map(this::toEntity)
                .toList();
    }
}