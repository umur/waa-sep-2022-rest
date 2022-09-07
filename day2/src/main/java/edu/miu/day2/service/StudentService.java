package edu.miu.day2.service;

import edu.miu.day2.entity.Course;
import edu.miu.day2.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public Student createAStudent(Student student);

    List<Student>  getAllStudents();

    Student getAStudent(Long id);

    Student updateStudent(Long id, Student student);

    Student deleteStudent(Long id);
    public List<Student> getAllStudentsByMajor(String major);
    public List<Course> getAllCourseByStudentId(int studentId);

}
