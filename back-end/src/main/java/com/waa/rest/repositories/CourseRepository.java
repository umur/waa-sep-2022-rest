package com.waa.rest.repositories;

import com.waa.rest.models.Course;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {
    private static Map<Integer, Course> courses = new HashMap<>();
    private static AtomicInteger nextCourseId = new AtomicInteger();

    public CourseRepository() {
        courses.put(nextCourseId.incrementAndGet(), new Course(nextCourseId.get(),"English","Eng-101" ));
        courses.put(nextCourseId.incrementAndGet(), new Course(nextCourseId.get(),"Maths", "Math-101"));
    }

    public Course createCourse(Course course) {
        course.setId(nextCourseId.incrementAndGet());
        return courses.putIfAbsent(course.getId(), course);
    }
    public Course findOne(int id) {
        return courses.get(id);
    }
    public void delete(int id) {
        courses.remove(id);
    }
    public Course update(Course course) {
        return courses.put(course.getId(), course);
    }
    public List<Course> findAll() {
        return courses.values().stream().collect(Collectors.toList());
    }

    public Course findByCode(String code) {
        return courses.values()
                .stream()
                .filter(course -> course.getCode().equals(code))
                .findFirst().orElseGet(null);
    }

}
