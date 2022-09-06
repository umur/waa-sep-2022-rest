package edu.miu.phase1.service.impl;

import edu.miu.phase1.entity.Course;
import edu.miu.phase1.repo.CourseRepo;
import edu.miu.phase1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Override
    public List<Course> findAll() {
        return courseRepo.getAll();
    }

    @Override
    public Course getByCourseCode(String code) {
        return courseRepo.findByCode(code);
    }

    @Override
    public void save(Course course) {
        courseRepo.save(course);
    }

    @Override
    public void delete(int id) {
        courseRepo.deleteCourse(id);
    }

    @Override
    public void update(int id, Course course) {
        courseRepo.updateCourse(id,course);
    }
}
