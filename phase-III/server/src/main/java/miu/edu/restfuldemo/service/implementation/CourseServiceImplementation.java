package miu.edu.restfuldemo.service.implementation;

import miu.edu.restfuldemo.entity.Course;
import miu.edu.restfuldemo.dto.CourseDTO;
import miu.edu.restfuldemo.repository.CourseRepository;
import miu.edu.restfuldemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.ArrayList;


@Service
public class CourseServiceImplementation implements CourseService {
    private final CourseRepository courseRepository;
    private ModelMapper mapper;

    @Autowired
    public CourseServiceImplementation(CourseRepository courseRepository, ModelMapper mapper) {
        this.courseRepository = courseRepository;
        this.mapper = mapper;
    }

    public void save(CourseDTO courseDTO) {
        var course = mapper.map(courseDTO, Course.class);

        courseRepository.add(course);
    }

    public List<CourseDTO> findAll() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> courseDTOs = new ArrayList<>();

        courses.forEach(course -> {
            var entityDTO = mapper.map(course, CourseDTO.class);
            courseDTOs.add(entityDTO);
        });

        return courseDTOs;
    }

    public CourseDTO getById(Integer id) {
        Course course = courseRepository.getById(id);
        var courseDTO = mapper.map(course, CourseDTO.class);
        return courseDTO;
    }

    public void update(Integer id, CourseDTO courseDTO) {
        ModelMapper mapper = new ModelMapper();
        var course = mapper.map(courseDTO, Course.class);
        courseRepository.update(id, course);
    }

    public void delete(Integer id) {
        courseRepository.delete(id);
    }
}
