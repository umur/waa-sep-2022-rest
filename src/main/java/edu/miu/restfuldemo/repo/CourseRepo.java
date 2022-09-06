package edu.miu.restfuldemo.repo;

import edu.miu.restfuldemo.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private final List<Course> courses = new ArrayList<>();
    private static int currentIndex = 1;

    public List<Course> getAll() {
        return courses;
    }

    public Course get(int id) {
        return courses.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public Course add(Course c) {
        c.setId(currentIndex++);
        courses.add(c);

        return c;
    }

    public void update(int id, Course c) {
        Course course = get(id);
        if (course != null) {
            course = c;
        }
    }

    public void delete(int id) {
        Course course = get(id);
        if (course != null) {
            courses.remove(course);
        }
    }
}
