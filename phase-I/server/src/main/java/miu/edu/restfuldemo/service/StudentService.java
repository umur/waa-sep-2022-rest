package miu.edu.restfuldemo.service;

import miu.edu.restfuldemo.entity.Course;
import miu.edu.restfuldemo.entity.Student;
import java.util.List;

public interface StudentService {
    void save(Student student);
    List<Student> findAll();
    Student getById(int id);
    void delete(int id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int id);
}
