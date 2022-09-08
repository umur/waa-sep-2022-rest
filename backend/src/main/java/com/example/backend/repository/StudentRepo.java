package com.example.backend.repository;

import com.example.backend.dataStore.DataStore;
import com.example.backend.entity.Course;
import com.example.backend.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class StudentRepo {
    private final DataStore dataStore;

    public List<Student> getAll(){
        return dataStore.getStudents();
    }

    public void save(Student student){
        dataStore.getStudents().add(student);
    }

    public Student getById(int id){
        return dataStore.getStudents()
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElse(null);
    }

    public void update(int id, Student updatedStudent){
        Student foundStudent = dataStore.getStudents()
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElse(null);
        int studentIndex = dataStore.getStudents().indexOf(foundStudent);
        dataStore.getStudents().set(studentIndex, updatedStudent);
    }

    public void delete(int id){
        Student foundStudent = dataStore.getStudents()
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElse(null);
        dataStore.getStudents().remove(foundStudent);
    }


    public List<Student> getByMajor(String major) {
        return dataStore.getStudents()
                .stream()
                .filter(student -> student.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getStudentCourses(int id) {
        return dataStore.getStudents()
                .stream()
                .filter(student -> student.getId() == id)
                .map(Student::getCourses)
                .findFirst().orElse(new ArrayList<>());
    }

    public Student create(Student student) {
        student.setId(dataStore.getStudents().size() + 1);
        dataStore.getStudents().add(student);
        return student;
    }
}
