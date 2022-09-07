package edu.miu.day2backend.repo;

import edu.miu.day2backend.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static List<Student> students = new ArrayList<>();

    private static int studentId = 2;
    static {
        students = RepoUtil.getAllStudents();
    }

    public void add(Student s) {
        s.setId(++studentId);
        students.add(s);
    }

    public Student findById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().get();
    }

    public List<Student> findAll() {
        return students;
    }

    public void update(Student student, int id) {
        System.out.println(student);

        students = students.stream().map( s -> {
            if (s.getId() == id) {
                s = student;
                System.out.println("Updating student");
            }
            return s;
        }
        ).collect(Collectors.toList());
    }

    public void delete(int id) {
        students = students.stream().filter(s -> s.getId() != id).collect(Collectors.toList());
    }

}
