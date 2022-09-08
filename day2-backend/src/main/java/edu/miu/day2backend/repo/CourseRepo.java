package edu.miu.day2backend.repo;

import edu.miu.day2backend.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private static List<Course> courses = new ArrayList<>();

    private static int courseId = 4;

    static {
        courses = RepoUtil.getAllCourses();
    }

    public void add(Course c) {
        c.setId(++courseId);
        courses.add(c);
    }

    public Course findById(int id) {
        return courses.stream().filter(c -> c.getId() == id).findFirst().get();
    }

    public void update(Course course, int id) {
        courses.forEach(c -> {
                if (c.getId() == id) {
                    c = course;
                }
        });
    }

    public void delete(int id) {
        courses = courses.stream().filter(c -> c.getId() != id).collect(Collectors.toList());
    }

    public List<Course> findAll() {
        return courses;
    }
}
