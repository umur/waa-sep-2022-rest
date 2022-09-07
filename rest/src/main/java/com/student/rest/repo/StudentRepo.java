package com.student.rest.repo;

import com.student.rest.dto.CourseDto;
import com.student.rest.dto.StudentDto;
import com.student.rest.model.Course;
import com.student.rest.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static int id = 4;
    private static List<StudentDto> students = new ArrayList<>();

    static {
        CourseDto c1 = new CourseDto(1, "FPP", "CS401");
        CourseDto c2 = new CourseDto(2, "MPP", "CS421");
        CourseDto c3 = new CourseDto(3, "WAP", "CS431");
        CourseDto c4 = new CourseDto(4, "WAA", "CS501");
        CourseDto c5 = new CourseDto(5, "SA", "CS531");
        CourseDto c6 =  new CourseDto(6, "EA", "CS511");

        ArrayList<CourseDto> std1Courses = new ArrayList<>();
        std1Courses.add(c1);
        std1Courses.add(c2);
        std1Courses.add(c3);
        std1Courses.add(c4);

        ArrayList<CourseDto> std2Courses = new ArrayList<>();
        std2Courses.add(c1);
        std2Courses.add(c2);
        std2Courses.add(c5);
        std2Courses.add(c4);

        ArrayList<CourseDto> std3Courses = new ArrayList<>();
        std3Courses.add(c1);
        std3Courses.add(c2);
        std3Courses.add(c6);
        std3Courses.add(c4);

        ArrayList<CourseDto> std4Courses = new ArrayList<>();
        std4Courses.add(c1);
        std4Courses.add(c2);
        std4Courses.add(c5);
        std4Courses.add(c6);

        StudentDto std1 = new StudentDto(1, "Asjad", "Anis", "xyz@gmail.com", "Compro", 4.00, std1Courses);
        StudentDto std2 = new StudentDto(2, "John", "Doe", "xyz1@gmail.com", "Compro", 3.90, std2Courses);
        StudentDto std3 = new StudentDto(3, "Jane", "Doe", "xyz123@gmail.com", "Compro", 4.00, std3Courses);
        StudentDto std4 = new StudentDto(4, "Bob", "Lee", "xyz128@gmail.com", "Compro", 3.44, std4Courses);

        students.add(std1);
        students.add(std2);
        students.add(std3);
        students.add(std4);
    }

    public StudentDto addStudent(StudentDto std) {
        id = id + 1;
        std.setId(id);
        students.add(std);
        return std;
    }

    public List<StudentDto> getStudents () {
        return students;
    }

    public boolean updateStudent (StudentDto student, int id) {
        int index = 0;
        for (StudentDto s : students) {
            if (id == s.getId()) {
                students.set(index, student);
                return true;
            }
            index++;
        }
        return false;
    }

    public boolean deleteStudent (int id) {
        int index = 0;
        for (StudentDto c : students) {
            if (c.getId() == id) {
                students.remove(index);
                return true;
            }
            index++;
        }
        return false;
    }

    public List<StudentDto> getStudentsByMajor(String major) {
        return students.stream().filter(student -> student.getMajor().equals(major)).collect(Collectors.toList());
    }

    public List<CourseDto> getCoursesByStudentId(int studentId) {
        StudentDto std = students.stream().filter(student -> student.getId() == studentId).collect(Collectors.toList()).get(0);
        if (std == null) {
            return new ArrayList<CourseDto>();
        }
        return std.getCoursesTaken();
    }

    public boolean exists(int id) {
        return students.stream().filter(student -> student.getId() == id).collect(Collectors.toList()).size() == 1;
    }
}
