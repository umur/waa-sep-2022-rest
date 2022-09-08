package edu.miu.phase1.service.impl;

import edu.miu.phase1.domain.Course;
import edu.miu.phase1.repo.CourseRepo;
import edu.miu.phase1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Course save(Course course) {
        return courseRepo.add(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course findById(int id) {
        return courseRepo.getCourseById(id);
    }

    @Override
    public Course update(int id, Course course) {
        return courseRepo.updateCourse(id, course);
    }

    @Override
    public Course delete(int id) {
        return courseRepo.deleteCourseById(id);
    }
}
