package com.example.backend.dataStore;

import com.example.backend.entity.Course;
import com.example.backend.entity.Student;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataStore {
    private final List<Course> courses = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();

    public DataStore(){
        initMockCourses();
        initMockStudent();
        makeMockRelations();
    }

    private void initMockCourses() {
        courses.add(new Course(1, "MPP", "CS401", new ArrayList<>()));
        courses.add(new Course(2, "ASD", "CS525", new ArrayList<>()));
        courses.add(new Course(3, "EA", "CS540", new ArrayList<>()));
        courses.add(new Course(4, "WAA", "CS545", new ArrayList<>()));
    }

    private void initMockStudent() {
        students.add(new Student(1, "Mo", "You", "student1@example.com", "CS", 4.0, new ArrayList<>()));
        students.add(new Student(2, "Student2firstname", "Student2lastname", "student2@example.com", "Commerce", 3.56, new ArrayList<>()));
        students.add(new Student(3, "Student3firstname", "Student3lastname", "student3@example.com", "Accounting", 3.78, new ArrayList<>()));
    }

    private void makeMockRelations(){
        Course course1 = courses.get(0);
        Course course2 = courses.get(1);
        Course course3 = courses.get(2);
        Course course4 = courses.get(3);

        Student student1 = students.get(0);
        Student student2 = students.get(1);
        Student student3 = students.get(2);

        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        student1.getCourses().add(course3);
        student1.getCourses().add(course4);

        course1.getStudents().add(student1);
        course1.getStudents().add(student2);
        course1.getStudents().add(student3);

        course2.getStudents().add(student1);
        course2.getStudents().add(student2);
        course2.getStudents().add(student3);

        course3.getStudents().add(student1);
        course3.getStudents().add(student2);
        course3.getStudents().add(student3);

        course4.getStudents().add(student1);
        course4.getStudents().add(student2);
        course4.getStudents().add(student3);
    }

}
