package edu.miu.phase2.repo;


import edu.miu.phase2.dto.CourseDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CourseRepo {
    private static final Map<Integer, CourseDto> courses = new HashMap<>();
    private static int currentId = 2;
    static {
        CourseDto c1 = new CourseDto(1, "Web Application Programming", "WAP");
        CourseDto c2 = new CourseDto(2, "Web Application Architecture", "WAA");

        courses.put(c1.getId(), c1);
        courses.put(c2.getId(), c2);
    }

    public CourseDto add (CourseDto c) {
        c.setId(currentId++);
        courses.put(c.getId(), c);
        return c;
    }

    public List<CourseDto> findAll() {
        return courses.values().stream().toList();
    }

    public CourseDto getCourseById(int id) {
        return courses.get(id);
    }

    public CourseDto updateCourse(int id, CourseDto course) {
        if(courses.containsKey(id)) {
            course.setId(id);
            courses.replace(id, course);
            return course;
        } else {
            return null;
        }
    }

    public CourseDto deleteCourseById(int id) {
        if(courses.containsKey(id)) {
            CourseDto course = courses.get(id);
            courses.remove(id);
            return course;
        } else {
            return null;
        }
    }
}
