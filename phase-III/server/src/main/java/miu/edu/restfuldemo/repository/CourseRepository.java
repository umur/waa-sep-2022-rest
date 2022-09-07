package miu.edu.restfuldemo.repository;

import miu.edu.restfuldemo.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>();
    private int currentId = 0;

    public void add(Course course) {
        course.setId(++currentId);
        courses.add(course);
    }

    public List<Course> findAll() {
        return courses;
    }

    public Course getById(Integer id) {
        return courses.stream().filter(course -> course.getId() == id).findFirst().orElse(null);
    }

    public void update(Integer id, Course course) {
        courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .ifPresent(value -> {
                    value.setName(course.getName());
                    value.setCode(course.getCode());
                });
    }

    public void delete(Integer id) {
        courses.removeIf(c -> c.getId() == id);
    }
}
