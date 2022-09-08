package com.waa.rest.services;

import com.waa.rest.models.Course;
import com.waa.rest.models.Student;
import com.waa.rest.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentService) {
        this.studentRepository = studentService;
    }

    public Student getStudentById(int id) {
        return this.studentRepository.findOne(id);
    }

    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }
    
    public Student create(Student student) {
        return this.studentRepository.create(student);
    }

    public void delete(int id) {
        this.studentRepository.delete(id);
    }
    
    public Student update(Student student) {
        return this.studentRepository.update(student);
    }

    public List<Student> getStudentsByMajor(String major) {
        return this.studentRepository.getStudentsByMajor(major);
    }

    public List<Course> getCoursesByStudentId(int id) {
        return  this.studentRepository.getCoursesByStudentId(id);
    }
}
