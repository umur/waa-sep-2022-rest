package miu.edu.restfuldemo.service.implementation;

import miu.edu.restfuldemo.entity.Course;
import miu.edu.restfuldemo.dto.CourseDTO;
import miu.edu.restfuldemo.repository.CourseRepository;
import miu.edu.restfuldemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


@Service
public class CourseServiceImplementation implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImplementation(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void save(CourseDTO courseDTO) {
        Course course = new Course(
                courseDTO.getId(),
                courseDTO.getName(),
                courseDTO.getCode()
        );

        courseRepository.add(course);
    }

    public List<CourseDTO> findAll() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> courseDTOs = new ArrayList<>();

        courses.forEach(course -> {
            CourseDTO courseDTO = new CourseDTO(
                    course.getId(),
                    course.getName(),
                    course.getCode()
            );
            courseDTOs.add(courseDTO);
        });

        return courseDTOs;
    }

    public CourseDTO getById(Integer id) {
        Course course = courseRepository.getById(id);
        CourseDTO courseDTO = new CourseDTO(
                course.getId(),
                course.getName(),
                course.getCode()
        );
        return courseDTO;
    }

    public void update(Integer id, CourseDTO courseDTO) {
        Course course = new Course(
                courseDTO.getId(),
                courseDTO.getName(),
                courseDTO.getCode()
        );
        courseRepository.update(id, course);
    }

    public void delete(Integer id) {
        courseRepository.delete(id);
    }
}
