package com.waa.backend.service.impl;

import com.waa.backend.dto.CourseDTO;
import com.waa.backend.dto.StudentDTO;
import com.waa.backend.entity.Course;
import com.waa.backend.entity.Student;
import com.waa.backend.repo.StudentRepo;
import com.waa.backend.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepo studentRepo, ModelMapper modelMapper) {
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        System.out.println(major);
        List<Student> students = studentRepo.findAll().stream().filter(student -> Objects.equals(major, student.getMajor())).toList();
        return students.stream().map(student -> modelMapper.map(student, StudentDTO.class)).toList();
    }

    @Override
    public List<CourseDTO> getCoursesByStudentId(int studentId) {
        Student student = studentRepo.findById(studentId);
        return student.getCoursesTaken().stream().map(course -> modelMapper.map(course, CourseDTO.class)).toList();
    }

    @Override
    public void save(StudentDTO studentDTO) {
        var student = modelMapper.map(studentDTO, Student.class);
        studentRepo.save(student);
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepo.findAll().stream().map(student -> modelMapper.map(student, StudentDTO.class)).toList();
    }

    @Override
    public Student findById(int id) {
        return studentRepo.findById(id);
    }

}
