package com.miu.school.service.impl;

import com.miu.school.dto.StudentDTO;
import com.miu.school.entity.Course;
import com.miu.school.entity.Student;
import com.miu.school.repo.StudentRepository;
import com.miu.school.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<StudentDTO> getAllStudents(){
        return  studentRepository.getAllStudents().stream().map(student -> modelMapper.map(student,StudentDTO.class)).collect(Collectors.toList());
    }
    public void saveNewStudent(StudentDTO student) {
        studentRepository.save(modelMapper.map(student,Student.class));
    }

    public void deleteSpecificStudent(int id) {
        studentRepository.deleteStudentById(id);
    }
    public void updateSpecificCourse(StudentDTO student,int id){
        studentRepository.updateStudent(modelMapper.map(student,Student.class),id);
    }

    public List<Student> getStudentsByMajor(String major){
        return studentRepository.getStudentByMajor(major);
    }

    public List<Course> getCourseByStudentId(int id) {
        return studentRepository.getCourseByStudentId(id);
    }
}
