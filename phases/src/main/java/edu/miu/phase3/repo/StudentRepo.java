package edu.miu.phase3.repo;

import edu.miu.phase3.domain.Course;
import edu.miu.phase3.domain.Student;
import edu.miu.phase3.dto.CourseDto;
import edu.miu.phase3.dto.StudentDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static final Map<Integer, Student> students = new HashMap<>();
    private static int currentId = 2;
    //id, firstName, lastName, email, major, gpa, and coursesTaken
    static {
        Course c1 = new Course(1, "Web Application Programming", "WAP");
        Course c2 = new Course(2, "Web Application Architecture", "WAA");

        Student s1 = new Student(1, "Adam", "Smith", "adam.smith@miu.edu", "MBA", 4.0f, List.of(c1));
        Student s2 = new Student(2, "Peter", "Pan", "peter.pan@miu.edu", "Compro", 3.8f, List.of(c1, c2) );

        students.put(s1.getId(), s1);
        students.put(s2.getId(), s2);
    }

    public Student add(Student s) {
        int id = currentId + 1;
        s.setId(id);
        students.put(s.getId(), s);
        return s;
    }

    public List<Student> findAll() {
        return students.values().stream().toList();
    }

    public Student update(int id, Student student) {
        if(students.containsKey(id)) {
            student.setId(id);
            students.replace(id, student);
            return student;
        } else {
            return null;
        }
    }

    public Student delete(int id) {
        if(students.containsKey(id)) {
            Student st = students.get(id);
            students.remove(id);
            return st;
        } else {
            return null;
        }
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public List<Course> getCourseByStudentId(int studentId) {
        if(students.containsKey(studentId)) {
            return students.get(studentId).getCoursesTaken();
        } else {
            return null;
        }
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.entrySet().stream().filter(entry -> major.toLowerCase().equals(entry.getValue().getMajor().toLowerCase()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
