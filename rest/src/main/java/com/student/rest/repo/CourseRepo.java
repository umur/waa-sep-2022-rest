package com.student.rest.repo;

import com.student.rest.dto.CourseDto;
import com.student.rest.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private static int id = 4;
    private static List<CourseDto> courses = new ArrayList<>();

    static {
        CourseDto course1 = new CourseDto(1, "FPP", "CS401");
        CourseDto course2 = new CourseDto(2, "MPP", "CS421");
        CourseDto course3 =  new CourseDto(3, "WAP", "CS431");
        CourseDto course4 =  new CourseDto(4, "WAA", "CS501");

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
    }



    public CourseDto addCourse (CourseDto course) {
        id = id + 1;
        course.setId(id);
        courses.add(course);
        return course;
    }

    public List<CourseDto> getCourses () {
        System.out.println(courses);
        return courses;
    }

    public boolean updateCourse (CourseDto course, int id) {
        int index = 0;
        for (CourseDto c : courses) {
            if (id == c.getId()) {
                courses.set(index, course);
                return true;
            }
            index++;
        }
        return false;
    }

    public boolean deleteCourse (int id) {
        int index = 0;
        for (CourseDto c : courses) {
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
