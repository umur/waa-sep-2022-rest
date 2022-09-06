package edu.miu.phase1.service;

import edu.miu.phase1.entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> findAll();
    public Course getByCourseCode(String code);
    public void save(Course course);

    public void delete(int id);
    public void update(int id, Course course);
}
