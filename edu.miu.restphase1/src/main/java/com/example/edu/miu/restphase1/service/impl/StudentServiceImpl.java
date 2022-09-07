package com.example.edu.miu.restphase1.service.impl;

import com.example.edu.miu.restphase1.entity.Course;
import com.example.edu.miu.restphase1.entity.Student;
import com.example.edu.miu.restphase1.repository.StudentRepo;
import com.example.edu.miu.restphase1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public void save(Student student){
        studentRepo.save(student);
    }
    @Override
    public void update(Student student){
        studentRepo.update(student);
    }
    @Override
    public void delete(int id){
        studentRepo.delete(id);
    }
    @Override
    public Student getById(int id){
        return studentRepo.getById(id);
    }
    @Override
    public List<Student> getAll(){
        return studentRepo.getAll();
    }
    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }
}
