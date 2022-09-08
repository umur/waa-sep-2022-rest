package edu.miu.phase2.repo;

import edu.miu.phase1.domain.Course;
import edu.miu.phase1.domain.Student;
import edu.miu.phase2.dto.CourseDto;
import edu.miu.phase2.dto.StudentDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static final Map<Integer, StudentDto> students = new HashMap<>();
    private static int currentId = 2;
    //id, firstName, lastName, email, major, gpa, and coursesTaken
    static {
        CourseDto c1 = new CourseDto(1, "Web Application Programming", "WAP");
        CourseDto c2 = new CourseDto(2, "Web Application Architecture", "WAA");

        StudentDto s1 = new StudentDto(1, "Adam", "Smith", "adam.smith@miu.edu", "MBA", 4.0f, List.of(c1));
        StudentDto s2 = new StudentDto(2, "Peter", "Pan", "peter.pan@miu.edu", "Compro", 3.8f, List.of(c1, c2) );

        students.put(s1.getId(), s1);
        students.put(s2.getId(), s2);
    }

    public StudentDto add(StudentDto s) {
        s.setId(currentId++);
        students.put(s.getId(), s);
        return s;
    }

    public List<StudentDto> findAll() {
        return students.values().stream().toList();
    }

    public StudentDto update(int id, StudentDto student) {
        if(students.containsKey(id)) {
            student.setId(id);
            students.replace(id, student);
            return student;
        } else {
            return null;
        }
    }

    public StudentDto delete(int id) {
        if(students.containsKey(id)) {
            StudentDto st = students.get(id);
            students.remove(id);
            return st;
        } else {
            return null;
        }
    }

    public StudentDto getStudentById(int id) {
        return students.get(id);
    }

    public List<CourseDto> getCourseByStudentId(int studentId) {
        if(students.containsKey(studentId)) {
            return students.get(studentId).getCoursesTaken();
        } else {
            return null;
        }
    }

    public List<StudentDto> getStudentsByMajor(String major) {
        return students.entrySet().stream().filter(entry -> major.toLowerCase().equals(entry.getValue().getMajor().toLowerCase()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
