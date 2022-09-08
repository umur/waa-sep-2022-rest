package com.waa.backend.repo;

import com.waa.backend.entity.Course;
import com.waa.backend.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private final CourseRepo courseRepo;
    private List<Student> students = new ArrayList<>();

    private static int currentId = 2;

    public StudentRepo(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;

        init();
    }

    private void init() {
        List<Course> courses = courseRepo.findAll();

        Student student = new Student(1, "Paul", "Schultz", "paul.schultz@email.com", "Computer Science", 3.76, courses);
        Student student1 = new Student(2, "Paulina", "Anne-Marie", "paulinaannemarie@email.com", "Computer Science", 4.0, courses);

        students.add(student);
        students.add(student1);
    }

    public void save(Student student) {
        student.setId(currentId++);
        students.add(student);
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().get();
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }
}
