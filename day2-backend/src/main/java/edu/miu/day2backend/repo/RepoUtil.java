package edu.miu.day2backend.repo;

import edu.miu.day2backend.domain.Course;
import edu.miu.day2backend.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class RepoUtil {
    public static List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        Course c1 = new Course(1, "Fundamental Programming Practice", "FPP");
        Course c2 = new Course(2, "Modern Programming Practice", "MPP");
        Course c3 = new Course(3, "Modern Web Applications", "MWA");
        Course c4 = new Course(4, "Web Application Architecture", "WAA");

        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);
        return courses;
    }

    public static List<Course> getSelectedCourse() {
        List<Course> courses = new ArrayList<>();
        Course c1 = new Course(1, "Fundamental Programming Practice", "FPP");
        Course c2 = new Course(2, "Modern Programming Practice", "MPP");
        Course c4 = new Course(4, "Web Application Architecture", "WAA");

        courses.add(c1);
        courses.add(c2);
        courses.add(c4);
        return courses;
    }


    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        Student s1 = new Student(1, "Win", "Aung", "win@miu.edu", "CS", 4, getAllCourses());
        students.add(s1);

        Student s2 = new Student(2, "Hasiv", "Mo", "hasiv@miu.edu", "SE", 4, getSelectedCourse());
        students.add(s2);

        return students;
    }

}
