package com.ultrates.lab2phase1.service.impl;


import com.ultrates.lab2phase1.model.Course;
import com.ultrates.lab2phase1.model.Student;
import com.ultrates.lab2phase1.repo.StudentRepo;
import com.ultrates.lab2phase1.service.StudentService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public void save(Student s) {
    studentRepo.save(s);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public Student getById(int id) {
        return studentRepo.getById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepo.getCoursesByStudentId(id);
    }
}
