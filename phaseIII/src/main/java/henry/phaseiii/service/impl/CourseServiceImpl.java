package henry.phaseiii.service.impl;

import henry.phaseiii.dto.CourseDto;
import henry.phaseiii.entity.Course;
import henry.phaseiii.repo.CourseRepo;
import henry.phaseiii.service.CourseService;
import henry.phaseiii.service.StudentService;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(CourseDto courseDto) {
        courseRepo.add(modelMapper.map(courseDto, Course.class));
    }

    @Override
    public List<CourseDto> findAll() {
        List<Course> courses = courseRepo.getCourses();
        List<CourseDto> courseDtos = new ArrayList<>();
        courses.forEach(c -> {
            courseDtos.add(modelMapper.map(c, CourseDto.class));
        });

        return courseDtos;
    }

    @Override
    public void update(int courseId, CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        courseRepo.update(courseId, course);
        studentService.updateCourse(courseId, course);
    }

    @Override
    public CourseDto delete(int courseId) {
        studentService.deleteCourse(courseId);
        Course course = courseRepo.delete(courseId);
        return modelMapper.map(course, CourseDto.class);
    }
}
