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
    private static List<Student> students = new ArrayList<>() {{
        new Student(1, "Asjad", "Anis", "xyz@gmail.com", "Compro", 4.00, new ArrayList<Course>(){{
            new Course(1, "FPP", "CS401");
            new Course(2, "MPP", "CS421");
            new Course(3, "WAP", "CS431");
            new Course(4, "WAA", "CS501");
        }});
        new Student(2, "John", "Doe", "xyz1@gmail.com", "Compro", 3.90, new ArrayList<Course>(){{
            new Course(1, "FPP", "CS401");
            new Course(2, "MPP", "CS421");
            new Course(4, "WAA", "CS501");
            new Course(3, "WAP", "CS431");
        }});
        new Student(3, "Jane", "Doe", "xyz123@gmail.com", "Compro", 4.00, new ArrayList<Course>(){{
            new Course(1, "FPP", "CS401");
            new Course(2, "MPP", "CS421");
            new Course(3, "SA", "CS531");
            new Course(4, "EA", "CS511");
        }});
        new Student(4, "Bob", "Lee", "xyz128@gmail.com", "Compro", 3.44, new ArrayList<Course>(){{
            new Course(1, "FPP", "CS401");
            new Course(2, "MPP", "CS421");
            new Course(4, "EA", "CS511");
            new Course(4, "WAA", "CS501");
        }});
    }};

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
        Student std = (Student) students.stream().filter(student -> student.getId() == studentId).collect(Collectors.toList());
        if (std == null) {
            return new ArrayList<Course>();
        }
        return std.getCoursesTaken();
    }
}
