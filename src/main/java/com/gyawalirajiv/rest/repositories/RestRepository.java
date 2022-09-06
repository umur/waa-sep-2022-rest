package com.gyawalirajiv.rest.repositories;

import com.gyawalirajiv.rest.models.Course;
import com.gyawalirajiv.rest.models.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RestRepository {

    private static List<Course> courses;
    private static List<Student> students;

    static {
        courses = new ArrayList<>();
        students = new ArrayList<>();

        Course c1 = new Course(1, "FPP", 101);
        Course c2 = new Course(2, "MPP", 102);
        Course c3 = new Course(3, "WAA", 103);
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);

        Student s1 = new Student(1, "Rajiv", "Gyawali", "gyawalirajiv@gmail.com", "Compro",
                4, new ArrayList<>());
        s1.getCourseList().add(c1);
        s1.getCourseList().add(c3);
        Student s2 = new Student(2, "Pradip", "Dhungel", "pradipdhungel@gmail.com", "Compro",
                4, new ArrayList<>());
        s2.getCourseList().add(c1);
        Student s3 = new Student(3, "Sushil", "Subedi", "sushilsubedi@gmail.com", "Compro",
                4, new ArrayList<>());
        s3.getCourseList().add(c2);
        s3.getCourseList().add(c3);
        students.add(s1);
        students.add(s2);
        students.add(s3);
    }

    public Course createCourse(Course course) {
        courses.add(course);
        return course;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Course getCourse(Long id) {
        return courses.stream().filter(c -> c.getId() == id.intValue()).findAny().orElseThrow(() -> new RuntimeException("Does not Exists!"));
    }

    public Course updateCourse(Long id, Course course) {
        Course cur = courses.stream().filter(c -> c.getId() == id.intValue()).findAny().orElseThrow(() -> new RuntimeException("Does not Exists!"));
        cur.setName(course.getName());
        cur.setCode(course.getCode());
        return cur;
    }

    public Course deleteCourse(Long id) {
        Course course = courses.stream().filter(c -> c.getId() == id.intValue()).findAny().orElseThrow(() -> new RuntimeException("Does not Exists!"));
        List<Course> coursesTemp = courses.stream().filter(c -> c.getId() != id.intValue()).collect(Collectors.toList());
        courses = coursesTemp;
        return course;
    }

    public Student createStudent(Student student) {
        students.add(student);
        return student;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudent(Long id) {
        return students.stream().filter(s -> s.getId() == id.intValue()).findAny().orElseThrow(() -> new RuntimeException("Does not Exists!"));
    }

    public Student updateStudent(Long id, Student student) {
        Student stu = students.stream().filter(s -> s.getId() == id.intValue()).findAny().orElseThrow(() -> new RuntimeException("Does not Exists!"));
        stu.setFirstName(student.getFirstName());
        stu.setLastName(student.getLastName());
        stu.setEmail(student.getEmail());
        stu.setGpa(student.getGpa());
        stu.setMajor(student.getMajor());
        stu.setCourseList(student.getCourseList());
        return stu;
    }

    public Student deleteStudent(Long id) {
        Student student = students.stream().filter(s -> s.getId() == id.intValue()).findAny().orElseThrow(() -> new RuntimeException("Does not Exists!"));
        List<Student> studentsTemp = students.stream().filter(s -> s.getId() != id.intValue()).collect(Collectors.toList());
        students = studentsTemp;
        return student;
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream().filter(s -> s.getMajor().equals(major)).collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return students.stream().filter(s -> s.getId() == studentId).findAny()
                .orElseThrow(() -> new RuntimeException("Student Does not Exists"))
                .getCourseList();
    }
}
