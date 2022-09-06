package edu.miu.phase1.service;

import edu.miu.phase1.entity.Course;
import edu.miu.phase1.entity.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public Student findById(int id);
    public void save(Student student);

    public void delete(int id);
    public void update(int id, Student student);
    public List<Student> getStudentsByMajor(String major );
    public List<Course> getCoursesByStudentId(int studentId);
}
