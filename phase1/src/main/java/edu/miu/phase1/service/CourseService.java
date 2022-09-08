package edu.miu.phase1.service;

import edu.miu.phase1.domain.Course;
import java.util.List;
import java.util.Map;

public interface CourseService {
    Course save(Course course);

    List<Course> findAll();

    Course findById(int id);

    Course update(int id, Course course);

    Course delete(int id);
}
