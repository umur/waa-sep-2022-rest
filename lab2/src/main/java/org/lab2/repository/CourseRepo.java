package org.lab2.repository;

import org.lab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private static final List<Course> courses = new ArrayList<>();
    private static int courseID=3;
    static {
        Course c1 = new Course(1,"WAA","545");
        Course c2 = new Course(2,"WAP","427");
        Course c3 = new Course(3,"MPP","401");
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
    }

    public void add(Course course){
        course.setId(++courseID);
        courses.add(course);
    }

    public  List<Course> getCourses()
    {
        return  courses;
    }
    public Course update(Course course){
        for (Course c:courses){
            if(c.getId().equals(course.getId())){

                int index = courses.indexOf(c);
               courses.set(index,course);
               break;
            }
        }
        return course;

    }
    public void delete(Integer courseID){
        courses.removeIf(c -> c.getId().equals(courseID));

    }
}
