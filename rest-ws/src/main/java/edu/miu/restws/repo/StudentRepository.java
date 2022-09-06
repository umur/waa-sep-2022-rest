package edu.miu.restws.repo;

import edu.miu.restws.database.DataSource;
import edu.miu.restws.entity.Student;
import edu.miu.restws.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    private static int currentId = 7;

    public List<Student> getStudentsByMajor(String major) {
        return DataSource.STUDENTS.stream().filter(s -> s.getMajor().equalsIgnoreCase(major)).toList();
    }

    public void save(Student student) {
        student.setId(currentId++);
        DataSource.STUDENTS.add(student);
    }

    public void delete(int id) {
        Student student = DataSource.STUDENTS.stream()
                .filter(s -> s.getId() == id)
                .findAny()
                .orElseGet(null);

        if(student != null) {
            DataSource.STUDENTS.remove(student);
        }
    }

    public void update(Student student) {
        DataSource.STUDENTS.stream()
                .filter(s -> s.getId().intValue() == student.getId().intValue())
                .findAny()
                .ifPresent(s -> {
                    s.setFirstName(student.getFirstName());
                    s.setLastName(student.getLastName());
                    s.setEmail(student.getLastName());
                    s.setGpa(student.getGpa());
                });
    }

    public List<Student> getAllStudents() {
        return DataSource.STUDENTS;
    }

    public Student getById(int id) {
        return DataSource.STUDENTS.stream()
                .filter(s -> s.getId() == id)
                .findAny()
                .orElseThrow(() -> new NotFoundException("Cannot find student with id: " + id));
    }

}
