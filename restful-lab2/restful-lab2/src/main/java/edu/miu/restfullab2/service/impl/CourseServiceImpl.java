package edu.miu.restfullab2.service.impl;

import edu.miu.restfullab2.entity.Course;
import edu.miu.restfullab2.repo.CourseRepo;
import edu.miu.restfullab2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public void save(Course c){
        courseRepo.add(c);
    }

    @Override
    public List<Course> findAll() {
        return courseRepo.getCourses();
    }

    @Override
    public Course getById(int id) {
        return courseRepo.getById(id);
    }

    @Override
    public Course createCourse(Course course) {
        System.out.println(course);
        return courseRepo.createCourse(course);
    }

    @Override
    public int deleteCourse(int id) {
        return courseRepo.deleteCourse(id);
    }

    @Override
    public Course updateCourse(int id, Course course) {
        return courseRepo.updateCourse(id, course);
    }

}
