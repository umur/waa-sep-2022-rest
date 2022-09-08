package com.waa.backend.repo;

import com.waa.backend.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private static List<Course> courses = new ArrayList<>();
    private static int currentId = 3;

    static {
        Course course = new Course(1, "Web App Arch", "WAA");
        Course course1 = new Course(2, "Advanced SE Devt", "ASD");
        Course course2 = new Course(3, "Enterprise Arch", "EA");

        courses.add(course);
        courses.add(course1);
        courses.add(course2);
    }

    public void save(Course course) {
        course.setId(currentId++);
        courses.add(course);
    }

    public List<Course> findAll() {
        return courses;
    }

    public Course findById(int id) {
        return courses.stream().filter(course -> course.getId() == id).findFirst().get();
    }

    public void deleteCourse(Course course) {
        courses.remove(course);
    }
}
