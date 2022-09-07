package henry.phaseii.service.impl;

import henry.phaseii.dto.CourseDto;
import henry.phaseii.entity.Course;
import henry.phaseii.repo.CourseRepo;
import henry.phaseii.service.CourseService;
import henry.phaseii.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private StudentService studentService;

    @Override
    public void save(CourseDto courseDto) {
        courseRepo.add(new Course(courseDto.getId(), courseDto.getName(), courseDto.getCode()));
    }

    @Override
    public List<CourseDto> findAll() {
        List<Course> courses = courseRepo.getCourses();
        List<CourseDto> courseDtos = new ArrayList<>();
        courses.forEach(c -> {
            courseDtos.add(new CourseDto(c.getId(), c.getName(), c.getCode()));
        });

        return courseDtos;
    }

    @Override
    public void update(int courseId, CourseDto courseDto) {
        Course course = new Course(courseDto.getId(), courseDto.getName(), courseDto.getCode());
        courseRepo.update(courseId, course);
        studentService.updateCourse(courseId, course);
    }

    @Override
    public CourseDto delete(int courseId) {
        studentService.deleteCourse(courseId);
        Course course = courseRepo.delete(courseId);
        return new CourseDto(course.getId(), course.getName(), course.getCode());
    }
}
