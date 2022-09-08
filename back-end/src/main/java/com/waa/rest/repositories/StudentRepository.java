package com.waa.rest.repositories;

import com.waa.rest.models.Course;
import com.waa.rest.models.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static Map<Integer, Student> students = new HashMap<Integer, Student>();
    public Student create(Student course) {
        return students.putIfAbsent(course.getId(), course);
    }
    public Student findOne(int id) {
        return students.get(id);
    }
    public void delete(int id) {
        students.remove(id);
    }
    public Student update(Student student) {
       return StudentRepository.students.put(student.getId(), student);
    }
    public List<Student> findAll() {
        return students.values().stream().collect(Collectors.toList());
    }
    public List<Student> getStudentsByMajor(String major) {
        return students.values()
                .stream()
                .filter(student -> student.getMajor() == major)
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int id) {
        return students.get(id).getCoursesTaken();
    }
}
