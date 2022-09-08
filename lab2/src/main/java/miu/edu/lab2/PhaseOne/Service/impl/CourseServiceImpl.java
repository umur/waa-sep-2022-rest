package miu.edu.lab2.PhaseOne.Service.impl;

import miu.edu.lab2.PhaseOne.Domain.Course;
import miu.edu.lab2.PhaseOne.Repository.CourseRepository;
import miu.edu.lab2.PhaseOne.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;


    @Override
    public Course findById(int id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void create(Course course) {
         courseRepository.save(course);
    }

    @Override
    public void update(int id, Course course) {
        courseRepository.update(id,course);

    }

    @Override
    public void delete(int id) {
     courseRepository.delete(id);
    }
}
