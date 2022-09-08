package edu.miu.phase3.repo;


import edu.miu.phase3.domain.Course;
import edu.miu.phase3.dto.CourseDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CourseRepo {
    private static final Map<Integer, Course> courses = new HashMap<>();
    private static int currentId = 2;
    static {
        Course c1 = new Course(1, "Web Application Programming", "WAP");
        Course c2 = new Course(2, "Web Application Architecture", "WAA");

        courses.put(c1.getId(), c1);
        courses.put(c2.getId(), c2);
    }

    public Course add (Course c) {
        int id = currentId + 1;
        c.setId(id);
        courses.put(c.getId(), c);
        return c;
    }

    public List<Course> findAll() {
        return courses.values().stream().toList();
    }

    public Course getCourseById(int id) {
        return courses.get(id);
    }

    public Course updateCourse(int id, Course course) {
        if(courses.containsKey(id)) {
            course.setId(id);
            courses.replace(id, course);
            return course;
        } else {
            return null;
        }
    }

    public Course deleteCourseById(int id) {
        if(courses.containsKey(id)) {
            Course course = courses.get(id);
            courses.remove(id);
            return course;
        } else {
            return null;
        }
    }
}
