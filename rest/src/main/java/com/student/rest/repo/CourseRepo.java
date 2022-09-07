package com.student.rest.repo;

import com.student.rest.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private static int id = 4;
    private static List<Course> courses = new ArrayList<>();

    static {
        Course course1 = new Course(1, "FPP", "CS401");
        Course course2 = new Course(2, "MPP", "CS421");
        Course course3 =  new Course(3, "WAP", "CS431");
        Course course4 =  new Course(4, "WAA", "CS501");

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
    }



    public void addCourse (Course course) {
        id = id + 1;
        course.setId(id);
        courses.add(course);
    }

    public List<Course> getCourses () {
        System.out.println(courses);
        return courses;
    }

    public boolean updateCourse (Course course, int id) {
        int index = 0;
        for (Course c : courses) {
            if (id == course.getId()) {
                courses.set(index, course);
                return true;
            }
            index++;
        }
        return false;
    }

    public boolean deleteCourse (int id) {
        int index = 0;
        for (Course c : courses) {
            if (c.getId() == id) {
                courses.remove(index);
                return true;
            }
            index++;
        }
        return false;
    }

    public boolean exists (int id) {
        return courses.stream().filter(course -> course.getId() == id).collect(Collectors.toList()).size() == 1;
    }
}
