package edu.miu.restphaseIV.repository;

import edu.miu.restphaseIV.entity.Course;
import edu.miu.restphaseIV.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private static List<Course> courses = new ArrayList<>();

    static {
        courses = new ArrayList<>();
        Course course = new Course();
        course.setId(1);
        course.setName("Modern Programming Practices");
        course.setCode("CS401");
        courses.add(course);

        course = new Course();
        course.setId(2);
        course.setName("Web Application Programming");
        course.setCode("CS472");
        courses.add(course);

        course = new Course();
        course.setId(3);
        course.setName("Web Application Architecture");
        course.setCode("CS545");
        courses.add(course);
    }

    public Course save(Course course) {
        Boolean notExists = courses.stream().noneMatch(c -> c.getId() == course.getId());
        if(notExists) {
            courses.add(course);
            return course;
        }
        return null;
    }

    public void update(Course course) {
        Course existingCourse = this.getById(course.getId());
        if(existingCourse != null) {
            courses.set(courses.indexOf(existingCourse), course);
        }
    }

    public Course delete(int id) {
        Course course = getById(id);
        if(course != null){
            courses.remove(course);
        }
        return course;
    }

    public Course getById(int id) {
        return courses.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public List<Course> getAll() {
        return courses.stream().filter(s -> !s.isDeleted()).collect(Collectors.toList());
    }

}
