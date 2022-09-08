package com.waa.rest.repositories;

import com.waa.rest.models.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static Map<Integer, Student> student = new HashMap<Integer, Student>();
    public Student create(Student course) {
        return student.putIfAbsent(course.getId(), course);
    }
    public Student findOne(int id) {
        return student.get(id);
    }
    public void delete(int id) {
        student.remove(id);
    }
    public Student update(Student student) {
       return StudentRepository.student.put(student.getId(), student);
    }
    public List<Student> findAll() {
        return student.values().stream().collect(Collectors.toList());
    }
}
