package com.miu.school.service.impl;

import com.miu.school.entity.Course;
import com.miu.school.entity.Student;
import com.miu.school.repo.StudentRepository;
import com.miu.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return  studentRepository.getAllStudents();
    }
    public void saveNewStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteSpecificStudent(int id) {
        studentRepository.deleteStudentById(id);
    }
    public void updateSpecificCourse(Student student,int id){
        studentRepository.updateStudent(student,id);
    }

    public List<Student> getStudentsByMajor(String major){
        return studentRepository.getStudentByMajor(major);
    }

    public List<Course> getCourseByStudentId(int id) {
        return studentRepository.getCourseByStudentId(id);
    }
}
