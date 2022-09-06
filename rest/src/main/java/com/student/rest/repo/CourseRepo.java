package com.student.rest.repo;

import com.student.rest.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private static int id = 4;
    private static List<Course> courses = new ArrayList<>() {{
        new Course(1, "FPP", "CS401");
        new Course(2, "MPP", "CS421");
        new Course(3, "WAP", "CS431");
        new Course(4, "WAA", "CS501");
    }};

    public void add(Course course) {
        course.setId(id++);
        courses.add(course);
    }

    public List<Course> list () {
        return courses;
    }

    public boolean update (Course course) {
        int index = 0;
        for (Course c : courses) {
            if (c.getId() == course.getId()) {
                courses.set(index, course);
                return true;
            }
            index++;
        }
        return false;
    }

    public boolean delete (int id) {
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
}
