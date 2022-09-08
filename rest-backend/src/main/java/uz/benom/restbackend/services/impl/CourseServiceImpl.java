package uz.benom.restbackend.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.benom.restbackend.dto.CourseDto;
import uz.benom.restbackend.entities.Course;
import uz.benom.restbackend.exceptions.ResourceNotFound;
import uz.benom.restbackend.repos.CourseRepository;
import uz.benom.restbackend.services.CourseService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;


    @Override
    public CourseDto create(CourseDto dto) {
        Course course = modelMapper.map(dto, Course.class);
        course = courseRepository.add(course);
        return modelMapper.map(course, CourseDto.class);
    }

    @Override
    public CourseDto update(Integer id, CourseDto dto) {
        Optional<Course> updatedCourse = courseRepository.update(id, modelMapper.map(dto, Course.class));
        if (updatedCourse.isPresent()){
            return modelMapper.map(updatedCourse, CourseDto.class);
        }else {
            throw new ResourceNotFound("Course does not exist");
        }
    }

    @Override
    public void delete(Integer id) {
        courseRepository.delete(id);
    }

    @Override
    public CourseDto getOne(Integer id) {
        Optional<Course> optionalCourse =  courseRepository.getOne(id);
        if (optionalCourse.isPresent()){
            return modelMapper.map(optionalCourse, CourseDto.class);
        }else {
            throw new ResourceNotFound("Course does not exist");
        }
    }

    @Override
    public List<CourseDto> getAll() {
        return courseRepository.getAll().stream()
                .map(c -> modelMapper.map(c, CourseDto.class))
                .collect(Collectors.toList());
    }
}
