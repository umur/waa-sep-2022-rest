package edu.miu.phase1.service;

import edu.miu.phase1.domain.Course;
import edu.miu.phase1.domain.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);

    List<Student> findAll();

    Student findById(int id);

    Student update(int id, Student student);

    Student delete(int id);

    List<Course> getCourseByStudentId(int studentId);

    List<Student> getStudentsByMajor(String major);
}
