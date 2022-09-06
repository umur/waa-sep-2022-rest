package edu.miu.restfuldemo.repo;

import edu.miu.restfuldemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private final List<Student> students = new ArrayList<>();
    private static int currentIndex = 0;

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
        Student student = get(id);
        if (student != null) {
            student = s;
        }
    }

    public void delete(int id) {
        Student student = get(id);
        if (student != null) {
            students.remove(student);
        }
    }
}
