package henry.phasei.service;

import henry.phasei.entity.Course;

import java.util.List;

public interface CourseService {
    void save(Course course);
    List<Course> findAll();
    void update(int courseId, Course course);
    Course delete(int courseId);
}
