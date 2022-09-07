package com.example.restfulapi.Service.Impl;

import com.example.restfulapi.Model.Course;
import com.example.restfulapi.Model.Student;
import com.example.restfulapi.Repository.StudentRepo;
import com.example.restfulapi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return studentRepo.getAllStudents();
    }

    @Override
    public void add(Student student) {
        studentRepo.saveStudent(student);
    }

    @Override
    public void updateStudent(int id, Student student) {
        studentRepo.updateStudent(id,student);
    }

    @Override
    public void deleteStudent(int id){
        studentRepo.deleteStudent(id);
    }

    @Override
    public List<Student> getAllStudentsByMajor(String major) {
      return  studentRepo.getAllStudentByMajor(major);
    }

    @Override
    public List<Course>getAllCoursesByStudentId(int id){
        return studentRepo.getAllCoursesByStudentId(id);
    }

}
