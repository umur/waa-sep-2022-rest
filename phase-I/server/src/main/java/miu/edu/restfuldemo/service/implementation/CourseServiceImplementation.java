package miu.edu.restfuldemo.service.implementation;

import miu.edu.restfuldemo.entity.Course;
import miu.edu.restfuldemo.repository.CourseRepository;
import miu.edu.restfuldemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CourseServiceImplementation implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImplementation(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void save(Course course) {
        courseRepository.add(course);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course getById(Integer id) {
        return courseRepository.getById(id);
    }

    public void update(Integer id, Course course) {
        courseRepository.update(id, course);
    }

    public void delete(Integer id) {
        courseRepository.delete(id);
    }
}
