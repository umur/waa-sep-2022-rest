package miu.rest.service;

import miu.rest.model.Course;
import miu.rest.model.Student;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    void save(Course c);

    List<Course> findAll();

    Course findById(int id);

    void delete(int id);


}
