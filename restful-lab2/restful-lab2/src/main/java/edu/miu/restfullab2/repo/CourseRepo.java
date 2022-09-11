package edu.miu.restfullab2.repo;

import edu.miu.restfullab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private static List<Course> courses =new ArrayList<>();
    private static int currCourseId =2;

    static{
        Course c1 =new Course(1, "WAA", "CS545");
        Course c2 =new Course(2, "WAP", "CS472");
        Course c3 =new Course(3, "SA", "CS590");

        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
    }

    public void add(Course c){
        c.setId(currCourseId++);
        courses.add(c);
    }
    public static List<Course> getCourses(){
        return courses;
    }

    public Course getById(int id) {
        return courses.get(id);
    }

    public Course createCourse(Course course) {
        courses.add(course);
        return course;
    }

    public int deleteCourse(int id) {
        courses = courses.stream().filter(x->x.getId() != id).toList();
        courses.remove(id);
        return id;
    }

    public Course updateCourse(int id, Course course) {
        courses.set(id, course);
        return course;
    }
}
