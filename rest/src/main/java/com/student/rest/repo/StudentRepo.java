package com.student.rest.repo;

import com.student.rest.model.Course;
import com.student.rest.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static int id = 4;
    private static List<Student> students = new ArrayList<>();

    static {
        Course c1 = new Course(1, "FPP", "CS401");
        Course c2 = new Course(2, "MPP", "CS421");
        Course c3 = new Course(3, "WAP", "CS431");
        Course c4 = new Course(4, "WAA", "CS501");
        Course c5 = new Course(5, "SA", "CS531");
        Course c6 =  new Course(6, "EA", "CS511");

        ArrayList<Course> std1Courses = new ArrayList<>();
        std1Courses.add(c1);
        std1Courses.add(c2);
        std1Courses.add(c3);
        std1Courses.add(c4);

        ArrayList<Course> std2Courses = new ArrayList<>();
        std2Courses.add(c1);
        std2Courses.add(c2);
        std2Courses.add(c5);
        std2Courses.add(c4);

        ArrayList<Course> std3Courses = new ArrayList<>();
        std3Courses.add(c1);
        std3Courses.add(c2);
        std3Courses.add(c6);
        std3Courses.add(c4);

        ArrayList<Course> std4Courses = new ArrayList<>();
        std4Courses.add(c1);
        std4Courses.add(c2);
        std4Courses.add(c5);
        std4Courses.add(c6);

        Student std1 = new Student(1, "Asjad", "Anis", "xyz@gmail.com", "Compro", 4.00, std1Courses);
        Student std2 = new Student(2, "John", "Doe", "xyz1@gmail.com", "Compro", 3.90, std2Courses);
        Student std3 = new Student(3, "Jane", "Doe", "xyz123@gmail.com", "Compro", 4.00, std3Courses);
        Student std4 = new Student(4, "Bob", "Lee", "xyz128@gmail.com", "Compro", 3.44, std4Courses);

        students.add(std1);
        students.add(std2);
        students.add(std3);
        students.add(std4);
    }

    public void addStudent(Student std) {
        std.setId(id++);
        students.add(std);
    }

    public List<Student> getStudents () {
        return students;
    }

    public boolean updateStudent (Student course) {
        int index = 0;
        for (Student s : students) {
            if (s.getId() == course.getId()) {
                students.set(index, course);
                return true;
            }
            index++;
        }
        return false;
    }

    public boolean deleteStudent (int id) {
        int index = 0;
        for (Student c : students) {
            if (c.getId() == id) {
                students.remove(index);
                return true;
            }
            index++;
        }
        return false;
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream().filter(student -> student.getMajor().equals(major)).collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        Student std = students.stream().filter(student -> student.getId() == studentId).collect(Collectors.toList()).get(0);
        if (std == null) {
            return new ArrayList<Course>();
        }
        return std.getCoursesTaken();
    }

    public boolean exists(int id) {
        return students.stream().filter(student -> student.getId() == id).collect(Collectors.toList()).size() == 1;
    }
}
