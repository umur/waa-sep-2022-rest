package edu.miu.restws.database;

import edu.miu.restws.entity.Course;
import edu.miu.restws.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Student> STUDENTS = new ArrayList<>();

    public static List<Course> COURSES = new ArrayList<>();

    static {
        STUDENTS.addAll(initStudents());
        COURSES.addAll(initCourses());

        Student stu1 = STUDENTS.get(0);
        Student stu2 = STUDENTS.get(1);
        Student stu3 = STUDENTS.get(2);
        Student stu4 = STUDENTS.get(3);
        Student stu5 = STUDENTS.get(4);
        Student stu6 = STUDENTS.get(5);


        Course course0 = COURSES.get(0);
        Course course1 = COURSES.get(1);
        Course course2 = COURSES.get(2);
        Course course3 = COURSES.get(3);

        stu1.getCoursesTaken().add(course0);
        course0.getStudents().add(stu1);
        stu1.getCoursesTaken().add(course1);
        course1.getStudents().add(stu1);
        stu1.getCoursesTaken().add(course2);
        course2.getStudents().add(stu1);
        stu1.getCoursesTaken().add(course3);
        course3.getStudents().add(stu1);


        stu2.getCoursesTaken().add(course0);
        course0.getStudents().add(stu2);
        stu2.getCoursesTaken().add(course1);
        course1.getStudents().add(stu2);
        stu2.getCoursesTaken().add(course2);
        course2.getStudents().add(stu2);

        stu3.getCoursesTaken().add(course1);
        course1.getStudents().add(stu3);
        stu3.getCoursesTaken().add(course3);
        course3.getStudents().add(stu3);


        stu4.getCoursesTaken().add(course0);
        course0.getStudents().add(stu4);

        stu5.getCoursesTaken().add(course0);
        course0.getStudents().add(stu5);
        stu5.getCoursesTaken().add(course1);
        course1.getStudents().add(stu5);
        stu5.getCoursesTaken().add(course2);
        course2.getStudents().add(stu5);

        stu6.getCoursesTaken().add(course0);
        course0.getStudents().add(stu6);
        stu6.getCoursesTaken().add(course1);
        course1.getStudents().add(stu6);
        stu6.getCoursesTaken().add(course2);
        course2.getStudents().add(stu6);

    }

    private static List<Student> initStudents() {
        var students = new ArrayList<Student>();
        students.add(new Student(1, "Phat", "Nguyen", "phatnguyen@gmail.com", "Computer Science", 3.0f));
        students.add(new Student(2, "Ruby", "Nguyen", "ruby@gmail.com", "Business", 3.4f));
        students.add(new Student(3, "Vi", "Nguyen", "vi@gmail.com", "Computer Science", 3.5f));
        students.add(new Student(4, "John", "Smith", "john@gmail.com", "Computer Science", 3.0f));
        students.add(new Student(5, "David", "Smith", "david@gmail.com", "Computer Science", 3.0f));
        students.add(new Student(6, "Michael", "Smith", "michael@gmail.com", "Computer Science", 3.9f));


        return students;
    }

    private static List<Course> initCourses() {
        var courses = new ArrayList<Course>();
        courses.add(new Course(1, "MWA", "001"));
        courses.add(new Course(2, "WAP", "002"));
        courses.add(new Course(3, "MPP", "003"));
        courses.add(new Course(4, "WAA", "004"));
        return courses;
    }
}
