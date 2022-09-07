package edu.miu.restfuldemo.repo;

import edu.miu.restfuldemo.entity.Course;
import edu.miu.restfuldemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Repository
public class CourseRepo {
    private final List<Course> courses = new ArrayList<>();
    private static int currentIndex = 1;

    public Stream<Course> filter(Predicate<? super Course> predicate) {
        return courses.stream().filter(predicate);
    }

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
        courses.stream()
            .filter(d -> d.getId() == id)
            .findAny()
            .ifPresent(d -> {
                d.setName(c.getName());
                d.setCode(c.getCode());
            });
    }

    public void delete(int id) {
        courses.removeIf(c -> c.getId() == id);
    }
}
