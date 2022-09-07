package miu.edu.restfuldemo.repository;

import miu.edu.restfuldemo.entity.Course;
import miu.edu.restfuldemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    List<Student> students = new ArrayList<>();
    private int currentId;
    public void add(Student student) {
        student.setId(++currentId);
        students.add(student);
    }

    public List<Student> findAll() {
        return students;
    }

    public Student getById(int id) {
        return students.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void delete(int id) {
        students.removeIf(c -> c.getId() == id);
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream().filter(c -> c.getMajor().equals(major)).collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int id) {
        Student student = students
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst().orElse(null);
        return student.getCoursesTaken();
    }
}
