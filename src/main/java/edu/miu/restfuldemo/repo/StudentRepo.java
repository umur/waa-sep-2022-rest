package edu.miu.restfuldemo.repo;

import edu.miu.restfuldemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class StudentRepo {
    private final List<Student> students = new ArrayList<>();
    private static int currentIndex = 1;

    public Stream<Student> filter(Predicate<? super Student> predicate) {
        return students.stream().filter(predicate);
    }

    public List<Student> getAll() {
        return students;
    }

    public Student get(int id) {
        return students.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public Student add(Student s) {
        s.setId(currentIndex++);
        students.add(s);

        return s;
    }

    public void update(int id, Student s) {
        students.stream()
                .filter(d -> d.getId() == id)
                .findAny()
                .ifPresent(d -> {
                    d.setFirstName(s.getFirstName());
                    d.setLastName(s.getLastName());
                    d.setEmail(s.getEmail());
                    d.setGpa(s.getGpa());
                    d.setMajor(s.getMajor());
                    d.setCoursesTaken(s.getCoursesTaken());
                });
    }

    public void delete(int id) {
        students.removeIf(c -> c.getId() == id);
    }
}
